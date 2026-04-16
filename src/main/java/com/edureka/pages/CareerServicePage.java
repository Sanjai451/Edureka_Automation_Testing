package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerServicePage {

    // Edit buttons

    @FindBy(xpath = "//h4[contains(text(),'Professional Details')]/ancestor::div[contains(@class,'details-heading')]//a")
    private WebElement professionalDetailsEditBtn;

    @FindBy(xpath = "//h4[contains(text(),'Career Interests')]/ancestor::div[contains(@class,'details-heading')]//a")
    private WebElement careerInterestsEditBtn;

    @FindBy(xpath = "//h4[contains(text(),'Other Details')]/ancestor::div[contains(@class,'details-heading')]//a")
    private WebElement otherDetailsEditBtn;

    // Professional details

    @FindBy(xpath = "//span[text()='Company Name']/following-sibling::span")
    private WebElement companyName;

    @FindBy(xpath = "//span[text()='Current Industry']/following-sibling::span")
    private WebElement currentIndustry;

    @FindBy(xpath = "//span[text()='Your Current Job Level']/following-sibling::span")
    private WebElement jobLevel;

    @FindBy(xpath = "//span[text()='Skills']/following-sibling::span")
    private WebElement skills;

    // Career interests

    @FindBy(xpath = "//span[contains(text(),'Types of jobs')]/following-sibling::span")
    private WebElement jobType;

    @FindBy(xpath = "//span[text()='Current Location']/following-sibling::span")
    private WebElement currentLocation;

    @FindBy(xpath = "//span[text()='Relocate']/following-sibling::span")
    private WebElement relocate;

    @FindBy(xpath = "//span[contains(text(),'Employment types')]/following-sibling::span")
    private WebElement employmentType;

    @FindBy(xpath = "//span[contains(text(),'Current/last drawn CTC')]/following-sibling::span")
    private WebElement ctc;

    @FindBy(xpath = "//span[text()='Preferred Location']/following-sibling::span")
    private WebElement preferredLocation;

    // Other details

    @FindBy(xpath = "//span[contains(@class,'details institute-name')]")
    private WebElement qualification;

    @FindBy(xpath = "//span[contains(@class,'year')]")
    private WebElement yearDetails;

    // Getters

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

    // Business methods

    public void clickProfessionalDetailsEdit() {
        professionalDetailsEditBtn.click();
    }

    public void clickCareerInterestsEdit() {
        careerInterestsEditBtn.click();
    }

    public void clickOtherDetailsEdit() {
        otherDetailsEditBtn.click();
    }

    // Validation methods

    public boolean verifyText(WebElement element, String expected) {
        return element.getText().trim().equalsIgnoreCase(expected);
    }

    public boolean verifyProfessionalDetails(String company, String industry,
                                             String jobLvl, String skill) {

        return verifyText(companyName, company) &&
               verifyText(currentIndustry, industry) &&
               verifyText(jobLevel, jobLvl) &&
               verifyText(skills, skill);
    }

    public boolean verifyCareerInterests(String job, String location,
                                         String relocateValue, String empType,
                                         String expectedCTC, String prefLocation) {

        return verifyText(jobType, job) &&
               verifyText(currentLocation, location) &&
               verifyText(relocate, relocateValue) &&
               verifyText(employmentType, empType) &&
               verifyText(ctc, expectedCTC) &&
               verifyText(preferredLocation, prefLocation);
    }

    public boolean verifyOtherDetails(String expectedQualification) {
        return qualification.getText().contains(expectedQualification);
    }

    public boolean verifyYearDetails(String expectedYear) {
        return yearDetails.getText().contains(expectedYear);
    }

    public boolean verifyAllCareerServiceData(String company, String industry,
                                             String jobLvl, String skill,
                                             String job, String location,
                                             String relocateValue, String empType,
                                             String expectedCTC, String prefLocation,
                                             String qualificationText) {

        return verifyProfessionalDetails(company, industry, jobLvl, skill) &&
               verifyCareerInterests(job, location, relocateValue, empType, expectedCTC, prefLocation) &&
               verifyOtherDetails(qualificationText);
    }
}