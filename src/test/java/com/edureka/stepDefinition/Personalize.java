package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;
import com.edureka.utility.ExtentReportManager;

public class Personalize extends AllFunctionality {

    private Base base;
    private ExtentTest logs;

    public Personalize(Base base) {
        this.base = base;
        logs = ExtentReportManager.getTest();
    }

    String name, designation, industry, experience;
    String timezone, prefTimezone, weekFrom, weekTo, weekendFrom, weekendTo;
    String learningGoal;
    String day1, from1, to1;
    String day2, from2, to2;
    String invalidDesignation;

    // ================= EDIT BUTTONS =================

    @When("user clicks edit for user details")
    public void click_edit_user_details() {
        Pages.get().myProfile.clickUserDetailsEdit();
        logs.log(Status.PASS, "Clicked Edit for User Details");
    }

    @When("user clicks edit for learning goals")
    public void click_edit_learning_goals() {
        Pages.get().myProfile.clickLearningGoalsEdit();
        logs.log(Status.PASS, "Clicked Edit for Learning Goals");
    }

    @When("user clicks edit for study plan")
    public void click_edit_study_plan() {
        Pages.get().myProfile.clickStudyPlanEdit();
        logs.log(Status.PASS, "Clicked Edit for Study Plan");
    }

    // ================= USER DETAILS =================

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

        logs.log(Status.PASS, "Read User Details from Excel: " + name + ", " + designation);
    }

    @When("user fills all user details from excel")
    public void fill_user_details() {

        Pages.get().userDetailsPage.enterFullName(name);

        Pages.get().userDetailsPage.selectFromDropdown(
                Pages.get().userDetailsPage.getExperienceDropdown(), experience);

        Pages.get().userDetailsPage.selectFromDropdown(
                Pages.get().userDetailsPage.getIndustryDropdown(), industry);

        Pages.get().userDetailsPage.enterDesignation(designation);

        Pages.get().userDetailsPage.selectFromDropdown(
                Pages.get().userDetailsPage.getCurrentTimezoneDropdown(), timezone);

        Pages.get().userDetailsPage.selectFromDropdown(
                Pages.get().userDetailsPage.getPreferredTimezoneDropdown(), prefTimezone);

        Pages.get().userDetailsPage.selectFromDropdown(
                Pages.get().userDetailsPage.getWeekdaysFromDropdown(), weekFrom);

        Pages.get().userDetailsPage.selectFromDropdown(
                Pages.get().userDetailsPage.getWeekdaysToDropdown(), weekTo);

        Pages.get().userDetailsPage.selectFromDropdown(
                Pages.get().userDetailsPage.getWeekendsFromDropdown(), weekendFrom);

        Pages.get().userDetailsPage.selectFromDropdown(
                Pages.get().userDetailsPage.getWeekendsToDropdown(), weekendTo);

        logs.log(Status.PASS, "Filled User Details form");
    }

    @When("user clicks Save and Continue")
    public void click_save_continue() {
        Pages.get().userDetailsPage.clickSaveAndContinue();
        logs.log(Status.PASS, "Clicked Save and Continue");
    }

    @Then("user should be navigated to Learning Goals page")
    public void validate_learning_page() {
        Assert.assertTrue(Pages.get().learningGoalsPage.getSaveAndContinueButton().isDisplayed());
        logs.log(Status.PASS, "Navigated to Learning Goals page");
    }

    // ================= LEARNING GOALS =================

    @When("user reads learning goal from excel")
    public void read_learning_goal() {
        init("LearningGoals");
        learningGoal = getData(1, 0);
        logs.log(Status.PASS, "Read Learning Goal: " + learningGoal);
    }

    @When("user selects learning goal from excel")
    public void select_learning_goal() {
        Pages.get().learningGoalsPage.selectLearningGoal(learningGoal);
        logs.log(Status.PASS, "Selected Learning Goal");
    }

    @Then("user should be navigated to Study Plan page")
    public void validate_study_plan_page() {
        Assert.assertTrue(Pages.get().studyPlanPage.getSaveButton().isDisplayed());
        logs.log(Status.PASS, "Navigated to Study Plan page");
    }

    // ================= STUDY PLAN =================

    @When("user reads study plan data from excel")
    public void read_study_plan() {

        init("StudyPlan");

        day1 = getData(1, 0);
        from1 = getData(1, 1);
        to1 = getData(1, 2);

        logs.log(Status.PASS, "Read Study Plan: " + day1 + " (" + from1 + "-" + to1 + ")");
    }

    @When("user fills study plan from excel")
    public void fill_study_plan1() {
        Pages.get().studyPlanPage.fillStudyPlan(day1, from1, to1);
        logs.log(Status.PASS, "Filled Study Plan");
    }

    @When("user clicks Save")
    public void click_save() {
        Pages.get().studyPlanPage.clickSave();
        logs.log(Status.PASS, "Clicked Save button");
    }

    // ================= FINAL VALIDATION =================

    @Then("all entered data should be displayed correctly in profile")
    public void validate_profile() {

        String actualName = Pages.get().myProfile.getName().replace(".", "").trim();
        String expectedName = name.trim();

        logs.log(Status.PASS, "Validating Name: " + actualName);

        Assert.assertTrue(actualName.equalsIgnoreCase(expectedName), "Name mismatch");

        Assert.assertTrue(
                Pages.get().myProfile.verifyLearningGoal(learningGoal),
                "Learning goal mismatch"
        );

        logs.log(Status.PASS, "Profile data validated successfully");
    }

    // ================= NEGATIVE =================

    @When("user reads invalid designation from excel")
    public void read_invalid_designation() {
        init("InvalidData");
        invalidDesignation = getData(1, 0);
        logs.log(Status.PASS, "Read Invalid Designation");
    }

    @When("user enters invalid designation from excel")
    public void enter_invalid_designation() {
        Pages.get().userDetailsPage.enterDesignation(invalidDesignation);
        logs.log(Status.PASS, "Entered Invalid Designation");
    }

    @Given("user clicks on Personalize tab")
    public void user_clicks_on_personalize_tab() {
        Pages.get().myProfile.clickPersonalize();
        logs.log(Status.PASS, "Clicked Personalize tab");
    }

    @Then("system should not accept invalid designation")
    public void invalid_designation_should_not_be_accepted() {

        boolean isNavigated;

        try {
            isNavigated = Pages.get().myProfile.getUserDetailsEdit().isDisplayed();
        } catch (Exception e) {
            isNavigated = false;
        }

        logs.log(Status.PASS, "Validating invalid designation rejection");

        Assert.assertFalse(
                isNavigated,
                "BUG: Invalid designation is accepted and saved!"
        );

        logs.log(Status.PASS, "Invalid designation correctly rejected");
    }
}