package com.edureka.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model class for the Post Job page.
 * This class provides methods to interact with the job posting form,
 * including entering job details, company information, and contact details.
 */
public class PostJobPage {

    // Input field for job title
    @FindBy(id = "job_title")
    private WebElement jobTitleInput;

    // Input field for number of vacancies
    @FindBy(id = "no_vacancy")
    private WebElement vacanciesInput;

    // Text area for job description
    @FindBy(id = "job_description")
    private WebElement jobDescriptionTextArea;

    // Text area for candidate profile
    @FindBy(name = "data[Employer][candidate_profile]")
    private WebElement candidateProfileTextArea;

    // Dropdown for minimum work experience
    @FindBy(xpath = "//span[text()='Min Work Exp.']")
    private WebElement minWorkExpDropdown;

    // Input field for minimum salary
    @FindBy(id = "min_salary")
    private WebElement minSalaryInput;

    // Input field for maximum salary
    @FindBy(id = "max_salary")
    private WebElement maxSalaryInput;

    // Input field for company name
    @FindBy(id = "company_name")
    private WebElement companyNameInput;

    // Input field for contact person's first name
    @FindBy(id = "c_p_first_name")
    private WebElement firstNameInput;

    // Input field for contact person's last name
    @FindBy(id = "c_p_last_name")
    private WebElement lastNameInput;

    // Input field for contact mobile number
    @FindBy(id = "c_p_mobile")
    private WebElement mobileInput;

    // Input field for contact email
    @FindBy(name = "data[Employer][c_p_email]")
    private WebElement emailInput;

    // Input field for company URL
    @FindBy(name = "data[Employer][company_url]")
    private WebElement companyUrlInput;

    // Button to post the job
    @FindBy(name = "login")
    private WebElement postJobButton;

    // Country dropdown element
    @FindBy(xpath = "//div[@id='country_chosen']//span")
    private WebElement countryDropdown;

    // Search box within the country dropdown
    @FindBy(xpath = "//div[@id='country_chosen']//input")
    private WebElement countrySearchBox;

    /**
     * Getter for job title input field.
     * @return WebElement for job title input.
     */
    public WebElement getJobTitleInput() {
        return jobTitleInput;
    }

    /**
     * Getter for vacancies input field.
     * @return WebElement for vacancies input.
     */
    public WebElement getVacanciesInput() {
        return vacanciesInput;
    }

    /**
     * Getter for job description text area.
     * @return WebElement for job description text area.
     */
    public WebElement getJobDescriptionTextArea() {
        return jobDescriptionTextArea;
    }

    /**
     * Getter for candidate profile text area.
     * @return WebElement for candidate profile text area.
     */
    public WebElement getCandidateProfileTextArea() {
        return candidateProfileTextArea;
    }

    /**
     * Getter for minimum work experience dropdown.
     * @return WebElement for min work exp dropdown.
     */
    public WebElement getMinWorkExpDropdown() {
        return minWorkExpDropdown;
    }

    /**
     * Getter for minimum salary input field.
     * @return WebElement for min salary input.
     */
    public WebElement getMinSalaryInput() {
        return minSalaryInput;
    }

    /**
     * Getter for maximum salary input field.
     * @return WebElement for max salary input.
     */
    public WebElement getMaxSalaryInput() {
        return maxSalaryInput;
    }

    /**
     * Getter for company name input field.
     * @return WebElement for company name input.
     */
    public WebElement getCompanyNameInput() {
        return companyNameInput;
    }

    /**
     * Getter for first name input field.
     * @return WebElement for first name input.
     */
    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    /**
     * Getter for last name input field.
     * @return WebElement for last name input.
     */
    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    /**
     * Getter for mobile input field.
     * @return WebElement for mobile input.
     */
    public WebElement getMobileInput() {
        return mobileInput;
    }

    /**
     * Getter for email input field.
     * @return WebElement for email input.
     */
    public WebElement getEmailInput() {
        return emailInput;
    }

    /**
     * Getter for company URL input field.
     * @return WebElement for company URL input.
     */
    public WebElement getCompanyUrlInput() {
        return companyUrlInput;
    }

    /**
     * Getter for post job button.
     * @return WebElement for post job button.
     */
    public WebElement getPostJobButton() {
        return postJobButton;
    }

    /**
     * Getter for country dropdown.
     * @return WebElement for country dropdown.
     */
    public WebElement getCountryDropdown() {
        return countryDropdown;
    }

    /**
     * Getter for country search box.
     * @return WebElement for country search box.
     */
    public WebElement getCountrySearchBox() {
        return countrySearchBox;
    }

    /**
     * Enters the job title into the input field.
     * @param title The job title to enter.
     */
    public void enterJobTitle(String title) {
        getJobTitleInput().clear();
        getJobTitleInput().sendKeys(title);
    }

    /**
     * Enters the number of vacancies into the input field.
     * @param vacancies The number of vacancies.
     */
    public void enterVacancies(String vacancies) {
        getVacanciesInput().clear();
        getVacanciesInput().sendKeys(vacancies);
    }

    /**
     * Enters the job description into the text area.
     * @param desc The job description.
     */
    public void enterJobDescription(String desc) {
        getJobDescriptionTextArea().clear();
        getJobDescriptionTextArea().sendKeys(desc);
    }

    /**
     * Enters the candidate profile into the text area.
     * @param profile The candidate profile description.
     */
    public void enterCandidateProfile(String profile) {
        getCandidateProfileTextArea().clear();
        getCandidateProfileTextArea().sendKeys(profile);
    }

    /**
     * Selects the work experience from the dropdown (1-3 years).
     * @param driver The WebDriver instance.
     */
    public void selectWorkExperience(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", getMinWorkExpDropdown());
        wait.until(ExpectedConditions.elementToBeClickable(getMinWorkExpDropdown())).click();

        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[normalize-space()='1-3 years' and not(contains(@style,'display: none'))]")));

        js.executeScript("arguments[0].click();", option);
    }

    /**
     * Enters the minimum salary into the input field.
     * @param salary The minimum salary.
     */
    public void enterMinSalary(String salary) {
        getMinSalaryInput().clear();
        getMinSalaryInput().sendKeys(salary);
    }

    /**
     * Enters the maximum salary into the input field.
     * @param salary The maximum salary.
     */
    public void enterMaxSalary(String salary) {
        getMaxSalaryInput().clear();
        getMaxSalaryInput().sendKeys(salary);
    }

    /**
     * Enters the company name into the input field.
     * @param company The company name.
     */
    public void enterCompanyName(String company) {
        getCompanyNameInput().clear();
        getCompanyNameInput().sendKeys(company);
    }

    /**
     * Enters the first name into the input field.
     * @param firstName The first name.
     */
    public void enterFirstName(String firstName) {
        getFirstNameInput().clear();
        getFirstNameInput().sendKeys(firstName);
    }

    /**
     * Enters the last name into the input field.
     * @param lastName The last name.
     */
    public void enterLastName(String lastName) {
        getLastNameInput().clear();
        getLastNameInput().sendKeys(lastName);
    }

    /**
     * Enters the mobile number into the input field.
     * @param mobile The mobile number.
     */
    public void enterMobile(String mobile) {
        getMobileInput().clear();
        getMobileInput().sendKeys(mobile);
    }

    /**
     * Enters the email into the input field.
     * @param email The email address.
     */
    public void enterEmail(String email) {
        getEmailInput().clear();
        getEmailInput().sendKeys(email);
    }

    /**
     * Enters the company URL into the input field.
     * @param url The company URL.
     */
    public void enterCompanyUrl(String url) {
        getCompanyUrlInput().clear();
        getCompanyUrlInput().sendKeys(url);
    }

    /**
     * Clicks the post job button to submit the form.
     * Uses JavaScript click if regular click fails.
     * @param driver The WebDriver instance.
     */
    public void clickPostJob(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getPostJobButton()));
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
            element.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", getPostJobButton());
        }
    }

    /**
     * Selects the country from the dropdown by typing and pressing enter.
     * @param driver The WebDriver instance.
     * @param country The country name to select.
     */
    public void selectCountry(WebDriver driver, String country) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(getCountryDropdown())).click();
        wait.until(ExpectedConditions.visibilityOf(getCountrySearchBox())).clear();
        getCountrySearchBox().sendKeys(country);
        getCountrySearchBox().sendKeys(Keys.ENTER);
    }
}