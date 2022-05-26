package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvestoPediaPage extends BasePage{



    public InvestoPediaPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(xpath = ".//div[@class='tv-category-header__title']//h1")
    private WebElement titleHeader;

    @FindBy(xpath = ".//div[@class='tradingview-widget-container']/iframe")
    private WebElement tradingViewiframe;

    @FindBy(xpath = ".//div[@class='tv-category-header__title']//div[contains(@class,'tv-symbol-header__first-line')]")
    private WebElement titleHeader1;

    @FindBy(xpath = ".//div[@data-currency='USD']//div[contains(@class,'tv-symbol-price-quote__value')]")
    private WebElement priceQuoteValue;

    @FindBy(xpath = ".//div[@data-currency='USD']//div[contains(@class,'tv-symbol-price-quote__value')]/span")
    private WebElement priceQuoteDecimalValue;

    @FindBy(xpath = ".//button[@id='onetrust-accept-btn-handler']")
    private WebElement cookieAcceptButton;

    public String getTitle(){
        driver.switchTo().frame(tradingViewiframe);
        return titleHeader.getText();

    }

    public Double getPrice(){
        String price = priceQuoteValue.getText();
        Double.parseDouble(price);
        return   Double.parseDouble(price);

    }

    public void acceptCookies(){
        if(waitForVisibility(cookieAcceptButton,30,"return","")!=null)
            cookieAcceptButton.click();
    }



}
