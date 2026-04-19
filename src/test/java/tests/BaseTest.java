package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import pages.HomePage;
import utilities.ExcelUtils;

public class BaseTest {

    protected static WebDriver driver;
    protected static HomePage homePage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }
    
    @DataProvider(name = "checkoutData")
    public Object[][] getCheckoutData() throws Exception {
        ExcelUtils.openFile(System.getProperty("user.dir") + "/src/test/resources/users2.xlsx","Sheet1");

        Object[][] data = new Object[3][6];

        for (int i = 1; i < 4; i++) {
            data[i - 1][0] = ExcelUtils.getCellData(i, 0); // userType
            data[i - 1][1] = ExcelUtils.getCellData(i, 1); // email
            data[i - 1][2] = ExcelUtils.getCellData(i, 2); // password
            String productCountStr = ExcelUtils.getCellData(i, 3);
            data[i - 1][3] = (productCountStr == null || productCountStr.trim().isEmpty()) 
            	    ? 0 
            	    : Integer.parseInt(productCountStr.trim());// 🔥 FIX
            data[i - 1][4] = ExcelUtils.getCellData(i, 4); // addressType
            data[i - 1][5] = i;
        }

        return data;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}