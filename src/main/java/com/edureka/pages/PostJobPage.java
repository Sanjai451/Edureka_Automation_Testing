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

public class PostJobPage {

    @FindBy(id = "job_title")
    private WebElement jobTitleInput;

    @FindBy(id = "no_vacancy")
    private WebElement vacanciesInput;

    @FindBy(id = "job_description")
    private WebElement jobDescriptionTextArea;

    @FindBy(name = "data[Employer][candidate_profile]")
    private WebElement candidateProfileTextArea;

    @FindBy(xpath = "//span[text()='Min Work Exp.']")
    private WebElement minWorkExpDropdown;

    @FindBy(id = "min_salary")
    private WebElement minSalaryInput;

    @FindBy(id = "max_salary")
    private WebElement maxSalaryInput;

    @FindBy(id = "company_name")
    private WebElement companyNameInput;

    @FindBy(id = "c_p_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "c_p_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "c_p_mobile")
    private WebElement mobileInput;

    @FindBy(name = "data[Employer][c_p_email]")
    private WebElement emailInput;

    @FindBy(name = "data[Employer][company_url]")
    private WebElement companyUrlInput;

    @FindBy(name = "login")
    private WebElement postJobButton;

    @FindBy(xpath = "//div[@id='country_chosen']//span")
    private WebElement countryDropdown;

    @FindBy(xpath = "//div[@id='country_chosen']//input")
    private WebElement countrySearchBox;

    public WebElement getJobTitleInput() {
        return jobTitleInput;
    }

    public WebElement getVacanciesInput() {
        return vacanciesInput;
    }

    public WebElement getJobDescriptionTextArea() {
        return jobDescriptionTextArea;
    }

    public WebElement getCandidateProfileTextArea() {
        return candidateProfileTextArea;
    }

    public WebElement getMinWorkExpDropdown() {
        return minWorkExpDropdown;
    }

    public WebElement getMinSalaryInput() {
        return minSalaryInput;
    }

    public WebElement getMaxSalaryInput() {
        return maxSalaryInput;
    }

    public WebElement getCompanyNameInput() {
        return companyNameInput;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getMobileInput() {
        return mobileInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getCompanyUrlInput() {
        return companyUrlInput;
    }

    public WebElement getPostJobButton() {
        return postJobButton;
    }

    public WebElement getCountryDropdown() {
        return countryDropdown;
    }

    public WebElement getCountrySearchBox() {
        return countrySearchBox;
    }

    public void enterJobTitle(String title) {
        getJobTitleInput().clear();
        getJobTitleInput().sendKeys(title);
    }

    public void enterVacancies(String vacancies) {
        getVacanciesInput().clear();
        getVacanciesInput().sendKeys(vacancies);
    }

    public void enterJobDescription(String desc) {
        getJobDescriptionTextArea().clear();
        getJobDescriptionTextArea().sendKeys(desc);
    }

    public void enterCandidateProfile(String profile) {
        getCandidateProfileTextArea().clear();
        getCandidateProfileTextArea().sendKeys(profile);
    }

    public void selectWorkExperience(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", getMinWorkExpDropdown());
        wait.until(ExpectedConditions.elementToBeClickable(getMinWorkExpDropdown())).click();

        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[normalize-space()='1-3 years' and not(contains(@style,'display: none'))]")));

        js.executeScript("arguments[0].click();", option);
    }

    public void enterMinSalary(String salary) {
        getMinSalaryInput().clear();
        getMinSalaryInput().sendKeys(salary);
    }

    public void enterMaxSalary(String salary) {
        getMaxSalaryInput().clear();
        getMaxSalaryInput().sendKeys(salary);
    }

    public void enterCompanyName(String company) {
        getCompanyNameInput().clear();
        getCompanyNameInput().sendKeys(company);
    }

    public void enterFirstName(String firstName) {
        getFirstNameInput().clear();
        getFirstNameInput().sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        getLastNameInput().clear();
        getLastNameInput().sendKeys(lastName);
    }

    public void enterMobile(String mobile) {
        getMobileInput().clear();
        getMobileInput().sendKeys(mobile);
    }

    public void enterEmail(String email) {
        getEmailInput().clear();
        getEmailInput().sendKeys(email);
    }

    public void enterCompanyUrl(String url) {
        getCompanyUrlInput().clear();
        getCompanyUrlInput().sendKeys(url);
    }

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

    public void selectCountry(WebDriver driver, String country) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(getCountryDropdown())).click();
        wait.until(ExpectedConditions.visibilityOf(getCountrySearchBox())).clear();
        getCountrySearchBox().sendKeys(country);
        getCountrySearchBox().sendKeys(Keys.ENTER);
    }
}