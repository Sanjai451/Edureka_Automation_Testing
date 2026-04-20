package com.edureka.stepDefinition;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class CareerServicePage extends AllFunctionality {

	private Base base;

	public CareerServicePage(Base base) {
		this.base = base;
	}

	// DATA

	String company, linkedin, skills, jobLevel, industry, resume;
	String job, employment, location, ctc, preferredLocation;
	boolean relocate;
	String degree, institute, smonth, syear, emonth, eyear;
	String certName, certInstitute;

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
		password.sendKeys("NewPass@123");

		// Click LOGIN button
		base.getDriver().findElement(By.xpath("//button[text()='LOG IN']")).click();
	}

	@Given("user navigates to My Profile")
	public void goToProfile() {
		Pages.dashboard.navigateToMyProfile();
	}

	// NAVIGATION

	@Given("user clicks on Career Services tab")
	public void clickCareerServices() {
		Pages.myProfile.clickCareerServices();
	}

	// PROFESSIONAL

	@When("user clicks Professional Details edit button")
	public void clickProfessionalEdit() {
		Pages.careerServicePage.clickProfessionalDetailsEdit();
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
	}

	@When("user enters professional details from excel")
	public void enterProfessionalData() {

		Pages.professionalDetailsPage.fillProfessionalDetails(company, linkedin, skills, jobLevel, industry, resume);
	}

	// NEXT BUTTON

	@When("user clicks Next button")
	public void clickNext() {
		waitForElementClickable(base.getDriver(), Pages.professionalDetailsPage.getNextButton(), 10);

		Pages.professionalDetailsPage.getNextButton().click();
		waitForLoaderToDisappear(base.getDriver());
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
	}

	@When("user enters career interests data from excel")
	public void enterCareerData() {

		waitForLoaderToDisappear(base.getDriver()); // ADD THIS

		Pages.careerInterestsPage.fillCareerInterests(job, employment, location, ctc, relocate, preferredLocation);
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
	}

	@When("user enters other details from excel")
	public void enterOtherDetails() {

		Pages.otherDetailsPage.fillDegree(degree, institute, smonth, syear, emonth, eyear);

		Pages.otherDetailsPage.fillCertification(certName, certInstitute, smonth, syear, emonth, eyear);
	}

	@When("user clicks Save button")
	public void clickSave() {

		waitForElementClickable(base.getDriver(), Pages.otherDetailsPage.getSaveButton(), 10);

		Pages.otherDetailsPage.getSaveButton().click();
	}

	// FINAL VALIDATION

	@Then("updated career service details should be displayed correctly")
	public void validateAllData() {
		Pages.myProfile.getCareerServicesTab().click();
		Assert.assertTrue(
				Pages.careerServicePage.verifyAllCareerServiceData(company, industry, jobLevel, job, location,
						relocate ? "Yes" : "No", employment, ctc, preferredLocation, institute),
				"Career Service Data Mismatch");
	}
}