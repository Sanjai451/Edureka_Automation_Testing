package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class Personalize {

    private Base base;
    AllFunctionality util = new AllFunctionality();

    public Personalize(Base base) {
        this.base = base;
    }

    // ================= EXCEL DATA =================

    String name, designation, industry, experience;
    String timezone, prefTimezone, weekFrom, weekTo, weekendFrom, weekendTo;
    String learningGoal;
    String day1, from1, to1;
    String day2, from2, to2;

    // ================= EDIT BUTTONS =================

    @When("user clicks edit for user details")
    public void click_edit_user_details() {
        Pages.get().myProfile.clickUserDetailsEdit();
    }

    @When("user clicks edit for learning goals")
    public void click_edit_learning_goals() {
        Pages.get().myProfile.clickLearningGoalsEdit();
    }

    @When("user clicks edit for study plan")
    public void click_edit_study_plan() {
        Pages.get().myProfile.clickStudyPlanEdit();
    }

    // ================= USER DETAILS =================

    @When("user reads personal details from excel")
    public void read_user_details() {

        util.init("Personalize");

        name = util.getData(1, 0);
        designation = util.getData(1, 1);
        industry = util.getData(1, 2);
        experience = util.getData(1, 3);
        timezone = util.getData(1, 4);
        prefTimezone = util.getData(1, 5);
        weekFrom = util.getData(1, 6);
        weekTo = util.getData(1, 7);
        weekendFrom = util.getData(1, 8);
        weekendTo = util.getData(1, 9);
    }

    @When("user fills all user details from excel")
    public void fill_user_details() {

    	// 1. Name (top field)
    	Pages.get().userDetailsPage.enterFullName(name);

    	// 2. Experience (FIRST dropdown in UI)
    	Pages.get().userDetailsPage.selectFromDropdown(
    	        Pages.get().userDetailsPage.getExperienceDropdown(), experience);

    	// 3. Industry (SECOND dropdown)
    	Pages.get().userDetailsPage.selectFromDropdown(
    	        Pages.get().userDetailsPage.getIndustryDropdown(), industry);

    	// 4. Designation (after dropdowns)
    	Pages.get().userDetailsPage.enterDesignation(designation);

    	// 5. Current Timezone
    	Pages.get().userDetailsPage.selectFromDropdown(
    	        Pages.get().userDetailsPage.getCurrentTimezoneDropdown(), timezone);

    	// 6. Preferred Timezone
    	Pages.get().userDetailsPage.selectFromDropdown(
    	        Pages.get().userDetailsPage.getPreferredTimezoneDropdown(), prefTimezone);

    	// 7. Weekdays (From → To)
    	Pages.get().userDetailsPage.selectFromDropdown(
    	        Pages.get().userDetailsPage.getWeekdaysFromDropdown(), weekFrom);

    	Pages.get().userDetailsPage.selectFromDropdown(
    	        Pages.get().userDetailsPage.getWeekdaysToDropdown(), weekTo);

    	// 8. Weekends (From → To)
    	Pages.get().userDetailsPage.selectFromDropdown(
    	        Pages.get().userDetailsPage.getWeekendsFromDropdown(), weekendFrom);

    	Pages.get().userDetailsPage.selectFromDropdown(
    	        Pages.get().userDetailsPage.getWeekendsToDropdown(), weekendTo);
    }

    @When("user clicks Save and Continue")
    public void click_save_continue() {
        Pages.get().userDetailsPage.clickSaveAndContinue();
    }

    @Then("user should be navigated to Learning Goals page")
    public void validate_learning_page() {
        Assert.assertTrue(Pages.get().learningGoalsPage.getSaveAndContinueButton().isDisplayed());
    }

    // ================= LEARNING GOALS =================

    @When("user reads learning goal from excel")
    public void read_learning_goal() {
        util.init("LearningGoals");
        learningGoal = util.getData(1, 0);
    }

    @When("user selects learning goal from excel")
    public void select_learning_goal() {
        Pages.get().learningGoalsPage.selectLearningGoal(learningGoal);
    }

    @Then("user should be navigated to Study Plan page")
    public void validate_study_plan_page() {
        Assert.assertTrue(Pages.get().studyPlanPage.getSaveButton().isDisplayed());
    }

    // ================= STUDY PLAN =================

    @When("user reads study plan data from excel")
    public void read_study_plan() {

        util.init("StudyPlan");

        day1 = util.getData(1, 0);
        from1 = util.getData(1, 1);
        to1 = util.getData(1, 2);

        day2 = util.getData(2, 0);
        from2 = util.getData(2, 1);
        to2 = util.getData(2, 2);
    }

    @When("user fills study plan from excel")
    public void fill_study_plan1() {
        Pages.get().studyPlanPage.fillStudyPlan(day1, from1, to1);
    }

//    @When("user adds another study plan")
//    public void add_another_plan() {
//        Pages.get().studyPlanPage.clickAddDay();
//    }
//
//    @When("user fills second study plan from excel")
//    public void fill_study_plan2() {
//        Pages.get().studyPlanPage.fillStudyPlan(day2, from2, to2);
//    }

    @When("user clicks Save")
    public void click_save() {
        Pages.get().studyPlanPage.clickSave();
    }

    // ================= FINAL VALIDATION =================

    @Then("all entered data should be displayed correctly in profile")
    public void validate_profile() {

        String actualName = Pages.get().myProfile.getName()
                .replace(".", "")
                .trim();

        String expectedName = name.trim();

        Assert.assertTrue(
            actualName.equalsIgnoreCase(expectedName),
            "Name mismatch"
        );

        Assert.assertTrue(
            Pages.get().myProfile.verifyLearningGoal(learningGoal),
            "Learning goal mismatch"
        );

    }
    String invalidDesignation;

    @When("user reads invalid designation from excel")
    public void read_invalid_designation() {
        util.init("InvalidData");
        invalidDesignation = util.getData(1, 0);
    }

    @When("user enters invalid designation from excel")
    public void enter_invalid_designation() {

        Pages.get().userDetailsPage.enterDesignation(invalidDesignation);
    }

   
    @Given("user clicks on Personalize tab")
    public void user_clicks_on_personalize_tab() {
        Pages.get().myProfile.clickPersonalize();
    }
    @Then("system should not accept invalid designation")
    public void invalid_designation_should_not_be_accepted() {

        boolean isNavigated;

        try {
            isNavigated = Pages.get().myProfile.getUserDetailsEdit().isDisplayed();
        } catch (Exception e) {
            isNavigated = false;
        }

        Assert.assertFalse(
            isNavigated,
            "BUG: Invalid designation is accepted and saved!"
        );
    }
}