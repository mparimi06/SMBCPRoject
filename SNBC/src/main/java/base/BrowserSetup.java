package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserSetup {
    private WebDriver driver;

    public WebDriver getDriver(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumGrid\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
