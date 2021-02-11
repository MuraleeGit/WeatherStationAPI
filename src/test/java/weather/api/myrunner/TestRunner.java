package weather.api.myrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * This class is used to configure feature, step definitions and act as an entry
 * point for the automation suite
 * 
 * @author Muralee
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/weather/api/features/weather.feature", glue = {
		"weather/api/stepdefinitions" }, format = { "pretty", "html:test-outout", "json:json_output/cucumber.json",
				"junit:junit_xml/cucumber.xml" }, monochrome = true, strict = true, dryRun = false)

public class TestRunner {

}
