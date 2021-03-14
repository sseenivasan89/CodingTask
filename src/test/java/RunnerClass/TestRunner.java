package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "json:target/cucumber.json", "json:target/cucumber.json",
		"de.monochromata.cucumber.report.PrettyReports:target/cucumber" 
		}, 
		features = {"src/test/java/Features" }, 
		glue = { "StepDefinitions" }, 
		dryRun = false, monochrome = true)
public class TestRunner {

}
