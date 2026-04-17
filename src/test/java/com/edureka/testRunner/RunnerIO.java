package com.edureka.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*
 * dryRun = true : to generate code in console
 * dryRun = false : To execute the tests
 */

@CucumberOptions(
		features = {"./src/test/java/com/edureka/featureFile/blogsScenario.feature"},
		glue = "com.edureka.stepDefinition",
		dryRun = false
		)
public class RunnerIO extends AbstractTestNGCucumberTests {

}
