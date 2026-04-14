package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.PaymentPage;
import pages.ProductPage;
import utilities.ExcelUtils;

public class GuestCheckoutTest extends BaseTest {
	
	
    @Test()
    public void testSearch() throws InterruptedException {
    	
        homePage.navigateTo(ConfigReader.getAppUrl());
    	
    	ProductPage productPage = homePage.enterSearchField();
    	productPage.ChooseProduct();
    	Assert.assertTrue(productPage.ProductName(), "Failed to find the product name");
    	Assert.assertTrue(productPage.ProductPrice(), "Failed to find the product price");
    	Assert.assertTrue(productPage.ProductImage(), "Failed to find the product image");
    	
    	CartPage cartPage = productPage.AddProduct();
    	Thread.sleep(4000);
    	cartPage.ViewCart();
    	Thread.sleep(3000);
    	cartPage.NoThanks();
    	Thread.sleep(2000);
    	
    	CheckoutPage checkoutPage = cartPage.CheckoutButton();
    	Thread.sleep(2000);
    	checkoutPage.ContinueAsGuest();
    	String email = ExcelUtils.getCellData(1, 0);
        checkoutPage.enterEmail(email);
        PaymentPage paymentPage = new PaymentPage(driver);
    	paymentPage.EnterPaymentInfo();
    	checkoutPage.ContinueButton();
    	Thread.sleep(2000);
    	paymentPage.EnterCardInfo();
    	Thread.sleep(3000);   	
    	
    }
   
}
