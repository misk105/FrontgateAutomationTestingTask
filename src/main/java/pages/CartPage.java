package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import locators.CartLocators;

public class CartPage extends ProductPage{
	
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ViewCart() {
		wait.until(ExpectedConditions.elementToBeClickable(CartLocators.VIEW_CART)).click();
	}
	
	public void NoThanks() {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(CartLocators.NO_THANKS_BTN)).click();
		} catch(Exception e) {}
	}
	public CheckoutPage CheckoutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(CartLocators.CHECKOUT_BTN)).click();
		
		return new CheckoutPage(driver);
	}

}
