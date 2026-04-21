package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class AddInstructorSteps extends AllFunctionality {

    private Base base;

    public AddInstructorSteps(Base base) {
        this.base = base;
    }

    // Navigation

    @Given("user clicks Become an Instructor link")
    public void user_clicks_become_instructor_link() {
        Pages.get().dashboard.clickBecomeInstructor(base.getDriver());
    }

    // Form Filling

    @When("user enters first name {string}")
    public void user_enters_first_name(String firstName) {
        Pages.get().addInstructorPage.enterFirstName(firstName);
    }

    @When("user enters last name {string}")
    public void user_enters_last_name(String lastName) {
        Pages.get().addInstructorPage.enterLastName(lastName);
    }

    @When("user enters mobile {string}")
    public void user_enters_mobile(String mobile) {
        Pages.get().addInstructorPage.enterMobile(mobile);
    }

    @When("user enters email {string}")
    public void user_enters_email(String email) {
        Pages.get().addInstructorPage.enterEmail(email);
    }

    @When("user enters course name {string}")
    public void user_enters_course_name(String course) {
        Pages.get().addInstructorPage.enterCourseName(course);
    }

    @When("user enters linkedin {string}")
    public void user_enters_linkedin(String linkedin) {
        Pages.get().addInstructorPage.enterLinkedIn(linkedin);
    }

    @When("user enters about course {string}")
    public void user_enters_about_course(String aboutCourse) {
        Pages.get().addInstructorPage.enterAboutCourse(aboutCourse);
    }

    @When("user enters about yourself {string}")
    public void user_enters_about_yourself(String aboutYourself) {
        Pages.get().addInstructorPage.enterAboutYourself(aboutYourself);
    }

    // Submit

    @When("user clicks submit button")
    public void user_clicks_submit_button() {
        Pages.get().addInstructorPage.clickSubmit(base.getDriver());
    }

    // Validation

    @Then("instructor form should be submitted successfully")
    public void instructor_form_should_be_submitted_successfully() {

        String currentUrl = base.getDriver().getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        // Example validation (modify based on actual app behavior)
        Assert.assertTrue(
                currentUrl.contains("instructor") || currentUrl.contains("success"),
                "Instructor form submission failed"
        );
    }
}