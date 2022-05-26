package CucumberTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = {"pretty","html:target/cucumber-report/cucumber.html"},
        features = {"src/test/java/Features"},
        glue = {"steps"},
        monochrome = true
        )
public class TestRunner {
}



