package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import locators.CheckoutLocators;
import locators.LoginPageLocators;

public class CheckoutPage extends CartPage {
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ChooseButton() {
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.CHOOSE_BTN)).click();
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.CHOICE_BTN)).click();
	}
	
	public void ContinueButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.CONTINUE_BTN)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.KEEP_ADD)).click();
		Thread.sleep(4000);
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.NEXT_BTN));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
		Thread.sleep(4000);
	}
	
	public void ContinueAsGuest() {
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.CONTINUE_AS_GUEST)).click();
	}
	
	public void enterEmail(String email) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.EMAIL_FIELD));
        field.clear();
        field.sendKeys(email);
    }

}
