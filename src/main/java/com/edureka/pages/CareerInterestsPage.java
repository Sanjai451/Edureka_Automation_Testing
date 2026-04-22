package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CareerInterestsPage {

    // Locator for career interests tab
    @FindBy(xpath = "//a[@aria-controls='careerInterests']")
    private WebElement careerInterestsTab;

    // Locator for job interested dropdown
    @FindBy(name = "interestedJob")
    private WebElement jobInterestedDropdown;

    // Locator for employment type dropdown
    @FindBy(name = "elementType")
    private WebElement employmentTypeDropdown;

    // Locator for current location input field
    @FindBy(name = "currentCity")
    private WebElement currentLocationInput;

    // Locator for CTC dropdown
    @FindBy(name = "lastDrawnSalary")
    private WebElement ctcDropdown;

    // Locator for relocate yes radio button
    @FindBy(xpath = "//input[@value='true']")
    private WebElement relocateYesRadio;

    // Locator for relocate no radio button
    @FindBy(xpath = "//input[@value='false']")
    private WebElement relocateNoRadio;

    // Locator for preferred location input field
    @FindBy(name = "preferredCity")
    private WebElement preferredLocationInput;

    // Locator for next button
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Next')]")
    private WebElement nextButton;

    // Getter methods for all elements

    public WebElement getCareerInterestsTab() {
        return careerInterestsTab;
    }

    public WebElement getJobInterestedDropdown() {
        return jobInterestedDropdown;
    }

    public WebElement getEmploymentTypeDropdown() {
        return employmentTypeDropdown;
    }

    public WebElement getCurrentLocationInput() {
        return currentLocationInput;
    }

    public WebElement getCtcDropdown() {
        return ctcDropdown;
    }

    public WebElement getRelocateYesRadio() {
        return relocateYesRadio;
    }

    public WebElement getRelocateNoRadio() {
        return relocateNoRadio;
    }

    public WebElement getPreferredLocationInput() {
        return preferredLocationInput;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    // Click on career interests tab

    public void clickCareerInterestsTab() {
        getCareerInterestsTab().click();
    }

    // Select job interested from dropdown

    public void selectJobInterested(String value) {
        new Select(getJobInterestedDropdown()).selectByVisibleText(value);
    }

    // Select employment type from dropdown

    public void selectEmploymentType(String value) {
        new Select(getEmploymentTypeDropdown()).selectByVisibleText(value);
    }

    // Enter current location

    public void enterCurrentLocation(String location) {
        getCurrentLocationInput().clear();
        getCurrentLocationInput().sendKeys(location);
    }

    // Select CTC value from dropdown

    public void selectCTC(String value) {
        new Select(getCtcDropdown()).selectByVisibleText(value);
    }

    // Select relocate yes option

    public void selectRelocateYes() {
        getRelocateYesRadio().click();
    }

    // Select relocate no option

    public void selectRelocateNo() {
        getRelocateNoRadio().click();
    }

    // Enter preferred location

    public void enterPreferredLocation(String location) {
        getPreferredLocationInput().clear();
        getPreferredLocationInput().sendKeys(location);
    }

    // Click next button if enabled

    public void clickNextButton() {
        if (getNextButton().isEnabled()) {
            getNextButton().click();
        } else {
            System.out.println("Next button is disabled");
        }
    }

    // Complete flow to fill career interests form

    public void fillCareerInterests(String job, String employment, String currentLocation,
                                    String ctc, boolean relocate, String preferredLocation) {

        clickCareerInterestsTab();
        selectJobInterested(job);
        selectEmploymentType(employment);
        enterCurrentLocation(currentLocation);
        selectCTC(ctc);

        // Choose relocate option based on boolean value
        if (relocate) {
            selectRelocateYes();
        } else {
            selectRelocateNo();
        }

        enterPreferredLocation(preferredLocation);
        clickNextButton(); 
    }
}