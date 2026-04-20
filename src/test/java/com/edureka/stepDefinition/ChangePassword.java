package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.edureka.utility.Base;
import com.edureka.utility.Pages;
import com.edureka.utility.AllFunctionality;

public class ChangePassword extends AllFunctionality {

    private Base base;
    private Pages pages;

    public ChangePassword(Base base) {
        this.base = base;
//        page = new Pages(base.getDriver());
    }


    String existingPassword;
    String newPassword;
    String confirmPassword;

    // CLICK TAB
    @Given("user clicks on Change Password tab")
    public void user_clicks_on_change_password_tab() {
        Pages.myProfile.clickChangePassword();
    }

    // SCENARIO 1 (DataTable) 

    @When("user enters password details")
    public void user_enters_password_details(DataTable dataTable) {

        List<List<String>> data = dataTable.asLists();

        existingPassword = data.get(0).get(1);
        newPassword = data.get(1).get(1);
        confirmPassword = data.get(2).get(1);

        Pages.changePasswordPage.enterExistingPassword(existingPassword);
        Pages.changePasswordPage.enterNewPassword(newPassword);
        Pages.changePasswordPage.enterConfirmPassword(confirmPassword);
    }

    //  SCENARIO OUTLINE 

    @When("user enters existing password {string}")
    public void user_enters_existing_password(String value) {
        existingPassword = value;
        Pages.changePasswordPage.enterExistingPassword(value);
    }

    @When("user enters new password {string}")
    public void user_enters_new_password(String value) {
        newPassword = value;
        Pages.changePasswordPage.enterNewPassword(value);
    }

    @When("user enters confirm password {string}")
    public void user_enters_confirm_password(String value) {
        confirmPassword = value;
        Pages.changePasswordPage.enterConfirmPassword(value);
    }

    // SUBMIT
    @When("user clicks Submit button")
    public void user_clicks_submit_button() {
        Pages.changePasswordPage.clickSubmit();
    }

    // SUCCESS MESSAGE
    @Then("password should be updated successfully")
    public void password_should_be_updated_successfully() {

        String pageSource = getPageSource(base.getDriver());

        Assert.assertTrue(
                pageSource.toLowerCase().contains("success"),
                "Password update success message not found"
        );
    }

    // VALIDATION MESSAGE
    @Then("{string} should be displayed")
    public void should_be_displayed(String message) {

        String pageSource = getPageSource(base.getDriver());

        Assert.assertTrue(
                pageSource.toLowerCase().contains(message.toLowerCase()),
                "Expected message not found: " + message
        );
    }
}