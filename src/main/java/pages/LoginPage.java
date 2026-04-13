package pages;

import locators.LoginPageLocators;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait; 

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.EMAIL_FIELD));
        field.clear();
        field.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.PASSWORD_FIELD));
        field.clear();
        field.sendKeys(password);
    }

    public void clickLogin() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(LoginPageLocators.LOGIN_BUTTON));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }
    
    public String getErrorMessage1() {
        try {
            WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.ERROR_MESSAGE1));
            return msg.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getErrorMessage2() {
        try {
            WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.ERROR_MESSAGE2));
            return msg.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isLoginSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.WELCOME_TEXT));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}