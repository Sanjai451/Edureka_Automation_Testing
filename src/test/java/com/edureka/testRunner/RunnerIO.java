package com.edureka.testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/java/com/edureka/featureFile/search.feature",
        glue = "com.edureka.stepDefinition",
        plugin = {
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
    @org.testng.annotations.DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}