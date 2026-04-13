package locators;

import org.openqa.selenium.By;

public class ProductLocators {

	public static final By RESULT_ITEM = By.cssSelector("a.c-link.c-product-item-title-link");
	
	public static final By PROD_NAME = By.cssSelector("div.t-universal-product-details-heading-info__title");
	
	public static final By PROD_PRICE = By.cssSelector("div.c-universal-price-new.c--is-current-price");
	
	public static final By PROD_IMG = By.cssSelector("img.c-image.d-block");
	
	public static final By ADD_TO_CART_BTN = By.cssSelector("button.c-universal-add-to-cart.btn-primary");
	
}
