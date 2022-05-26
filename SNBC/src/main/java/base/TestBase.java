package base;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.InvestoPediaPage;

public class TestBase {

    private BrowserSetup browserSetup;

    protected static WebDriver driver;
    protected SoftAssert softAssert;

    public TestBase(){
        browserSetup = new BrowserSetup();
        driver = browserSetup.getDriver();
        softAssert=new SoftAssert();
    }
    @After
    public void tearDown(){
        softAssert.assertAll();
        driver.quit();
    }
}
