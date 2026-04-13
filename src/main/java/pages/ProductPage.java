package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import locators.ProductLocators;

public class ProductPage extends HomePage{

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ChooseProduct() {
		wait.until(ExpectedConditions.elementToBeClickable(ProductLocators.RESULT_ITEM)).click();
	}
	
	public boolean ProductName() {
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ProductLocators.PROD_NAME));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean ProductPrice() {
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ProductLocators.PROD_PRICE));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean ProductImage() {
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ProductLocators.PROD_IMG));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public CartPage AddProduct() throws InterruptedException {
		
		try {
	        WebElement cookie = driver.findElement(By.cssSelector("button.c-button.c-icon-label-button.c-custom-sheet__close-button.c-cookie-banner__close-button"));
	        cookie.click();
	    } catch (Exception e) {}

		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(ProductLocators.ADD_TO_CART_BTN));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", btn);

		Thread.sleep(500);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("loading")));
		btn.click();
		
		return new CartPage(driver);
	}

}
