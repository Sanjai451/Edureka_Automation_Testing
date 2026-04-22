package com.edureka.stepDefinition;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * Step Definition class for Post Job functionality in Cucumber BDD tests.
 * This class contains step definitions for posting a job on the platform,
 * including filling out job details, company information, and contact details.
 */
public class PostJobSteps extends AllFunctionality {

    private Base base;

    /**
     * Constructor to initialize PostJobSteps with Base instance.
     * @param base The Base instance for driver and utilities.
     */
    public PostJobSteps(Base base) {
        this.base = base;
    }

    /**
     * Step: Given user clicks Hire from Edureka link
     * Clicks on the "Hire from Edureka" link to navigate to the job posting page.
     */
    @Given("user clicks Hire from Edureka link")
    public void user_clicks_hire_from_edureka_link() {
        Pages.get().dashboard.clickHireFromEdureka(base.getDriver());
    }

    /**
     * Step: When user enters job title {string}
     * Enters the job title into the job posting form.
     * @param jobTitle The job title to enter.
     */
    @When("user enters job title {string}")
    public void user_enters_job_title(String jobTitle) {
        Pages.get().postJobPage.enterJobTitle(jobTitle);
    }

    /**
     * Step: When user enters number of vacancies {string}
     * Enters the number of vacancies for the job.
     * @param vacancies The number of vacancies.
     */
    @When("user enters number of vacancies {string}")
    public void user_enters_number_of_vacancies(String vacancies) {
        Pages.get().postJobPage.enterVacancies(vacancies);
    }

    /**
     * Step: When user enters job description {string}
     * Enters the job description into the form.
     * @param jobDescription The job description text.
     */
    @When("user enters job description {string}")
    public void user_enters_job_description(String jobDescription) {
        Pages.get().postJobPage.enterJobDescription(jobDescription);
    }

    /**
     * Step: When user enters candidate profile {string}
     * Enters the candidate profile requirements.
     * @param candidateProfile The candidate profile description.
     */
    @When("user enters candidate profile {string}")
    public void user_enters_candidate_profile(String candidateProfile) {
        Pages.get().postJobPage.enterCandidateProfile(candidateProfile);
    }

    /**
     * Step: When user selects work experience
     * Selects the work experience requirement from the dropdown.
     */
    @When("user selects work experience")
    public void user_selects_work_experience() {
        Pages.get().postJobPage.selectWorkExperience(base.getDriver());
    }

    /**
     * Step: When user enters minimum salary {string}
     * Enters the minimum salary for the job.
     * @param minSalary The minimum salary amount.
     */
    @When("user enters minimum salary {string}")
    public void user_enters_minimum_salary(String minSalary) {
        Pages.get().postJobPage.enterMinSalary(minSalary);
    }

    /**
     * Step: When user enters maximum salary {string}
     * Enters the maximum salary for the job.
     * @param maxSalary The maximum salary amount.
     */
    @When("user enters maximum salary {string}")
    public void user_enters_maximum_salary(String maxSalary) {
        Pages.get().postJobPage.enterMaxSalary(maxSalary);
    }

    /**
     * Step: When user selects country {string}
     * Selects the country for the job location.
     * @param country The country name.
     */
    @When("user selects country {string}")
    public void user_selects_country(String country) {
        Pages.get().postJobPage.selectCountry(base.getDriver(), country);
    }

    /**
     * Step: When user enters the company name {string}
     * Enters the company name.
     * @param companyName The company name.
     */
    @When("user enters the company name {string}")
    public void user_enters_company_name(String companyName) {
        Pages.get().postJobPage.enterCompanyName(companyName);
    }

    /**
     * Step: When user enters the first name {string}
     * Enters the contact person's first name.
     * @param firstName The first name.
     */
    @When("user enters the first name {string}")
    public void user_enters_first_name(String firstName) {
        Pages.get().postJobPage.enterFirstName(firstName);
    }

    /**
     * Step: When user enters the last name {string}
     * Enters the contact person's last name.
     * @param lastName The last name.
     */
    @When("user enters the last name {string}")
    public void user_enters_last_name(String lastName) {
        Pages.get().postJobPage.enterLastName(lastName);
    }

    /**
     * Step: When user enters the mobile {string}
     * Enters the contact mobile number.
     * @param mobile The mobile number.
     */
    @When("user enters the mobile {string}")
    public void user_enters_mobile(String mobile) {
        Pages.get().postJobPage.enterMobile(mobile);
    }

    /**
     * Step: When user enters the email {string}
     * Enters the contact email address.
     * @param email The email address.
     */
    @When("user enters the email {string}")
    public void user_enters_email(String email) {
        Pages.get().postJobPage.enterEmail(email);
    }

    /**
     * Step: When user enters company url {string}
     * Enters the company website URL.
     * @param companyUrl The company URL.
     */
    @When("user enters company url {string}")
    public void user_enters_company_url(String companyUrl) {
        Pages.get().postJobPage.enterCompanyUrl(companyUrl);
    }

    /**
     * Step: When user clicks post job button
     * Clicks the "Post Job" button to submit the job posting.
     */
    @When("user clicks post job button")
    public void user_clicks_post_job_button() {
        Pages.get().postJobPage.clickPostJob(base.getDriver());
    }
}