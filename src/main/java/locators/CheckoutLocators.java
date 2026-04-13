package locators;

import org.openqa.selenium.By;

public class CheckoutLocators {
	
	public static final By CHOOSE_BTN = By.cssSelector("button.c-button.c-custom-selectbox-multiple-dropdownbtn");
	
	public static final By CHOICE_BTN = By.id("428063");
	
	public static final By CONTINUE_BTN = By.cssSelector("button#shipping-next-btn");
	
	public static final By KEEP_ADD = By.xpath("//button[contains(@class,'btn-primary') and contains(.,'keep original address')]");
	
	public static final By NEXT_BTN = By.cssSelector("button#nextBtn");

}
