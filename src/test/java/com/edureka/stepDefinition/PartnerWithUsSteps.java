package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class PartnerWithUsSteps extends AllFunctionality {

	private Base base;

	// Constructor to initialize base
	public PartnerWithUsSteps(Base base) {
		this.base = base;
	}

	// Step to click become a partner link
	@Given("user clicks Become a Partner link")
	public void user_clicks_become_partner_link() {
		Pages.get().dashboard.clickBecomePartner(base.getDriver());
	}

	// Step to click partner with us button
	@When("user clicks Partner With Us button")
	public void user_clicks_partner_with_us_button() {
		Pages.get().partnerWithUsPage.clickPartnerWithUs(base.getDriver());
	}

	// Steps to fill partner form

	@When("user enters partner name {string}")
	public void user_enters_partner_name(String name) {
		Pages.get().partnerWithUsPage.enterName(name);
	}

	@When("user enters company name {string}")
	public void user_enters_company_name(String company) {
		Pages.get().partnerWithUsPage.enterCompanyName(company);
	}

	@When("user selects training need {string}")
	public void user_selects_training_need(String training) {
		Pages.get().partnerWithUsPage.selectTrainingNeed(training);
	}

	@When("user enters partner email {string}")
	public void user_enters_partner_email(String email) {
		Pages.get().partnerWithUsPage.enterEmail(email);
	}

	@When("user enters partner phone {string}")
	public void user_enters_partner_phone(String phone) {
		Pages.get().partnerWithUsPage.enterPhone(phone);
	}

	@When("user enters query {string}")
	public void user_enters_query(String query) {
		Pages.get().partnerWithUsPage.enterQuery(query);
	}

	// Step to submit partner form

	@When("user clicks partner submit button")
	public void user_clicks_partner_submit_button() {
		Pages.get().partnerWithUsPage.clickSubmit(base.getDriver());
	}

	// Step to validate successful submission

	@Then("partner form should be submitted successfully")
	public void partner_form_should_be_submitted_successfully() {

		String currentUrl = base.getDriver().getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);

		Assert.assertTrue(currentUrl.contains("partner") || currentUrl.contains("success"),
				"Partner form submission failed");
	}
}