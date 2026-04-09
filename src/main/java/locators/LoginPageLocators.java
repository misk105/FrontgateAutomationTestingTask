package locators;

import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By EMAIL_FIELD = By.cssSelector("input#email");

    public static final By PASSWORD_FIELD = By.cssSelector("input#password");

    public static final By LOGIN_BUTTON = By.cssSelector("button.login-button.btn.btn-primary");

    public static final By WELCOME_TEXT = By.xpath("//*[contains(@class,'welcome')]");

    public static final By ERROR_MESSAGE1 = By.cssSelector("div#errorMessage-password");

    public static final By ERROR_MESSAGE2 = By.cssSelector("div.c-login__submition-error");
}