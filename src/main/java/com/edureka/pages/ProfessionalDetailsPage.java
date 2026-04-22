package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProfessionalDetailsPage {

    // Locators for professional details page elements

    @FindBy(xpath = "//a[@aria-controls='professionalDetails']")
    private WebElement professionalDetailsTab;

    @FindBy(name = "companyName")
    private WebElement companyNameInput;

    @FindBy(name = "linkedinLink")
    private WebElement linkedinInput;

    @FindBy(name = "userSkill")
    private WebElement skillsInput;

    @FindBy(name = "currentjob")
    private WebElement currentJobLevelDropdown;

    @FindBy(name = "currentIndustry")
    private WebElement currentIndustryDropdown;

    @FindBy(css = "[type='file']")
    private WebElement resumeUploadInput;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElement nextButton;

    // Getter methods

    public WebElement getProfessionalDetailsTab() {
        return professionalDetailsTab;
    }

    public WebElement getCompanyNameInput() {
        return companyNameInput;
    }

    public WebElement getLinkedinInput() {
        return linkedinInput;
    }

    public WebElement getSkillsInput() {
        return skillsInput;
    }

    public WebElement getCurrentJobLevelDropdown() {
        return currentJobLevelDropdown;
    }

    public WebElement getCurrentIndustryDropdown() {
        return currentIndustryDropdown;
    }

    public WebElement getResumeUploadInput() {
        return resumeUploadInput;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    // Methods to interact with professional details page

    public void clickProfessionalDetailsTab() {
        getProfessionalDetailsTab().click();
    }

    public void enterCompanyName(String companyName) {
        getCompanyNameInput().clear();
        getCompanyNameInput().sendKeys(companyName);
    }

    public void enterLinkedin(String linkedin) {
        getLinkedinInput().clear();
        getLinkedinInput().sendKeys(linkedin);
    }

    public void enterSkills(String skills) {
        getSkillsInput().clear();
        getSkillsInput().sendKeys(skills);
    }

    public void selectJobLevel(String value) {
        new Select(getCurrentJobLevelDropdown()).selectByVisibleText(value);
    }

    public void selectIndustry(String value) {
        new Select(getCurrentIndustryDropdown()).selectByVisibleText(value);
    }

    public void uploadResume(String filePath) {
        getResumeUploadInput().sendKeys(filePath);
    }

    public void clickNextButton() {
        if (getNextButton().isEnabled()) {
            getNextButton().click();
        } else {
            System.out.println("Next button is disabled");
        }
    }

    // Method to fill complete professional details form

    public void fillProfessionalDetails(String company, String linkedin,
                                        String skills, String jobLevel,
                                        String industry, String resumePath) {

        clickProfessionalDetailsTab();
        enterCompanyName(company);
        enterLinkedin(linkedin);
        enterSkills(skills);
        selectJobLevel(jobLevel);
        selectIndustry(industry);
        uploadResume(resumePath);
        clickNextButton();
    }
}