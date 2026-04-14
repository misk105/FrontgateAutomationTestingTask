package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utilities.ExcelUtils;

public class BaseTest {

    protected static WebDriver driver;
    protected static HomePage homePage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        ExcelUtils.openFile(
            System.getProperty("user.dir") + "/src/test/resources/users.xlsx",
            "Sheet1"
        );

        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}