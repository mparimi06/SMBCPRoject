package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected WebElement waitForVisibility(WebElement elem, int seconds, String log, String msg)
    {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            new WebDriverWait(driver,seconds).until(ExpectedConditions.visibilityOf(elem));
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        catch(Exception e)
        {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            if(log.equals("return"))
            {	return null;	}
            else if(msg.isEmpty())
            {	Assert.assertTrue("Element is not visible after "+seconds+" seconds" , false);	}
            else
                System.out.println(msg);

        }
        return elem;
    }
}
