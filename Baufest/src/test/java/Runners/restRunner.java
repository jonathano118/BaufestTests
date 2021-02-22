package Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features={"src/test/resources/features/WebService.feature"},
	glue = {"restStepsDefinitions"},
	plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:reports/RestAPI-reports/report.html"}
	)

public class restRunner {
	

}
