package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	public CheckoutPage CheckoutButton() throws InterruptedException {
		
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(CartLocators.CHECKOUT_BTN));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", btn);
		Thread.sleep(500);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("loading")));
		btn.click();
		
		return new CheckoutPage(driver);
	}

}
