package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import java.util.List;
import org.testng.Assert;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;
import com.edureka.utility.AllFunctionality;

public class ChangePassword extends AllFunctionality {

	private Base base;

	// Constructor to initialize base
	public ChangePassword(Base base) {
		this.base = base;
	}

	// Variables to store password values
	String existingPassword;
	String newPassword;
	String confirmPassword;

	// Step to click change password tab
	@Given("user clicks on Change Password tab")
	public void user_clicks_on_change_password_tab() {
		Pages.get().myProfile.clickChangePassword();
	}

	// Step to enter password details using data table
	@When("user enters password details")
	public void user_enters_password_details(DataTable dataTable) {

		List<List<String>> data = dataTable.asLists();

		existingPassword = data.get(0).get(1);
		newPassword = data.get(1).get(1);
		confirmPassword = data.get(2).get(1);

		Pages.get().changePasswordPage.enterExistingPassword(existingPassword);
		Pages.get().changePasswordPage.enterNewPassword(newPassword);
		Pages.get().changePasswordPage.enterConfirmPassword(confirmPassword);
	}

	// Step to enter existing password
	@When("user enters existing password {string}")
	public void user_enters_existing_password(String value) {
		existingPassword = value;
		Pages.get().changePasswordPage.enterExistingPassword(value);
	}

	// Step to enter new password
	@When("user enters new password {string}")
	public void user_enters_new_password(String value) {
		newPassword = value;
		Pages.get().changePasswordPage.enterNewPassword(value);
	}

	// Step to enter confirm password
	@When("user enters confirm password {string}")
	public void user_enters_confirm_password(String value) {
		confirmPassword = value;
		Pages.get().changePasswordPage.enterConfirmPassword(value);
	}

	// Step to click submit button
	@When("user clicks Submit button")
	public void user_clicks_submit_button() {
		Pages.get().changePasswordPage.clickSubmit();
	}

	// Step to validate success message
	@Then("password should be updated successfully")
	public void password_should_be_updated_successfully() {

		String pageSource = getPageSource(base.getDriver());

		Assert.assertTrue(pageSource.toLowerCase().contains("success"), "Password update success message not found");
	}

	// Step to validate error or validation message
	@Then("{string} should be displayed")
	public void should_be_displayed(String message) {

		String pageSource = getPageSource(base.getDriver());

		Assert.assertTrue(pageSource.toLowerCase().contains(message.toLowerCase()),
				"Expected message not found: " + message);
	}
}