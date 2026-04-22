package com.edureka.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * RUNNER — entry point for TestNG to discover and run Cucumber scenarios.
 *
 * HOW parallel execution works:
 *   1. AbstractTestNGCucumberTests exposes each scenario as a row in scenarios()
 *   2. @DataProvider(parallel=true) tells TestNG to feed rows to multiple threads
 *   3. testing.xml parallel="methods" + thread-count controls the pool size
 *
 * features → point at the directory, not a single file, to run everything
 * glue     → package where Hook.java and all step defs live
 * tags     → optional: use "@parallel" to exclude sequential-only scenarios
 */

@CucumberOptions(
		features = {
				"./src/test/java/com/edureka/featureFile/webinar.feature",
//				"./src/test/java/com/edureka/featureFile/homePageCorporateTraining.feature",
//				"./src/test/java/com/edureka/featureFile/communityQuestion.feature",
//				"./src/test/java/com/edureka/featureFile/homePageScenario.feature"
		},
		glue = "com.edureka.stepDefinition",
		plugin   = {
		        "pretty",
		        "html:target/cucumber-report.html",
		        "json:target/cucumber.json"
		    },
		monochrome = true
		)
public class RunnerIO extends AbstractTestNGCucumberTests {
	 /**
     * Overriding scenarios() with parallel=true tells TestNG to feed
     * each Cucumber scenario to a separate thread from the pool.
     * The thread count is controlled by testing.xml.
     */
	@Override
    @org.testng.annotations.DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
