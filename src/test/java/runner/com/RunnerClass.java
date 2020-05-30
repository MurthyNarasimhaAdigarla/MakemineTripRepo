package runner.com;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/Features/MakeMyTrip.feature", glue = {"stepdefs.com"},
        plugin = {"pretty", "html:target/cucumber-reports"})

public class RunnerClass {


}
