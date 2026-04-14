package locators;

import org.openqa.selenium.By;

public class CartLocators {

	public static final By VIEW_CART = By.cssSelector("button.view-cart-btn.btn.btn-primary");
	
	public static final By NO_THANKS_BTN = By.cssSelector("button[data-analytics-name='cancel']");
	
	public static final By CHECKOUT_BTN = By.cssSelector("button.c-checkout-buttons__checkout.u-b1.btn.btn-primary");
}
