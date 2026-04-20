package com.edureka.stepDefinition;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class CareerServicePage {

	private Base base;
	AllFunctionality util = new AllFunctionality();

	public CareerServicePage(Base base) {
		this.base = base;
	}

	// ================= DATA =================

	String company, linkedin, skills, jobLevel, industry, resume;
	String job, employment, location, ctc, preferredLocation;
	boolean relocate;
	String degree, institute, month, year;

	@Given("user launches the browser")
	public void launchBrowser() {
		System.out.println("Browser launched");
	}

	@Given("user navigates to Edureka application")
	public void navigateToApp() {
		System.out.println("Navigated to app");
	}

	@Given("user logs in using config credentials")
	public void login() throws InterruptedException {
		base.getDriver().findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(2000);

		// Enter Email
		WebElement email = base.getDriver().findElement(By.id("loginFormEmail"));
		email.clear();
		email.sendKeys("ramanasekar2004@gmail.com");

		// Enter Password
		WebElement password = base.getDriver().findElement(By.id("loginPassword"));
		password.clear();
		password.sendKeys("Password");

		// Click LOGIN button
		base.getDriver().findElement(By.xpath("//button[text()='LOG IN']")).click();
	}

	@Given("user navigates to My Profile")
	public void goToProfile() {
		Pages.get().dashboard.navigateToMyProfile();
	}

	// ================= NAVIGATION =================

	@Given("user clicks on Career Services tab")
	public void clickCareerServices() {
		Pages.get().myProfile.clickCareerServices();
	}

	// ================= PROFESSIONAL =================

	@When("user clicks Professional Details edit button")
	public void clickProfessionalEdit() {
		Pages.get().careerServicePage.clickProfessionalDetailsEdit();
	}

	@When("user reads professional details from excel")
	public void readProfessionalExcel() {

		util.init("Professional");

		company = util.getData(1, 0);
		linkedin = util.getData(1, 1);
		skills = util.getData(1, 2);
		jobLevel = util.getData(1, 3);
		industry = util.getData(1, 4);
		resume = util.getData(1, 5);
	}

	@When("user enters professional details from excel")
	public void enterProfessionalData() {

		Pages.get().professionalDetailsPage.fillProfessionalDetails(company, linkedin, skills, jobLevel, industry, resume);
	}

	// ================= NEXT BUTTON =================

	@When("user clicks Next button")
	public void clickNext() {
		util.waitForElementClickable(base.getDriver(),
		        Pages.get().professionalDetailsPage.getNextButton(), 10);

		Pages.get().professionalDetailsPage.getNextButton().click();
	}

	// ================= CAREER INTERESTS =================

	@When("user reads career interests data from excel")
	public void readCareerExcel() {

		util.init("Career");

		job = util.getData(1, 0);
		employment = util.getData(1, 1);
		location = util.getData(1, 2);
		ctc = util.getData(1, 3);
		relocate = Boolean.parseBoolean(util.getData(1, 4));
		preferredLocation = util.getData(1, 5);
	}

	@When("user enters career interests data from excel")
	public void enterCareerData() {

		Pages.get().careerInterestsPage.fillCareerInterests(job, employment, location, ctc, relocate, preferredLocation);
	}

	// ================= OTHER DETAILS =================

	@When("user reads other details data from excel")
	public void readOtherExcel() {

		util.init("OtherDetails");

		degree = util.getData(1, 0);
		institute = util.getData(1, 1);
		month = util.getData(1, 2);
		year = util.getData(1, 3);
	}

	@When("user enters other details from excel")
	public void enterOtherDetails() {

		Pages.get().otherDetailsPage.fillOtherDetails(degree, institute, month, year);
	}

	@When("user clicks Save button")
	public void clickSave() {
		util.waitForElementClickable(base.getDriver(),
		        Pages.get().otherDetailsPage.getSaveButton(), 10);

		Pages.get().otherDetailsPage.getSaveButton().click();
	}

	// ================= FINAL VALIDATION =================

	@Then("all career service details should be saved successfully")
	public void validateSaved() {

		Assert.assertTrue(Pages.get().careerServicePage.getCompanyName().isDisplayed(), "Data not saved");
	}

	@Then("updated career service details should be displayed correctly")
	public void validateAllData() {

		Assert.assertTrue(
				Pages.get().careerServicePage.verifyAllCareerServiceData(company, industry, jobLevel, skills, job, location,
						relocate ? "Yes" : "No", employment, ctc, preferredLocation, degree),
				"Career Service Data Mismatch");
	}
}