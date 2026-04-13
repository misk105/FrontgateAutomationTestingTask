package locators;

import org.openqa.selenium.By;

public class HomePageLocators {

    public static final By MY_ACCOUNT_BTN = By.cssSelector("button.c-button.t-header__my-account");

    public static final By SIGN_IN_LINK = By.linkText("Sign In / Register");
    
    public final static By SEARCH_FIELD = By.cssSelector("input#search-0");

    public final static By SEARCH_BTN = By.cssSelector("button.c-button.c-search__button-submit-icon");
}