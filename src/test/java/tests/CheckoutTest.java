package tests;

import org.testng.annotations.Test;

import locators.PaymentLocators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductPage;
import utilities.ExcelUtils;

public class CheckoutTest extends BaseTest {


    @Test(dataProvider = "checkoutData", dataProviderClass = BaseTest.class)
    public void testSearch(String userType, String email, String password, int productCount, String addressType, int rowNum) throws Exception {
    	driver.manage().deleteAllCookies();
        homePage.navigateTo(ConfigReader.getAppUrl());
        boolean flag = false;
    	String result;
        if (userType.equalsIgnoreCase("registered")) {
        	homePage.clickMyAccount();
        	LoginPage loginPage = homePage.clickSignIn();
        	loginPage.enterEmail(email);
        	loginPage.enterPassword(password);
        	loginPage.clickLogin();
        	flag = loginPage.isLoginSuccessful();
        }
        
        System.out.println("productCount = " + productCount);
    	for (int i = 0; i < productCount; i++) {
    		if (userType == null || userType.trim().isEmpty()) continue;
    		ProductPage productPage = homePage.enterSearchField();	
    		Thread.sleep(2000);
    		productPage.ChooseProduct();
    		Assert.assertTrue(productPage.ProductName(), "Failed to find the product name");
    		Assert.assertTrue(productPage.ProductPrice(), "Failed to find the product price");
    		Assert.assertTrue(productPage.ProductImage(), "Failed to find the product image");
    	
    		productPage.AddProduct();
    		Thread.sleep(2000);
    	}
    	CartPage cartPage = new CartPage(driver);
		cartPage.ViewCart();
    	Thread.sleep(3000);
    	
    	CheckoutPage checkoutPage = cartPage.CheckoutButton();
    	Thread.sleep(2000);
    	PaymentPage paymentPage = new PaymentPage(driver);
    	 if (userType.equalsIgnoreCase("guest")) {
    	    checkoutPage.ContinueAsGuest();
    	    checkoutPage.enterEmail(email);
    	    paymentPage.EnterPaymentInfo();
    	    checkoutPage.ContinueButton();
       		paymentPage.EnterCardInfo();
       		Thread.sleep(5000);
    	 }
    	 else {
    		 if (addressType.equalsIgnoreCase("new")) {
    			 paymentPage.EnterNewAddress();
        		 checkoutPage.ContinueButton();
        		 paymentPage.EnterCardInfo();
    		 }
    		 else {
    		 checkoutPage.ChooseButton();
    		 checkoutPage.ContinueButton();
    		 paymentPage.EnterCardInfo();
    		 }
    	}
    	
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    
    	 WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(PaymentLocators.PLACE_ORDER));

    	
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", btn);
    	Thread.sleep(500); 
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

    	try {
    	    wait.until(ExpectedConditions.urlContains("orderId"));
    	    flag = paymentPage.OrderCompletion();
    	} catch (Exception e) {
    	    flag = false;
    	}
    	
    	result = flag ? "Pass" : "Fail";
     	ExcelUtils.write(result, rowNum, 5);
    	
    }
      
}