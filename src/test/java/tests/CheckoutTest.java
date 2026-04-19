package tests;

import org.testng.annotations.Test;
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
        	Assert.assertTrue(flag);
        }
        result = flag||userType.equalsIgnoreCase("guest") ? "Pass" : "Fail";
    	ExcelUtils.write(result, rowNum, 5);
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
    	 }
    	 else {
    		 checkoutPage.ChooseButton();
    		 checkoutPage.ContinueButton();
    		 paymentPage.EnterPaymentInfo();
    		 paymentPage.EnterCardInfo();
    	}
    	Thread.sleep(10000);
    	
    }
      
}