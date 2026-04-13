package tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import pages.CartPage;
import pages.CheckoutPage;
import pages.PaymentPage;
import pages.ProductPage;

public class SearchTest extends BaseTest {

    @Test()
    public void testSearch() throws InterruptedException {
    	 
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
    	Thread.sleep(10000);
    	
    }
   
}
