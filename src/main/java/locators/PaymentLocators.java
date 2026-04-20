package locators;

import org.openqa.selenium.By;

public class PaymentLocators {
	
	public static final By FIRST_NAME = By.cssSelector("input#fName");
	
	public static final By LAST_NAME = By.cssSelector("input#lName");
	
	public static final By STREEET_ADD = By.cssSelector("input[aria-label='Street Address*']");
	
	public static final By ZIP_CODE = By.cssSelector("input#zipbox");
	
	public static final By CARD_NUM = By.cssSelector("input#account-cc");
	
	public static final By EXP_DATE = By.cssSelector("input#exp-date");
	
	public static final By PLACE_ORDER = By.cssSelector("button.c-place-order__btn.u-w-sm-100.p-4.btn.btn-primary");
	
	public static final By NUMBER_FIELD = By.cssSelector("input#phone1box");
	
	public static final By ADD_ADDRESS = By.cssSelector("button.add-address-button.btn.btn-primary");
	
	public static final By SAVE_BTN = By.cssSelector("button.u-w-sm-100.save-btn.btn.btn-primary");
	
	public static final By ORDER_COMPLETED = By.cssSelector("p.t-checkout-confirmation__thank-you-widget__thank-message");

}
