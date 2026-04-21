package com.edureka.stepDefinition;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.ExtentReportManager;
import com.edureka.utility.Pages;

public class CareerService extends AllFunctionality {

	private Base base;
	private ExtentTest logs;

	public CareerService(Base base) {
		this.base = base;
		logs = ExtentReportManager.getTest();
	}
	// DATA

	String company, linkedin, skills, jobLevel, industry, resume;
	String job, employment, location, ctc, preferredLocation;
	boolean relocate;
	String degree, institute, smonth, syear, emonth, eyear;
	String certName, certInstitute;

	@Given("user launches the browser")
	public void launchBrowser() {
		logs.log(Status.PASS, "Browser launched successfully");
	}

	@Given("user navigates to Edureka application")
	public void navigateToApp() {
		logs.log(Status.PASS, "Navigated to Edureka application");
	}

	@Given("user logs in using config credentials")
	public void login() throws InterruptedException {
		Pages.get().loginPage.openLoginPopup();
		// Enter Email
		Pages.get().loginPage.enterEmail("ramanasekar2004@gmail.com");
		// Enter Password
		Pages.get().loginPage.enterPassword("Password@123");

		// Click LOGIN button
		Pages.get().loginPage.clickLogin();
		logs.log(Status.PASS, "User logged in successfully with provided credentials");
	}

	@Given("user navigates to My Profile")
	public void goToProfile() {
		Pages.get().dashboard.navigateToMyProfile();
		logs.log(Status.PASS, "Navigated to My Profile page");
	}

	// NAVIGATION

	@Given("user clicks on Career Services tab")
	public void clickCareerServices() {
		Pages.get().myProfile.clickCareerServices();
		logs.log(Status.PASS, "Clicked on Career Services tab");
	}

	// PROFESSIONAL

	@When("user clicks Professional Details edit button")
	public void clickProfessionalEdit() {
		Pages.get().careerServicePage.clickProfessionalDetailsEdit();
		logs.log(Status.PASS, "Clicked Professional Details edit button");
	}

	@When("user reads professional details from excel")
	public void readProfessionalExcel() {

		init("Professional");

		company = getData(1, 0);
		linkedin = getData(1, 1);
		skills = getData(1, 2);
		jobLevel = getData(1, 3);
		industry = getData(1, 4);
		resume = getData(1, 5);
		logs.log(Status.PASS, "Read Professional Details from Excel");
	}

	@When("user enters professional details from excel")
	public void enterProfessionalData() {

		Pages.get().professionalDetailsPage.fillProfessionalDetails(company, linkedin, skills, jobLevel, industry,
				resume);
		logs.log(Status.PASS, "Entered Professional Details: Company=" + company + ", Job Level=" + jobLevel);
	}

	// NEXT BUTTON

	@When("user clicks Next button")
	public void clickNext() {
		waitForElementClickable(base.getDriver(), Pages.get().professionalDetailsPage.getNextButton(), 10);

		Pages.get().professionalDetailsPage.getNextButton().click();
		waitForLoaderToDisappear(base.getDriver());
		logs.log(Status.PASS, "Clicked Next button and moved to next section");
	}

	// CAREER INTERESTS

	@When("user reads career interests data from excel")
	public void readCareerExcel() {

		init("Career");

		job = getData(1, 0);
		employment = getData(1, 1);
		location = getData(1, 2);
		ctc = getData(1, 3);
		relocate = Boolean.parseBoolean(getData(1, 4));
		preferredLocation = getData(1, 5);
		logs.log(Status.PASS, "Read Career Interests data from Excel");
	}

	@When("user enters career interests data from excel")
	public void enterCareerData() {

		waitForLoaderToDisappear(base.getDriver()); // ADD THIS

		Pages.get().careerInterestsPage.fillCareerInterests(job, employment, location, ctc, relocate,
				preferredLocation);
		logs.log(Status.PASS, "Entered Career Interests: Job=" + job + ", Location=" + location);

	}

	// OTHER DETAILS

	@When("user reads other details data from excel")
	public void readOtherExcel() {

		init("OtherDetails");

		degree = getData(1, 0);
		institute = getData(1, 1);

		smonth = getData(1, 2);
		syear = getData(1, 3);
		emonth = getData(1, 4);
		eyear = getData(1, 5);

		certName = getData(1, 6);
		certInstitute = getData(1, 7);
		logs.log(Status.PASS, "Read Other Details from Excel");
	}

	@When("user enters other details from excel")
	public void enterOtherDetails() {

		Pages.get().otherDetailsPage.fillDegree(degree, institute, smonth, syear, emonth, eyear);

		Pages.get().otherDetailsPage.fillCertification(certName, certInstitute, smonth, syear, emonth, eyear);
		logs.log(Status.PASS, "Entered Education and Certification details");

	}

	@When("user clicks Save button")
	public void clickSave() {

		waitForElementClickable(base.getDriver(), Pages.get().otherDetailsPage.getSaveButton(), 10);

		Pages.get().otherDetailsPage.getSaveButton().click();
		 logs.log(Status.PASS, "Clicked Save button");
	}

	@Then("all career service details should be saved successfully")
	public void validateSaved() {
		Pages.get().myProfile.clickCareerServices();

		Assert.assertTrue(Pages.get().careerServicePage.getCompanyName().isDisplayed(), "Data not saved");
		logs.log(Status.PASS, "Career service details saved successfully");
	}

	@Then("updated career service details should be displayed correctly")
	public void validateAllData()  {
		
		Pages.get().myProfile.getCareerServicesTab().click();
		Assert.assertTrue(
				Pages.get().careerServicePage.verifyAllCareerServiceData(company, industry, jobLevel, job, location,
						relocate ? "Yes" : "No", employment, ctc, preferredLocation, institute),
				"Career Service Data Mismatch");
		 logs.log(Status.PASS, "All updated career service details verified successfully");
	}
}