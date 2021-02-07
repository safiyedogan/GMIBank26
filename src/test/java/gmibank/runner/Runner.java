package gmibank.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"pretty",
				"html:target/default-cucumber-reports",
				"json:target/cucumber.json",
				"junit:target/xml-report/cucumber.xml"
		},
		features = "src/test/resources/features",
		glue = "gmibank/step_defs",
		tags = "@US_025_API",
		dryRun = false
)
public class Runner {

}
