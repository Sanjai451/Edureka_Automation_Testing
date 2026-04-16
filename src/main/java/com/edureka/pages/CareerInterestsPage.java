package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CareerInterestsPage {

	// Locators

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

	// Getters

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

	// Business methods

	public void clickCareerInterestsTab() {
		careerInterestsTab.click();
	}

	public void selectJobInterested(String value) {
		Select select = new Select(jobInterestedDropdown);
		select.selectByVisibleText(value);
	}

	public void selectEmploymentType(String value) {
		Select select = new Select(employmentTypeDropdown);
		select.selectByVisibleText(value);
	}

	public void enterCurrentLocation(String location) {
		currentLocationInput.clear();
		currentLocationInput.sendKeys(location);
	}

	public void selectCTC(String value) {
		Select select = new Select(ctcDropdown);
		select.selectByVisibleText(value);
	}

	public void selectRelocateYes() {
		relocateYesRadio.click();
	}

	public void selectRelocateNo() {
		relocateNoRadio.click();
	}

	public void enterPreferredLocation(String location) {
		preferredLocationInput.clear();
		preferredLocationInput.sendKeys(location);
	}

	public void clickNextButton() {
		if (nextButton.isEnabled()) {
			nextButton.click();
		} else {
			System.out.println("Next button is disabled");
		}
	}

	public void fillCareerInterests(String job, String employment, String currentLocation, String ctc, boolean relocate,
			String preferredLocation) {

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
	}
}