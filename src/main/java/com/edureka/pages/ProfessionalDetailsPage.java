package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProfessionalDetailsPage {

    // Locators

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

    @FindBy(id = "resume")
    private WebElement resumeUploadInput;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Next')]")
    private WebElement nextButton;

    // Getters

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

    // Business methods

    public void clickProfessionalDetailsTab() {
        professionalDetailsTab.click();
    }

    public void enterCompanyName(String companyName) {
        companyNameInput.clear();
        companyNameInput.sendKeys(companyName);
    }

    public void enterLinkedin(String linkedin) {
        linkedinInput.clear();
        linkedinInput.sendKeys(linkedin);
    }

    public void enterSkills(String skills) {
        skillsInput.clear();
        skillsInput.sendKeys(skills);
    }

    public void selectJobLevel(String value) {
        Select select = new Select(currentJobLevelDropdown);
        select.selectByVisibleText(value);
    }

    public void selectIndustry(String value) {
        Select select = new Select(currentIndustryDropdown);
        select.selectByVisibleText(value);
    }

    public void uploadResume(String filePath) {
        resumeUploadInput.sendKeys(filePath);
    }

    public void clickNextButton() {
        if (nextButton.isEnabled()) {
            nextButton.click();
        } else {
            System.out.println("Next button is disabled");
        }
    }

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
    }
}