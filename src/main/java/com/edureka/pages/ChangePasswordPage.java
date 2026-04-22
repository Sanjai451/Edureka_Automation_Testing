package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage {

    // Locators for password fields and submit button

    @FindBy(css = "input[placeholder='Enter Existing Password']")
    private WebElement existingPasswordInput;

    @FindBy(css = "input[placeholder='New Password']")
    private WebElement newPasswordInput;

    // Locator for confirm password field
    @FindBy(css = "input[placeholder='Confirm New Password']")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    // Getter methods for all elements

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

    // Methods to enter password values

    public void enterExistingPassword(String existingPassword) {
        existingPasswordInput.clear();
        existingPasswordInput.sendKeys(existingPassword);
    }

    public void enterNewPassword(String newPassword) {
        newPasswordInput.clear();
        newPasswordInput.sendKeys(newPassword);
    }

    // Method to enter confirm password

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    // Method to click submit button

    public void clickSubmit() {
        submitButton.click();
    }

    // Method to perform complete password change action

    public void changePassword(String oldPassword, String newPassword, String confirmPassword) {
        enterExistingPassword(oldPassword);
        enterNewPassword(newPassword);
        enterConfirmPassword(confirmPassword); 
        clickSubmit();
    }

    // Method to check if submit button is enabled

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }
}