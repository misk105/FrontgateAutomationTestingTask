package locators;

import org.openqa.selenium.By;

public class CheckoutLocators {
	
	public static final By CHOOSE_BTN = By.cssSelector("button.c-button.c-custom-selectbox-multiple-dropdownbtn");
	
	public static final By CHOICE_BTN = By.id("428063");
	
	public static final By CONTINUE_BTN = By.cssSelector("button#shipping-next-btn");
	
	public static final By KEEP_ADD = By.xpath("//button[contains(@class,'btn-primary') and contains(.,'keep original address')]");
	
	public static final By NEXT_BTN = By.cssSelector("button#nextBtn");
	
	public static final By CONTINUE_AS_GUEST = By.cssSelector("button.c-continue-as-guest-button.btn.btn-primary");
	
	public static final By EMAIL_FIELD = By.cssSelector("input#checkout_step1_email");

}
