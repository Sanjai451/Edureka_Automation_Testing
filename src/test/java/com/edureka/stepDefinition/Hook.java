package com.edureka.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.ExtentReportManager;
import com.edureka.utility.Pages;
import com.edureka.utility.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends AllFunctionality {
	
	private Base base;
	
	public Hook(Base base) {
		this.base = base;
	}
	
	@Before
	public void setUp(Scenario scenario) throws IOException {
//		base.driver = new EdgeDriver();
		base.initDriver();
		
		initPropertiesUtility("./src/main/resources/edureka.properties");
		String URL = getPropertyData("url");
//		String USERNAME = getPropertyData("username");
//		String PASSWORD = getPropertyData("password");
		
		setMaximizeBrowser(base.getDriver());
		implicitlyWait(base.getDriver(), 5);
		
		
		base.getDriver().get(URL);
		
		Pages.loadAllPages(base.getDriver());
		
		ExtentTest test = ExtentReportManager.getInstance()
                .createTest(scenario.getName());
        ExtentReportManager.setTest(test);
        ExtentReportManager.getTest().info("Test Started: " + scenario.getName());
		
	}
	
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
        }

        Base.quitDriver();
        Pages.cleanUp();
        
	}
	

    /**
     * Called ONCE after ALL scenarios finish — flushes the Extent HTML report.
     */
    @AfterAll
    public static void afterAll() {
        ExtentReportManager.flushReports();
    }
}
