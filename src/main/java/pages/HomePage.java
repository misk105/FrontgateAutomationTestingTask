package pages;

import locators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void clickMyAccount() {
    	WebElement accountBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.MY_ACCOUNT_BTN));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountBtn).perform();
    }

    public LoginPage clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(HomePageLocators.SIGN_IN_LINK)).click();
        return new LoginPage(driver); 
    }
    
    public ProductPage enterSearchField() throws InterruptedException {
    	WebElement searchbar = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.SEARCH_FIELD));
    	searchbar.clear();
    	searchbar.sendKeys("stainless");
    	wait.until(ExpectedConditions.elementToBeClickable(HomePageLocators.SEARCH_BTN)).click();
    	return new ProductPage(driver);
    }  
    
}