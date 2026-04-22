package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartnerWithUsPage {

    // Locator for partner with us button
    @FindBy(xpath = "//button[contains(text(),'PARTNER WITH US')]")
    private WebElement partnerWithUsButton;

    // Locator for name input field
    @FindBy(name = "first_name")
    private WebElement nameInput;

    // Locator for company name input field
    @FindBy(name = "organization")
    private WebElement companyNameInput;

    // Locator for training need dropdown
    @FindBy(id = "learnerCount")
    private WebElement trainingNeedDropdown;

    // Locator for email input field
    @FindBy(name = "email")
    private WebElement emailInput;

    // Locator for phone input field
    @FindBy(css= "[placeholder='Phone Number']")
    private WebElement phoneInput;

    // Locator for query text area
    @FindBy(name = "query")
    private WebElement queryTextArea;

    // Locator for submit button
    @FindBy(id = "corp-talk-modal-submit")
    private WebElement submitButton;

    // Getter methods

    public WebElement getPartnerWithUsButton() {
        return partnerWithUsButton;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getCompanyNameInput() {
        return companyNameInput;
    }

    public WebElement getTrainingNeedDropdown() {
        return trainingNeedDropdown;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPhoneInput() {
        return phoneInput;
    }

    public WebElement getQueryTextArea() {
        return queryTextArea;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    // Method to click partner with us button

    public void clickPartnerWithUs(WebDriver driver) {
        getPartnerWithUsButton().click();
    }

    // Method to enter name

    public void enterName(String name) {
        getNameInput().clear();
        getNameInput().sendKeys(name);
    }

    // Method to enter company name

    public void enterCompanyName(String company) {
        getCompanyNameInput().clear();
        getCompanyNameInput().sendKeys(company);
    }

    // Method to select training need

    public void selectTrainingNeed(String value) {
        new org.openqa.selenium.support.ui.Select(getTrainingNeedDropdown())
                .selectByVisibleText(value);
    }

    // Method to enter email

    public void enterEmail(String email) {
        getEmailInput().clear();
        getEmailInput().sendKeys(email);
    }

    // Method to enter phone number

    public void enterPhone(String phone) {
        getPhoneInput().clear();
        getPhoneInput().sendKeys(phone);
    }

    // Method to enter query

    public void enterQuery(String query) {
        getQueryTextArea().clear();
        getQueryTextArea().sendKeys(query);
    }

    // Method to click submit button

    public void clickSubmit(WebDriver driver) {
        getSubmitButton().click();
    }

    // Method to fill partner form

    public void fillPartnerForm(String name, String company, String training,
                                String email, String phone, String query) {

        enterName(name);
        enterCompanyName(company);
        selectTrainingNeed(training);
        enterEmail(email);
        enterPhone(phone);
        enterQuery(query);
    }
}