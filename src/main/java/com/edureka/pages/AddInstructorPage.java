package com.edureka.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddInstructorPage {

    // Locators for instructor form fields

    @FindBy(id = "instructor_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "instructor_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "instructor_mobile")
    private WebElement mobileInput;

    @FindBy(name = "data[Instructor][email]")
    private WebElement emailInput;

    @FindBy(id = "instructor_coursename")
    private WebElement courseNameInput;

    @FindBy(name = "data[Instructor][linked_in]")
    private WebElement linkedInInput;

    @FindBy(id = "instructor_about")
    private WebElement aboutCourseTextArea;

    @FindBy(id = "instructor_details")
    private WebElement aboutYourselfTextArea;

    @FindBy(xpath = "//input[@type='submit' and @value='SUBMIT']")
    private WebElement submitButton;

    // Getters to access web elements

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

    public WebElement getCourseNameInput() {
        return courseNameInput;
    }

    public WebElement getLinkedInInput() {
        return linkedInInput;
    }

    public WebElement getAboutCourseTextArea() {
        return aboutCourseTextArea;
    }

    public WebElement getAboutYourselfTextArea() {
        return aboutYourselfTextArea;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    // Methods to enter data into each field

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

    public void enterCourseName(String course) {
        getCourseNameInput().clear();
        getCourseNameInput().sendKeys(course);
    }

    public void enterLinkedIn(String linkedIn) {
        getLinkedInInput().clear();
        getLinkedInInput().sendKeys(linkedIn);
    }

    public void enterAboutCourse(String aboutCourse) {
        getAboutCourseTextArea().clear();
        getAboutCourseTextArea().sendKeys(aboutCourse);
    }

    public void enterAboutYourself(String aboutYourself) {
        getAboutYourselfTextArea().clear();
        getAboutYourselfTextArea().sendKeys(aboutYourself);
    }

    // Method to click submit button with fallback using javascript

    public void clickSubmit(WebDriver driver) {
        try {
            getSubmitButton().click();
        } catch (Exception e) {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll down to make button visible
            js.executeScript("window.scrollBy(0,300)");

            // Click using javascript if normal click fails
            js.executeScript("arguments[0].click();", getSubmitButton());
        }
    }

    // Method to fill entire instructor form

    public void fillInstructorForm(String firstName, String lastName, String mobile,
                                   String email, String course, String linkedIn,
                                   String aboutCourse, String aboutYourself) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterMobile(mobile);
        enterEmail(email);
        enterCourseName(course);
        enterLinkedIn(linkedIn);
        enterAboutCourse(aboutCourse);
        enterAboutYourself(aboutYourself);
    }
}