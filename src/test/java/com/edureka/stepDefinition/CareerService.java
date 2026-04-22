package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;
import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class CareerService extends AllFunctionality {

	private Base base;

	// Constructor to initialize base
	public CareerService(Base base) {
		this.base = base;
	}

	// Test data variables

	String company, linkedin, skills, jobLevel, industry, resume;
	String job, employment, location, ctc, preferredLocation;
	boolean relocate;
	String degree, institute, smonth, syear, emonth, eyear;
	String certName, certInstitute;

	// Step to launch browser
	@Given("user launches the browser")
	public void launchBrowser() {

	}

	// Step to navigate to application
	@Given("user navigates to Edureka application")
	public void navigateToApp() {

	}

	// Step to login using credentials
	@Given("user logs in using config credentials")
	public void login() throws InterruptedException {
		Pages.get().loginPage.openLoginPopup();
		
		// Enter email
		Pages.get().loginPage.enterEmail("ramanasekar2004@gmail.com");

		// Enter password
		Pages.get().loginPage.enterPassword("Password@123");

		// Click login button
		Pages.get().loginPage.clickLogin();
	}

	// Step to navigate to profile
	@Given("user navigates to My Profile")
	public void goToProfile() {
		Pages.get().dashboard.navigateToMyProfile();
	}

	// Step to click career services tab
	@Given("user clicks on Career Services tab")
	public void clickCareerServices() {
		Pages.get().myProfile.clickCareerServices();
	}

	// Step to click professional details edit
	@When("user clicks Professional Details edit button")
	public void clickProfessionalEdit() {
		Pages.get().careerServicePage.clickProfessionalDetailsEdit();
	}

	// Step to read professional data from excel
	@When("user reads professional details from excel")
	public void readProfessionalExcel() {

		init("Professional");

		company = getData(1, 0);
		linkedin = getData(1, 1);
		skills = getData(1, 2);
		jobLevel = getData(1, 3);
		industry = getData(1, 4);
		resume = getData(1, 5);
	}

	// Step to enter professional data
	@When("user enters professional details from excel")
	public void enterProfessionalData() {

		Pages.get().professionalDetailsPage.fillProfessionalDetails(company, linkedin, skills, jobLevel, industry,
				resume);
	}

	// Step to click next button
	@When("user clicks Next button")
	public void clickNext() {
		waitForElementClickable(base.getDriver(), Pages.get().professionalDetailsPage.getNextButton(), 10);

		Pages.get().professionalDetailsPage.getNextButton().click();
		waitForLoaderToDisappear(base.getDriver());
	}

	// Step to read career interests data
	@When("user reads career interests data from excel")
	public void readCareerExcel() {

		init("Career");

		job = getData(1, 0);
		employment = getData(1, 1);
		location = getData(1, 2);
		ctc = getData(1, 3);
		relocate = Boolean.parseBoolean(getData(1, 4));
		preferredLocation = getData(1, 5);
	}

	// Step to enter career interests data
	@When("user enters career interests data from excel")
	public void enterCareerData() {

		waitForLoaderToDisappear(base.getDriver());

		Pages.get().careerInterestsPage.fillCareerInterests(job, employment, location, ctc, relocate,
				preferredLocation);
	}

	// Step to read other details data
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
	}

	// Step to enter other details
	@When("user enters other details from excel")
	public void enterOtherDetails() {

		Pages.get().otherDetailsPage.fillDegree(degree, institute, smonth, syear, emonth, eyear);

		Pages.get().otherDetailsPage.fillCertification(certName, certInstitute, smonth, syear, emonth, eyear);
	}

	// Step to click save button
	@When("user clicks Save button")
	public void clickSave() {

		waitForElementClickable(base.getDriver(), Pages.get().otherDetailsPage.getSaveButton(), 10);

		Pages.get().otherDetailsPage.getSaveButton().click();
	}

	// Step to validate data saved
	@Then("all career service details should be saved successfully")
	public void validateSaved() {
		Pages.get().myProfile.clickCareerServices();

		Assert.assertTrue(Pages.get().careerServicePage.getCompanyName().isDisplayed(), "Data not saved");
	}

	// Step to validate all data
	@Then("updated career service details should be displayed correctly")
	public void validateAllData() {

		Pages.get().myProfile.getCareerServicesTab().click();

		Assert.assertTrue(
				Pages.get().careerServicePage.verifyAllCareerServiceData(company, industry, jobLevel, job, location,
						relocate ? "Yes" : "No", employment, ctc, preferredLocation, institute),
				"Career Service Data Mismatch");
	}
}