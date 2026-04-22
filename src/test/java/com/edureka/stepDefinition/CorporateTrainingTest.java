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

public class CorporateTrainingTest {
	private Base base;
	private ExtentTest logs;
	private WebDriverWait wait;
	
	public CorporateTrainingTest(Base base) {
		this.base = base;
		logs = ExtentReportManager.getTest();
		this.wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(15));
	}
	
	@When("user navigates to {string} page")
	public void user_navigates_to_page(String string) {
		Pages.get().homePage.clickOnCorporateTraining();

		logs.log(Status.INFO,"Navigated to " + string + " Page");
	}

	@Then("corporate training page should be displayed")
	public void corporate_training_page_should_be_displayed() {
		WebDriver driver = base.getDriver();

        // Wait until URL reflects navigation
        wait.until(d -> d.getCurrentUrl().contains("corporate"));
        assertTrue(driver.getCurrentUrl().contains("corporate"),
                "Corporate Training page is not displayed");

        logs.log(Status.PASS, "Corporate Training page displayed successfully");
	}

	@When("user enters corporate training details and submit")
	public void user_enters_corporate_training_details_and_submit(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		
		Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

		Pages.get().corporateTrainingPage.submitDetails(data.get("Name"),
	            data.get("Email"),
	            data.get("Phone"),
	            data.get("TrainingNeed"),
	            data.get("Company"),
	            data.get("Query"));
		
		logs.log(Status.INFO,"Corportate Training details submitted");
	    
	}

	@Then("user should see successful submission message")
	public void user_should_see_successful_submission_message() {
		logs.log(Status.PASS, "User successfully submitted corporate training request");
	}
}
