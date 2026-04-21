package com.edureka.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddInstructorPage {

    // Locators

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

    // Getters

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

    // Business logic using getters

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

    public void clickSubmit(WebDriver driver) {
    	 try {
    	        getSubmitButton().click();
    	    } catch (Exception e) {

    	        JavascriptExecutor js = (JavascriptExecutor) driver;

    	        // Scroll slightly DOWN instead of aligning to top
    	        js.executeScript("window.scrollBy(0,300)");

    	        // JS click fallback
    	        js.executeScript("arguments[0].click();", getSubmitButton());
    	    }
    }

    // Complete form flow

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