package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class Personalize extends AllFunctionality {

	private Base base;

	// Constructor to initialize base
	public Personalize(Base base) {
		this.base = base;
	}

	// Variables for storing test data
	String name, designation, industry, experience;
	String timezone, prefTimezone, weekFrom, weekTo, weekendFrom, weekendTo;
	String learningGoal;
	String day1, from1, to1;
	String day2, from2, to2;
	String invalidDesignation;

	// Step to click edit user details
	@When("user clicks edit for user details")
	public void click_edit_user_details() {
		Pages.get().myProfile.clickUserDetailsEdit();
	}

	// Step to click edit learning goals
	@When("user clicks edit for learning goals")
	public void click_edit_learning_goals() {
		Pages.get().myProfile.clickLearningGoalsEdit();
	}

	// Step to click edit study plan
	@When("user clicks edit for study plan")
	public void click_edit_study_plan() {
		Pages.get().myProfile.clickStudyPlanEdit();
	}

	// Step to read user details from excel
	@When("user reads personal details from excel")
	public void read_user_details() {

		init("Personalize");

		name = getData(1, 0);
		designation = getData(1, 1);
		industry = getData(1, 2);
		experience = getData(1, 3);
		timezone = getData(1, 4);
		prefTimezone = getData(1, 5);
		weekFrom = getData(1, 6);
		weekTo = getData(1, 7);
		weekendFrom = getData(1, 8);
		weekendTo = getData(1, 9);
	}

	// Step to fill user details
	@When("user fills all user details from excel")
	public void fill_user_details() {

		Pages.get().userDetailsPage.enterFullName(name);

		Pages.get().userDetailsPage.selectFromDropdown(Pages.get().userDetailsPage.getExperienceDropdown(), experience);

		Pages.get().userDetailsPage.selectFromDropdown(Pages.get().userDetailsPage.getIndustryDropdown(), industry);

		Pages.get().userDetailsPage.enterDesignation(designation);

		Pages.get().userDetailsPage.selectFromDropdown(Pages.get().userDetailsPage.getCurrentTimezoneDropdown(),
				timezone);

		Pages.get().userDetailsPage.selectFromDropdown(Pages.get().userDetailsPage.getPreferredTimezoneDropdown(),
				prefTimezone);

		Pages.get().userDetailsPage.selectFromDropdown(Pages.get().userDetailsPage.getWeekdaysFromDropdown(), weekFrom);

		Pages.get().userDetailsPage.selectFromDropdown(Pages.get().userDetailsPage.getWeekdaysToDropdown(), weekTo);

		Pages.get().userDetailsPage.selectFromDropdown(Pages.get().userDetailsPage.getWeekendsFromDropdown(),
				weekendFrom);

		Pages.get().userDetailsPage.selectFromDropdown(Pages.get().userDetailsPage.getWeekendsToDropdown(), weekendTo);
	}

	// Step to click save and continue
	@When("user clicks Save and Continue")
	public void click_save_continue() {
		Pages.get().userDetailsPage.clickSaveAndContinue();
	}

	// Step to validate navigation to learning goals page
	@Then("user should be navigated to Learning Goals page")
	public void validate_learning_page() {
		Assert.assertTrue(Pages.get().learningGoalsPage.getSaveAndContinueButton().isDisplayed());
	}

	// Step to read learning goal data
	@When("user reads learning goal from excel")
	public void read_learning_goal() {
		init("LearningGoals");
		learningGoal = getData(1, 0);
	}

	// Step to select learning goal
	@When("user selects learning goal from excel")
	public void select_learning_goal() {
		Pages.get().learningGoalsPage.selectLearningGoal(learningGoal);
	}

	// Step to validate navigation to study plan page
	@Then("user should be navigated to Study Plan page")
	public void validate_study_plan_page() {
		Assert.assertTrue(Pages.get().studyPlanPage.getSaveButton().isDisplayed());
	}

	// Step to read study plan data
	@When("user reads study plan data from excel")
	public void read_study_plan() {

		init("StudyPlan");

		day1 = getData(1, 0);
		from1 = getData(1, 1);
		to1 = getData(1, 2);
	}

	// Step to fill study plan
	@When("user fills study plan from excel")
	public void fill_study_plan1() {
		Pages.get().studyPlanPage.fillStudyPlan(day1, from1, to1);
	}

	// Step to click save
	@When("user clicks Save")
	public void click_save() {
		Pages.get().studyPlanPage.clickSave();
	}

	// Step to validate final profile data
	@Then("all entered data should be displayed correctly in profile")
	public void validate_profile() {

		String actualName = Pages.get().myProfile.getName().replace(".", "").trim();
		String expectedName = name.trim();

		Assert.assertTrue(actualName.equalsIgnoreCase(expectedName), "Name mismatch");

		Assert.assertTrue(Pages.get().myProfile.verifyLearningGoal(learningGoal), "Learning goal mismatch");
	}

	// Step to read invalid designation
	@When("user reads invalid designation from excel")
	public void read_invalid_designation() {
		init("InvalidData");
		invalidDesignation = getData(1, 0);
	}

	// Step to enter invalid designation
	@When("user enters invalid designation from excel")
	public void enter_invalid_designation() {
		Pages.get().userDetailsPage.enterDesignation(invalidDesignation);
	}

	// Step to click personalize tab
	@Given("user clicks on Personalize tab")
	public void user_clicks_on_personalize_tab() {
		Pages.get().myProfile.clickPersonalize();
	}

	// Step to validate invalid designation not accepted
	@Then("system should not accept invalid designation")
	public void invalid_designation_should_not_be_accepted() {

		boolean isNavigated;

		try {
			isNavigated = Pages.get().myProfile.getUserDetailsEdit().isDisplayed();
		} catch (Exception e) {
			isNavigated = false;
		}

		Assert.assertFalse(isNavigated, "BUG: Invalid designation is accepted and saved!");
	}
}