package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"VerifyRevenueCalculator.feature"},
		
		glue = {"VerifyRevenueCalculator.java"},
		
		dryRun = false,
		
		monochrome = true
		
		
		
		)


public class testRunner {

}
