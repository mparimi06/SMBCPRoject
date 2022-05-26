package steps;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.support.PageFactory;
import pages.InvestoPediaPage;


public class InvestoPediaSteps extends TestBase {
    private String title;
    private Double price;
    private InvestoPediaPage investoPediaPage;
    @Given("^I have logon to Investopedia website using the provided url \"([^\"]*)\"$")
    public void iHaveLogonToInvestopediaWebsiteUsingTheProvidedUrl(String  url){

        driver.get(url);
        investoPediaPage=new InvestoPediaPage(driver);
        investoPediaPage.acceptCookies();
    }
    @When(("^I capture the Title and Stock price"))
    public void iCaptureTheTitleandStockPrice(){
        title= investoPediaPage.getTitle();
        price = investoPediaPage.getPrice();
        System.out.println("Title found: "+ title);
        System.out.println("Price found: "+ price);
    }

    @Then(("^I verify title is \"([^\"]*)\"$"))
    public void iVerifyTitleIs(String expectedTitle){
       softAssert.assertEquals(title ,expectedTitle);
    }

    @And("I Verify the price is below \"([^\"]*)\" USD$")
    public void iVerifyThePriceIsBelow(Double expectedPrice){
        softAssert.assertTrue(price <= expectedPrice);
    }

    @And("I Assert all and close browser")
    public void iAssertAllAndCloseBrowser(){
        softAssert.assertAll();
        driver.quit();
    }

}
