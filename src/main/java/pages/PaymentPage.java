package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import locators.CheckoutLocators;
import locators.PaymentLocators;
import locators.ProductLocators;

public class PaymentPage extends CheckoutPage{
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void EnterNewAddress() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentLocators.ADD_ADDRESS)).click();
		Thread.sleep(2000);
		EnterPaymentInfo();
		wait.until(ExpectedConditions.elementToBeClickable(PaymentLocators.SAVE_BTN)).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.KEEP_ADD)).click();
		Thread.sleep(2000);
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
        
        field = wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentLocators.NUMBER_FIELD));
        field.clear();
        field.sendKeys("770-065-5941");
	}
        
     public void EnterCardInfo() throws InterruptedException {
        
    	 WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentLocators.CARD_NUM));
        field.clear();
        field.sendKeys("4000060000000006");
        
        field = wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentLocators.EXP_DATE));
        field.clear();
        field.sendKeys("0330");
        
        Thread.sleep(2000);
	}
     
     public boolean OrderCompletion() {
    	 try{
    		 wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentLocators.ORDER_COMPLETED));
    		 return true;
    	 }catch(Exception e) {
    		 return false;
    	 }
     }

}
