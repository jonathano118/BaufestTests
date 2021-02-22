package Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/features/WebPage.feature"},
		glue = {"stepsDefinition"},
		plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:reports/Webpage-reports/report.html"}
		)

public class Runner {


}
