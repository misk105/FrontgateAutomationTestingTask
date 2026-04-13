package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utilities.ExcelUtils;

public class LoginTest extends BaseTest {

    @Test()
    public void testLogin() throws Exception {

    	String email = ExcelUtils.getCellData(1, 0);
        String password = ExcelUtils.getCellData(1, 1);
        
        homePage.navigateTo(ConfigReader.getAppUrl());
        homePage.clickMyAccount();
        LoginPage loginPage = homePage.clickSignIn();

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String result;
        boolean flag = loginPage.isLoginSuccessful();
        result = flag ? "Pass" : "Fail";
        ExcelUtils.write(result, 1, 2);
        Assert.assertTrue(flag);
    }

}