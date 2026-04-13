package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import locators.PaymentLocators;

public class PaymentPage extends CheckoutPage{
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void EnterPaymentInfo() throws InterruptedException {
		WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentLocators.FIRST_NAME));
        field.clear();
        field.sendKeys("firstvisa");
        
        field = wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentLocators.LAST_NAME));
        field.clear();
        field.sendKeys("lastvisa");
        
        field = wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentLocators.STREEET_ADD));
        field.clear();
        field.sendKeys("Str. 245 Park ave");
        
        field = wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentLocators.ZIP_CODE));
        field.clear();
        field.sendKeys("10167");
        
        field = wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentLocators.CARD_NUM));
        field.clear();
        field.sendKeys("4000060000000006");
        
        field = wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentLocators.EXP_DATE));
        field.clear();
        field.sendKeys("0330");
        
        Thread.sleep(3000);
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentLocators.PLACE_ORDER));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
	}

}
