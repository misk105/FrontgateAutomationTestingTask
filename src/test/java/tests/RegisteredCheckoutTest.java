package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductPage;
import utilities.ExcelUtils;

public class RegisteredCheckoutTest extends BaseTest {


    @Test()
    public void testSearch() throws Exception {
    
    	String email = ExcelUtils.getCellData(1, 0);
        String password = ExcelUtils.getCellData(1, 1);
        homePage.navigateTo(ConfigReader.getAppUrl());
        homePage.clickMyAccount();
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String result;
        boolean flag = loginPage.isLoginSuccessful();
        result = flag ? "Pass" : "Fail";
        ExcelUtils.write(result, 1, 2);
        Assert.assertTrue(flag);
        
    	 
    	ProductPage productPage = homePage.enterSearchField();
    	productPage.ChooseProduct();
    	Assert.assertTrue(productPage.ProductName(), "Failed to find the product name");
    	Assert.assertTrue(productPage.ProductPrice(), "Failed to find the product price");
    	Assert.assertTrue(productPage.ProductImage(), "Failed to find the product image");
    	
    	CartPage cartPage = productPage.AddProduct();
    	Thread.sleep(4000);
    	cartPage.ViewCart();
    	Thread.sleep(3000);
    	
    	CheckoutPage checkoutPage = cartPage.CheckoutButton();
    	Thread.sleep(2000);
    	checkoutPage.ChooseButton();
    	checkoutPage.ContinueButton();
    	
    	PaymentPage paymentPage = new PaymentPage(driver);
    	paymentPage.EnterPaymentInfo();
    	paymentPage.EnterCardInfo();
    	Thread.sleep(10000);
    	
    }
   
}
