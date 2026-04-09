package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import tests.ConfigReader;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtils;

public class LoginTest {

    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        ExcelUtils.openFile(
            System.getProperty("user.dir") + "/src/test/resources/users.xlsx",
            "Sheet1"
        );

        homePage = new HomePage(driver);
    }
    
    @DataProvider(name = "loginData")
    public Object[][] getData() {

        int rowCount = ExcelUtils.getRowCount();

        Object[][] data = new Object[rowCount][3];

        for (int i = 1; i <= rowCount; i++) {
            data[i - 1][0] = ExcelUtils.getCellData(i, 0);
            data[i - 1][1] = ExcelUtils.getCellData(i, 1);
            data[i - 1][2] = i;
        }

        return data;
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, int row) throws Exception {


        homePage.navigateTo(ConfigReader.getAppUrl());
        homePage.clickMyAccount();
        LoginPage loginPage = homePage.clickSignIn();

        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String result;
        
        if (password.isEmpty()) {
            String error = loginPage.getErrorMessage1();
            result = !error.isEmpty() ? "Pass" : "Fail";	
        }
        else if (!password.equals("Mi@12345678")) {
            String error = loginPage.getErrorMessage2();
            result = !error.isEmpty() ? "Pass" : "Fail";
        }
        else {
        	result = loginPage.isLoginSuccessful() ? "Pass" : "Fail";
         }
        ExcelUtils.write(result, row, 2);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}