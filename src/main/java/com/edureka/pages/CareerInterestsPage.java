package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CareerInterestsPage {


    @FindBy(xpath = "//a[@aria-controls='careerInterests']")
    private WebElement careerInterestsTab;

    @FindBy(name = "interestedJob")
    private WebElement jobInterestedDropdown;

    @FindBy(name = "elementType")
    private WebElement employmentTypeDropdown;

    @FindBy(name = "currentCity")
    private WebElement currentLocationInput;

    @FindBy(name = "lastDrawnSalary")
    private WebElement ctcDropdown;

    @FindBy(xpath = "//input[@value='true']")
    private WebElement relocateYesRadio;

    @FindBy(xpath = "//input[@value='false']")
    private WebElement relocateNoRadio;

    @FindBy(name = "preferredCity")
    private WebElement preferredLocationInput;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Next')]")
    private WebElement nextButton;


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


    public void clickCareerInterestsTab() {
        getCareerInterestsTab().click();
    }

    public void selectJobInterested(String value) {
        new Select(getJobInterestedDropdown()).selectByVisibleText(value);
    }

    public void selectEmploymentType(String value) {
        new Select(getEmploymentTypeDropdown()).selectByVisibleText(value);
    }

    public void enterCurrentLocation(String location) {
        getCurrentLocationInput().clear();
        getCurrentLocationInput().sendKeys(location);
    }

    public void selectCTC(String value) {
        new Select(getCtcDropdown()).selectByVisibleText(value);
    }

    public void selectRelocateYes() {
        getRelocateYesRadio().click();
    }

    public void selectRelocateNo() {
        getRelocateNoRadio().click();
    }

    public void enterPreferredLocation(String location) {
        getPreferredLocationInput().clear();
        getPreferredLocationInput().sendKeys(location);
    }

    public void clickNextButton() {
        if (getNextButton().isEnabled()) {
            getNextButton().click();
        } else {
            System.out.println("Next button is disabled");
        }
    }


    public void fillCareerInterests(String job, String employment, String currentLocation,
                                    String ctc, boolean relocate, String preferredLocation) {

        clickCareerInterestsTab();
        selectJobInterested(job);
        selectEmploymentType(employment);
        enterCurrentLocation(currentLocation);
        selectCTC(ctc);

        if (relocate) {
            selectRelocateYes();
        } else {
            selectRelocateNo();
        }

        enterPreferredLocation(preferredLocation);
        clickNextButton(); 
    }
}