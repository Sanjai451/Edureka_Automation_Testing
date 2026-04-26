package com.edureka.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.utility.Base;
import com.edureka.utility.ExtentReportManager;
import com.edureka.utility.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Test step definitions for Corporate Training-related scenarios.
 * This class contains Cucumber steps for navigating to corporate training page,
 * filling out the contact form, and verifying submission.
 */
public class CorporateTraining {
	private Base base;
	private ExtentTest logs;
	private WebDriverWait wait;
	
	/**
	 * Constructor for CorporateTrainingTest.
	 * Initializes base, logs, and wait using the provided Base instance.
	 * @param base the Base instance for WebDriver access
	 */
	public CorporateTraining(Base base) {
		this.base = base;
		logs = ExtentReportManager.getTest();
		this.wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(15));
	}
	
	@When("user navigates to {string} page")
	public void user_navigates_to_page(String string) {
		Pages.get().homePage.clickOnCorporateTraining();

	}

	@Then("corporate training page should be displayed")
	public void corporate_training_page_should_be_displayed() {
		WebDriver driver = base.getDriver();

        // Wait until URL reflects navigation
        wait.until(d -> d.getCurrentUrl().contains("corporate"));
        assertTrue(driver.getCurrentUrl().contains("corporate"),
                "Corporate Training page is not displayed");

	}

	/**
	 * Step definition for entering corporate training details and submitting the form.
	 * Extracts data from DataTable and passes to the page object for form filling.
	 * @param dataTable the Cucumber DataTable containing form data
	 */
	@When("user enters corporate training details and submit")
	public void user_enters_corporate_training_details_and_submit(io.cucumber.datatable.DataTable dataTable) {
		
		Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

		Pages.get().corporateTrainingPage.submitDetails(data.get("Name"),
	            data.get("Email"),
	            data.get("Phone"),
	            data.get("TrainingNeed"),
	            data.get("Company"),
	            data.get("Query"));
		
	    
	}

	@Then("user should see successful submission message")
	public void user_should_see_successful_submission_message() {
		Pages.get().corporateTrainingPage.waitUntilSuccessMessage(wait);
		logs.log(Status.PASS, "User successfully submitted corporate training request");
	}
}
