package com.edureka.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
//"src/test/java/com/edureka/featureFile/Topics of Interest.feature",
//
//		"src/test/java/com/edureka/featureFile/Career Services.feature",
//		"src/test/java/com/edureka/featureFile/addInstructor.feature"
//		"src/test/java/com/edureka/featureFile/ My Orders and Invoices.feature",
//		"src/test/java/com/edureka/featureFile/My Wallet.feature"
		"src/test/java/com/edureka/featureFile/partnerWithUs.feature",
		"src/test/java/com/edureka/featureFile/Personalize.feature" 
}, glue = "com.edureka.stepDefinition",
//		dryRun = false
		plugin = { "pretty", "html:target/cucumber-report.html", "json:target/cucumber.json",
				"com.edureka.utility.StepAutoLogger" },

		monochrome = true)
public class RunnerIO extends AbstractTestNGCucumberTests {
	/**
	 * Overriding scenarios() with parallel=true tells TestNG to feed each Cucumber
	 * scenario to a separate thread from the pool. The thread count is controlled
	 * by testing.xml.
	 */
	@Override
	@org.testng.annotations.DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
