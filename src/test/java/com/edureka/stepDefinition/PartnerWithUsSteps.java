package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.ExtentReportManager;
import com.edureka.utility.Pages;

public class PartnerWithUsSteps extends AllFunctionality {

	private Base base;
	private ExtentTest logs;

	public PartnerWithUsSteps(Base base) {
		this.base = base;
		logs = ExtentReportManager.getTest();
	}

	@Given("user clicks Become a Partner link")
	public void user_clicks_become_partner_link() {
		Pages.get().dashboard.clickBecomePartner(base.getDriver());
		logs.log(Status.PASS, "Clicked on 'Become a Partner' link");
	}

	// Click Partner Button

	@When("user clicks Partner With Us button")
	public void user_clicks_partner_with_us_button() {
		Pages.get().partnerWithUsPage.clickPartnerWithUs(base.getDriver());
		logs.log(Status.PASS, "Clicked on 'Partner With Us' button");
	}

	// Form Filling

	@When("user enters partner name {string}")
	public void user_enters_partner_name(String name) {
		Pages.get().partnerWithUsPage.enterName(name);
		logs.log(Status.PASS, "Entered Partner Name: " + name);
	}

	@When("user enters company name {string}")
	public void user_enters_company_name(String company) {
		Pages.get().partnerWithUsPage.enterCompanyName(company);
		logs.log(Status.PASS, "Entered Company Name: " + company);
	}

	@When("user selects training need {string}")
	public void user_selects_training_need(String training) {
		Pages.get().partnerWithUsPage.selectTrainingNeed(training);
		logs.log(Status.PASS, "Selected Training Need: " + training);
	}

	@When("user enters partner email {string}")
	public void user_enters_partner_email(String email) {
		Pages.get().partnerWithUsPage.enterEmail(email);
		logs.log(Status.PASS, "Entered Partner Email: " + email);
	}

	@When("user enters partner phone {string}")
	public void user_enters_partner_phone(String phone) {
		Pages.get().partnerWithUsPage.enterPhone(phone);
		logs.log(Status.PASS, "Entered Partner Phone: " + phone);
	}

	@When("user enters query {string}")
	public void user_enters_query(String query) {
		Pages.get().partnerWithUsPage.enterQuery(query);
		logs.log(Status.PASS, "Entered Query/Message");
	}

	// Submit

	@When("user clicks partner submit button")
	public void user_clicks_partner_submit_button() {
		Pages.get().partnerWithUsPage.clickSubmit(base.getDriver());
		logs.log(Status.PASS, "Clicked Partner Submit button");
	}

	// Validation

	@Then("partner form should be submitted successfully")
	public void partner_form_should_be_submitted_successfully() {

		String currentUrl = base.getDriver().getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);

		logs.log(Status.PASS, "Captured current URL: " + currentUrl);

		Assert.assertTrue(currentUrl.contains("partner") || currentUrl.contains("success"),
				"Partner form submission failed");

		logs.log(Status.PASS, "Partner form submitted successfully");
	}
}