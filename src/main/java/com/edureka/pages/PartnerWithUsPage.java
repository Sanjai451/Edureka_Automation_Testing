package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartnerWithUsPage {


    @FindBy(xpath = "//button[contains(text(),'PARTNER WITH US')]")
    private WebElement partnerWithUsButton;

    @FindBy(name = "first_name")
    private WebElement nameInput;

    @FindBy(name = "organization")
    private WebElement companyNameInput;

    @FindBy(id = "learnerCount")
    private WebElement trainingNeedDropdown;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(css= "[placeholder='Phone Number']")
    private WebElement phoneInput;

    @FindBy(name = "query")
    private WebElement queryTextArea;

    @FindBy(id = "corp-talk-modal-submit")
    private WebElement submitButton;

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

    public void clickPartnerWithUs(WebDriver driver) {
            getPartnerWithUsButton().click();
        
    }

    public void enterName(String name) {
        getNameInput().clear();
        getNameInput().sendKeys(name);
    }

    public void enterCompanyName(String company) {
        getCompanyNameInput().clear();
        getCompanyNameInput().sendKeys(company);
    }

    public void selectTrainingNeed(String value) {
        new org.openqa.selenium.support.ui.Select(getTrainingNeedDropdown())
                .selectByVisibleText(value);
    }

    public void enterEmail(String email) {
        getEmailInput().clear();
        getEmailInput().sendKeys(email);
    }

    public void enterPhone(String phone) {
        getPhoneInput().clear();
        getPhoneInput().sendKeys(phone);
    }

    public void enterQuery(String query) {
        getQueryTextArea().clear();
        getQueryTextArea().sendKeys(query);
    }

    public void clickSubmit(WebDriver driver) {
            getSubmitButton().click();
       
    }

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