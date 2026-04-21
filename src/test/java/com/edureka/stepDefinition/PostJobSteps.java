package com.edureka.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class PostJobSteps extends AllFunctionality {

    private Base base;

    public PostJobSteps(Base base) {
        this.base = base;
    }

    @Given("user clicks Hire from Edureka link")
    public void user_clicks_hire_from_edureka_link() {
        Pages.get().dashboard.clickHireFromEdureka(base.getDriver());
    }

    @When("user enters job title {string}")
    public void user_enters_job_title(String jobTitle) {
        Pages.get().postJobPage.enterJobTitle(jobTitle);
    }

    @When("user enters number of vacancies {string}")
    public void user_enters_number_of_vacancies(String vacancies) {
        Pages.get().postJobPage.enterVacancies(vacancies);
    }

    @When("user enters job description {string}")
    public void user_enters_job_description(String jobDescription) {
        Pages.get().postJobPage.enterJobDescription(jobDescription);
    }

    @When("user enters candidate profile {string}")
    public void user_enters_candidate_profile(String candidateProfile) {
        Pages.get().postJobPage.enterCandidateProfile(candidateProfile);
    }

    @When("user selects work experience")
    public void user_selects_work_experience() {
        Pages.get().postJobPage.selectWorkExperience(base.getDriver());
    }

    @When("user enters minimum salary {string}")
    public void user_enters_minimum_salary(String minSalary) {
        Pages.get().postJobPage.enterMinSalary(minSalary);
    }

    @When("user enters maximum salary {string}")
    public void user_enters_maximum_salary(String maxSalary) {
        Pages.get().postJobPage.enterMaxSalary(maxSalary);
    }

    @When("user selects country {string}")
    public void user_selects_country(String country) {
        Pages.get().postJobPage.selectCountry(base.getDriver(), country);
    }

    @When("user enters the company name {string}")
    public void user_enters_company_name(String companyName) {
        Pages.get().postJobPage.enterCompanyName(companyName);
    }

    @When("user enters the first name {string}")
    public void user_enters_first_name(String firstName) {
        Pages.get().postJobPage.enterFirstName(firstName);
    }

    @When("user enters the last name {string}")
    public void user_enters_last_name(String lastName) {
        Pages.get().postJobPage.enterLastName(lastName);
    }

    @When("user enters the mobile {string}")
    public void user_enters_mobile(String mobile) {
        Pages.get().postJobPage.enterMobile(mobile);
    }

    @When("user enters the email {string}")
    public void user_enters_email(String email) {
        Pages.get().postJobPage.enterEmail(email);
    }

    @When("user enters company url {string}")
    public void user_enters_company_url(String companyUrl) {
        Pages.get().postJobPage.enterCompanyUrl(companyUrl);
    }

    @When("user clicks post job button")
    public void user_clicks_post_job_button() {
        Pages.get().postJobPage.clickPostJob(base.getDriver());
    }
}