package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.edureka.utility.Base;
import com.edureka.utility.ExtentReportManager;
import com.edureka.utility.Pages;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.utility.AllFunctionality;

public class ChangePassword extends AllFunctionality {

	private Base base;
	private ExtentTest logs;

	public ChangePassword(Base base) {
		this.base = base;
		logs = ExtentReportManager.getTest();
	}

	String existingPassword;
	String newPassword;
	String confirmPassword;

	// CLICK TAB
	@Given("user clicks on Change Password tab")
	public void user_clicks_on_change_password_tab() {
		Pages.get().myProfile.clickChangePassword();
		logs.log(Status.PASS, "Clicked on Change Password tab");
	}

	// SCENARIO 1 (DataTable)

	@When("user enters password details")
	public void user_enters_password_details(DataTable dataTable) {

		List<List<String>> data = dataTable.asLists();

		existingPassword = data.get(0).get(1);
		newPassword = data.get(1).get(1);
		confirmPassword = data.get(2).get(1);

		Pages.get().changePasswordPage.enterExistingPassword(existingPassword);
		Pages.get().changePasswordPage.enterNewPassword(newPassword);
		Pages.get().changePasswordPage.enterConfirmPassword(confirmPassword);
		logs.log(Status.PASS, "Entered password details using DataTable");
	}

	// SCENARIO OUTLINE

	@When("user enters existing password {string}")
	public void user_enters_existing_password(String value) {
		existingPassword = value;
		Pages.get().changePasswordPage.enterExistingPassword(value);
		 logs.log(Status.PASS, "Entered Existing Password");
	}

	@When("user enters new password {string}")
	public void user_enters_new_password(String value) {
		newPassword = value;
		Pages.get().changePasswordPage.enterNewPassword(value);
		 logs.log(Status.PASS, "Entered New Password");
	}

	@When("user enters confirm password {string}")
	public void user_enters_confirm_password(String value) {
		confirmPassword = value;
		Pages.get().changePasswordPage.enterConfirmPassword(value);
		logs.log(Status.PASS, "Entered Confirm Password");
	}

	// SUBMIT
	@When("user clicks Submit button")
	public void user_clicks_submit_button() {
		Pages.get().changePasswordPage.clickSubmit();
		logs.log(Status.PASS, "Clicked Submit button");
	}

	// SUCCESS MESSAGE
	@Then("password should be updated successfully")
	public void password_should_be_updated_successfully() {

		String pageSource = getPageSource(base.getDriver());

		Assert.assertTrue(pageSource.toLowerCase().contains("success"), "Password update success message not found");
		 logs.log(Status.PASS, "Password updated successfully");
	}

	// VALIDATION MESSAGE
	@Then("{string} should be displayed")
	public void should_be_displayed(String message) {

		String pageSource = getPageSource(base.getDriver());

		Assert.assertTrue(pageSource.toLowerCase().contains(message.toLowerCase()),
				"Expected message not found: " + message);
		logs.log(Status.PASS, "Validation message displayed correctly: " + message);
	}
}