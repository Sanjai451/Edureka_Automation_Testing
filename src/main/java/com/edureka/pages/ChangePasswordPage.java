package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
    // Locators

    @FindBy(css = "[placeholder='Enter Existing Password']")
    private WebElement existingPasswordInput;

    @FindBy(css = "[placeholder='New Password']")
    private WebElement newPasswordInput;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    // Getters

    public WebElement getExistingPasswordInput() {
        return existingPasswordInput;
    }

    public WebElement getNewPasswordInput() {
        return newPasswordInput;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    // Business Logic 

    public void enterExistingPassword(String existingPassword) {
        getExistingPasswordInput().clear();
        getExistingPasswordInput().sendKeys(existingPassword);
    }

    public void enterNewPassword(String newPassword) {
        getNewPasswordInput().clear();
        getNewPasswordInput().sendKeys(newPassword);
    }
    
    public void enterConfirmPassword(String newPassword) {
        getNewPasswordInput().clear();
        getNewPasswordInput().sendKeys(newPassword);
    }

    public void clickSubmit() {
        getSubmitButton().click();
    }

    // Combined Action 

    public void changePassword(String oldPassword, String newPassword) {
        enterExistingPassword(oldPassword);
        enterNewPassword(newPassword);
        clickSubmit();
    }
}