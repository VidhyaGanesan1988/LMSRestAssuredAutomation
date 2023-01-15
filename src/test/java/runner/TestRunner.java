package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"./src/test/resources/Feature"}, 
				glue = {"stepDefinitions"},
				monochrome = true, 
				dryRun = false, 
				tags = "@Batch" ,
				plugin = { "pretty",
				"json:target/cucumber-reports/reports.json", 
				"junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports/reports.html", 
				"html:test-output/index.html" }, 
				
				publish = true)
public class TestRunner {

}
