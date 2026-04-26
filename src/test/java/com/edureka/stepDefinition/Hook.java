package com.edureka.stepDefinition;

import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.ExtentReportManager;
import com.edureka.utility.Pages;
import com.edureka.utility.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

/**
 * Hook class for Cucumber test lifecycle management.
 * Handles setup and teardown for each scenario, including browser initialization and reporting.
 */
public class Hook extends AllFunctionality {
	
	private Base base;
	
	/**
	 * Constructor for Hook.
	 * Initializes the Base instance for WebDriver management.
	 * @param base the Base instance
	 */
	public Hook(Base base) {
		this.base = base;
	}
	
	/**
	 * Setup method executed before each Cucumber scenario.
	 * Initializes properties, browser, navigates to URL, and sets up reporting.
	 * @param scenario the current Cucumber scenario
	 * @throws IOException if properties file cannot be loaded
	 */
	@Before
	public void setUp(Scenario scenario) throws IOException {
		
		initPropertiesUtility("./src/test/resources/edureka.properties");
		String URL = getPropertyData("url");
		String BROWSWER = getPropertyData("broswer");
		
		base.initDriver(BROWSWER);
		
		int implicitTime = Integer.parseInt(getPropertyData("implicitTime"));
		
		setMaximizeBrowser(base.getDriver());
		
		implicitlyWait(base.getDriver(), implicitTime);
				
		base.getDriver().get(URL);
		
		Pages.loadAllPages(base.getDriver());
		
		ExtentTest test = ExtentReportManager.getInstance()
                .createTest(scenario.getName());
        ExtentReportManager.setTest(test);
        ExtentReportManager.getTest().info("Test Started: " + scenario.getName());
		
	}
	
	/**
	 * Teardown method executed after each Cucumber scenario.
	 * Captures screenshots on failure, logs results to Extent report, and cleans up resources.
	 * @param scenario the current Cucumber scenario
	 */
	@After
	 public void tearDown(Scenario scenario){
		
		ExtentTest test = ExtentReportManager.getTest();

        if (scenario.isFailed()) {
            // ── Take screenshot and attach to Extent report ──
            String base64Screenshot = ScreenshotUtil.takeScreenshotAsBase64(Base.getDriver());
            
            test.fail("Scenario FAILED: " + scenario.getName(),
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

            // ── Also embed in Cucumber HTML report ──
            byte[] screenshot = ((org.openqa.selenium.TakesScreenshot) Base.getDriver())
                    .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
            
            scenario.attach(screenshot, "image/png", "Failure Screenshot");

        } else {
            test.pass("Scenario PASSED: " + scenario.getName());
            Base.quitDriver();
        }

        Pages.cleanUp();
        
	}
	private String currentStepName = "";
	
	@BeforeStep
	public void beforeStep(Scenario scenario) {
	    // Cucumber doesn't expose step text directly, so we read it from the scenario's
	    // last line in the event model. We store the scenario name as fallback.
	    currentStepName = scenario.getName();
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) {
	    ExtentTest test = ExtentReportManager.getTest();
	    if (test == null) return;

	    if (scenario.isFailed()) {
	        // Only log step-level failure here if test hasn't been fully failed yet
	        String base64Screenshot = ScreenshotUtil.takeScreenshotAsBase64(Base.getDriver());
	        test.log(Status.FAIL, "Step FAILED in: " + scenario.getName(),
	                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
	    } else {
//	        test.log(Status.PASS, "Step PASSED : ");
	    }
	}
	

    /**
     * Called ONCE after ALL scenarios finish — flushes the Extent HTML report.
     */
    @AfterAll
    public static void afterAll() {
        ExtentReportManager.flushReports();
    }
}
