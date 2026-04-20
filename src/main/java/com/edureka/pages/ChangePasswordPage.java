package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage {

    // Locators

    @FindBy(css = "input[placeholder='Enter Existing Password']")
    private WebElement existingPasswordInput;

    @FindBy(css = "input[placeholder='New Password']")
    private WebElement newPasswordInput;

    // ✅ NEW - Confirm Password
    @FindBy(css = "input[placeholder='Confirm New Password']")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    // Getters

    public WebElement getExistingPasswordInput() {
        return existingPasswordInput;
    }

    public WebElement getNewPasswordInput() {
        return newPasswordInput;
    }

  
    public WebElement getConfirmPasswordInput() {
        return confirmPasswordInput;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    // Business methods

    public void enterExistingPassword(String existingPassword) {
        existingPasswordInput.clear();
        existingPasswordInput.sendKeys(existingPassword);
    }

    public void enterNewPassword(String newPassword) {
        newPasswordInput.clear();
        newPasswordInput.sendKeys(newPassword);
    }


    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    // Combined action

    public void changePassword(String oldPassword, String newPassword, String confirmPassword) {
        enterExistingPassword(oldPassword);
        enterNewPassword(newPassword);
        enterConfirmPassword(confirmPassword); 
        clickSubmit();
    }

    // Validation

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }
}