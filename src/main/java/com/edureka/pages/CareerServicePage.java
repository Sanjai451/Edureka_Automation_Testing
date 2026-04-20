package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerServicePage {

	@FindBy(xpath = "//h4[contains(text(),'Professional Details')]/ancestor::div[contains(@class,'details-heading')]//a")
	private WebElement professionalDetailsEditBtn;

	@FindBy(xpath = "//h4[contains(text(),'Career Interests')]/ancestor::div[contains(@class,'details-heading')]//a")
	private WebElement careerInterestsEditBtn;

	@FindBy(xpath = "//h4[contains(text(),'Other Details')]/ancestor::div[contains(@class,'details-heading')]//a")
	private WebElement otherDetailsEditBtn;

	@FindBy(xpath = "(//span[text()='Company Name']/following-sibling::span)[1]")
	private WebElement companyName;

	@FindBy(xpath = "//span[text()='Current Industry']/following-sibling::span")
	private WebElement currentIndustry;

	@FindBy(xpath = "(//span[text()='Your Current Job Level']/following-sibling::span)[1]")
	private WebElement jobLevel;

	@FindBy(xpath = "//span[text()='Skills']/following-sibling::span")
	private WebElement skills;

	@FindBy(xpath = "(//span[contains(text(),'Types of jobs')]/following-sibling::span)[1]")
	private WebElement jobType;

	@FindBy(xpath = "(//span[text()='Current Location']/following-sibling::span)[1]")
	private WebElement currentLocation;

	@FindBy(xpath = "//span[text()='Relocate']/following-sibling::span")
	private WebElement relocate;

	@FindBy(xpath = "(//span[contains(text(),'Employment types')]/following-sibling::span)[1]")
	private WebElement employmentType;

	@FindBy(xpath = "(//span[text()='Current/Last drawn CTC']/following-sibling::span[@class='details'])[1]")
	private WebElement ctc;

	@FindBy(xpath = "//span[text()='Preferred Location']/following-sibling::span")
	private WebElement preferredLocation;

	@FindBy(xpath = "(//span[contains(@class,'details institute-name')])[1]")
	private WebElement qualification;

	@FindBy(xpath = "//span[contains(@class,'year')]")
	private WebElement yearDetails;

	public WebElement getProfessionalDetailsEditBtn() {
		return professionalDetailsEditBtn;
	}

	public WebElement getCareerInterestsEditBtn() {
		return careerInterestsEditBtn;
	}

	public WebElement getOtherDetailsEditBtn() {
		return otherDetailsEditBtn;
	}

	public WebElement getCompanyName() {
		return companyName;
	}

	public WebElement getCurrentIndustry() {
		return currentIndustry;
	}

	public WebElement getJobLevel() {
		return jobLevel;
	}

	public WebElement getSkills() {
		return skills;
	}

	public WebElement getJobType() {
		return jobType;
	}

	public WebElement getCurrentLocation() {
		return currentLocation;
	}

	public WebElement getRelocate() {
		return relocate;
	}

	public WebElement getEmploymentType() {
		return employmentType;
	}

	public WebElement getCtc() {
		return ctc;
	}

	public WebElement getPreferredLocation() {
		return preferredLocation;
	}

	public WebElement getQualification() {
		return qualification;
	}

	public WebElement getYearDetails() {
		return yearDetails;
	}

	public void clickProfessionalDetailsEdit() {
		getProfessionalDetailsEditBtn().click();
	}

	public void clickCareerInterestsEdit() {
		getCareerInterestsEditBtn().click();
	}

	public void clickOtherDetailsEdit() {
		getOtherDetailsEditBtn().click();
	}

	public boolean verifyText(WebElement element, String expected) {
		return element.getText().trim().equalsIgnoreCase(expected);
	}

	public boolean verifyProfessionalDetails(String company, String industry, String jobLvl, String skill) {

		return verifyText(getCompanyName(), company) && verifyText(getCurrentIndustry(), industry)
				&& verifyText(getJobLevel(), jobLvl) && verifyText(getSkills(), skill);
	}

	public boolean verifyCareerInterests(String job, String location, String relocateValue, String empType,
			String expectedCTC, String prefLocation) {

		return verifyText(getJobType(), job) && verifyText(getCurrentLocation(), location)
				&& verifyText(getRelocate(), relocateValue) && verifyText(getEmploymentType(), empType)
				&& verifyText(getCtc(), expectedCTC) && verifyText(getPreferredLocation(), prefLocation);
	}

	public boolean verifyOtherDetails(String expectedQualification) {
		return getQualification().getText().contains(expectedQualification);
	}

	public boolean verifyYearDetails(String expectedYear) {
		return getYearDetails().getText().contains(expectedYear);
	}

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