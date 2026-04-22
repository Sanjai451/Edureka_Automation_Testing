package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerServicePage {

	// Locator for professional details edit button
	@FindBy(xpath = "//h4[contains(text(),'Professional Details')]/ancestor::div[contains(@class,'details-heading')]//a")
	private WebElement professionalDetailsEditBtn;

	// Locator for career interests edit button
	@FindBy(xpath = "//h4[contains(text(),'Career Interests')]/ancestor::div[contains(@class,'details-heading')]//a")
	private WebElement careerInterestsEditBtn;

	// Locator for other details edit button
	@FindBy(xpath = "//h4[contains(text(),'Other Details')]/ancestor::div[contains(@class,'details-heading')]//a")
	private WebElement otherDetailsEditBtn;

	// Locator for company name
	@FindBy(xpath = "(//span[text()='Company Name']/following-sibling::span)[1]")
	private WebElement companyName;

	// Locator for current industry
	@FindBy(xpath = "//span[text()='Current Industry']/following-sibling::span")
	private WebElement currentIndustry;

	// Locator for job level
	@FindBy(xpath = "(//span[text()='Your Current Job Level']/following-sibling::span)[1]")
	private WebElement jobLevel;

	// Locator for skills
	@FindBy(xpath = "//span[text()='Skills']/following-sibling::span")
	private WebElement skills;

	// Locator for job type
	@FindBy(xpath = "(//span[contains(text(),'Types of jobs')]/following-sibling::span)[1]")
	private WebElement jobType;

	// Locator for current location
	@FindBy(xpath = "(//span[text()='Current Location']/following-sibling::span)[1]")
	private WebElement currentLocation;

	// Locator for relocate value
	@FindBy(xpath = "//span[text()='Relocate']/following-sibling::span")
	private WebElement relocate;

	// Locator for employment type
	@FindBy(xpath = "(//span[contains(text(),'Employment types')]/following-sibling::span)[1]")
	private WebElement employmentType;

	// Locator for CTC value
	@FindBy(xpath = "(//span[text()='Current/Last drawn CTC']/following-sibling::span[@class='details'])[1]")
	private WebElement ctc;

	// Locator for preferred location
	@FindBy(xpath = "//span[text()='Preferred Location']/following-sibling::span")
	private WebElement preferredLocation;

	// Locator for qualification
	@FindBy(xpath = "(//span[contains(@class,'details institute-name')])[1]")
	private WebElement qualification;

	// Locator for year details
	@FindBy(xpath = "//span[contains(@class,'year')]")
	private WebElement yearDetails;

	// Getter for professional details edit button
	public WebElement getProfessionalDetailsEditBtn() {
		return professionalDetailsEditBtn;
	}

	// Getter for career interests edit button
	public WebElement getCareerInterestsEditBtn() {
		return careerInterestsEditBtn;
	}

	// Getter for other details edit button
	public WebElement getOtherDetailsEditBtn() {
		return otherDetailsEditBtn;
	}

	// Getter for company name
	public WebElement getCompanyName() {
		return companyName;
	}

	// Getter for current industry
	public WebElement getCurrentIndustry() {
		return currentIndustry;
	}

	// Getter for job level
	public WebElement getJobLevel() {
		return jobLevel;
	}

	// Getter for skills
	public WebElement getSkills() {
		return skills;
	}

	// Getter for job type
	public WebElement getJobType() {
		return jobType;
	}

	// Getter for current location
	public WebElement getCurrentLocation() {
		return currentLocation;
	}

	// Getter for relocate value
	public WebElement getRelocate() {
		return relocate;
	}

	// Getter for employment type
	public WebElement getEmploymentType() {
		return employmentType;
	}

	// Getter for CTC
	public WebElement getCtc() {
		return ctc;
	}

	// Getter for preferred location
	public WebElement getPreferredLocation() {
		return preferredLocation;
	}

	// Getter for qualification
	public WebElement getQualification() {
		return qualification;
	}

	// Getter for year details
	public WebElement getYearDetails() {
		return yearDetails;
	}

	// Click on professional details edit button
	public void clickProfessionalDetailsEdit() {
		getProfessionalDetailsEditBtn().click();
	}

	// Click on career interests edit button
	public void clickCareerInterestsEdit() {
		getCareerInterestsEditBtn().click();
	}

	// Click on other details edit button
	public void clickOtherDetailsEdit() {
		getOtherDetailsEditBtn().click();
	}

	// Verify text of element with expected value
	public boolean verifyText(WebElement element, String expected) {
		return element.getText().trim().equalsIgnoreCase(expected);
	}

	// Verify professional details section
	public boolean verifyProfessionalDetails(String company, String industry, String jobLvl, String skill) {

		return verifyText(getCompanyName(), company) && verifyText(getCurrentIndustry(), industry)
				&& verifyText(getJobLevel(), jobLvl) && verifyText(getSkills(), skill);
	}

	// Verify career interests section
	public boolean verifyCareerInterests(String job, String location, String relocateValue, String empType,
			String expectedCTC, String prefLocation) {

		return verifyText(getJobType(), job) && verifyText(getCurrentLocation(), location)
				&& verifyText(getRelocate(), relocateValue) && verifyText(getEmploymentType(), empType)
				&& verifyText(getCtc(), expectedCTC) && verifyText(getPreferredLocation(), prefLocation);
	}

	// Verify other details section
	public boolean verifyOtherDetails(String expectedQualification) {
		return getQualification().getText().contains(expectedQualification);
	}

	// Verify year details
	public boolean verifyYearDetails(String expectedYear) {
		return getYearDetails().getText().contains(expectedYear);
	}

	// Verify all career service data
	public boolean verifyAllCareerServiceData(String company, String industry, String jobLvl, String job,
			String location, String relocateValue, String empType, String expectedCTC, String prefLocation,
			String qualificationText) {

		return getCompanyName().getText().trim().equalsIgnoreCase(company.trim())
				&& getCurrentIndustry().getText().trim().equalsIgnoreCase(industry.trim())
				&& getJobLevel().getText().trim().equalsIgnoreCase(jobLvl.trim())
				&& getJobType().getText().trim().equalsIgnoreCase(job.trim())
				&& getCurrentLocation().getText().toLowerCase().contains(location.toLowerCase())
				&& getRelocate().getText().trim().equalsIgnoreCase(relocateValue.trim())
				&& getEmploymentType().getText().trim().equalsIgnoreCase(empType.trim())
				&& getCtc().getText().trim().equalsIgnoreCase(expectedCTC.trim())
				&& getPreferredLocation().getText().toLowerCase().contains(prefLocation.toLowerCase())
				&& getQualification().getText().toLowerCase().contains(qualificationText.toLowerCase());
	}
}