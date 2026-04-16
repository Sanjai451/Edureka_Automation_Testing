package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserDetailsPage {

	@FindBy(id = "fullName")
	private WebElement fullNameInput;

	@FindBy(id = "designation")
	private WebElement designationInput;

	// Dropdown Elements
	@FindBy(xpath = "//span[contains(text(),'IT-Hardware')]/ancestor::button")
	private WebElement industryDropdown;

	@FindBy(xpath = "//span[contains(text(),'0-2 years')]/ancestor::button")
	private WebElement experienceDropdown;

	@FindBy(xpath = "//label[contains(text(),'Select Current TimeZone')]/following::button[1]")
	private WebElement currentTimezoneDropdown;

	@FindBy(xpath = "//label[text()='Select TimeZone']/following::button[1]")
	private WebElement preferredTimezoneDropdown;

	@FindBy(xpath = "//label[contains(text(),'Weekdays')]/following::div[contains(@class,'input-group timepicker')][1]//button")
	private WebElement weekdaysFromDropdown;

	@FindBy(xpath = "//label[contains(text(),'Weekdays')]/following::div[contains(@class,'input-group timepicker')][2]//button")
	private WebElement weekdaysToDropdown;

	@FindBy(xpath = "//label[contains(text(),'Weekends')]/following::div[contains(@class,'input-group timepicker')][1]//button")
	private WebElement weekendsFromDropdown;

	@FindBy(xpath = "//label[contains(text(),'Weekends')]/following::div[contains(@class,'input-group timepicker')][2]//button")
	private WebElement weekendsToDropdown;

	// Common elements
	@FindBy(xpath = "//div[contains(@class,'search-container')]//input")
	private WebElement dropdownSearchInput;

	@FindBy(xpath = "//ul[contains(@class,'available-items')]//li")
	private List<WebElement> dropdownOptions;

	@FindBy(xpath = "//button[contains(text(),'Save and Continue')]")
	private WebElement saveAndContinueButton;

	// Getters
	public WebElement getFullNameInput() {
		return fullNameInput;
	}

	public WebElement getDesignationInput() {
		return designationInput;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getExperienceDropdown() {
		return experienceDropdown;
	}

	public WebElement getCurrentTimezoneDropdown() {
		return currentTimezoneDropdown;
	}

	public WebElement getPreferredTimezoneDropdown() {
		return preferredTimezoneDropdown;
	}

	public WebElement getWeekdaysFromDropdown() {
		return weekdaysFromDropdown;
	}

	public WebElement getWeekdaysToDropdown() {
		return weekdaysToDropdown;
	}

	public WebElement getWeekendsFromDropdown() {
		return weekendsFromDropdown;
	}

	public WebElement getWeekendsToDropdown() {
		return weekendsToDropdown;
	}

	public WebElement getDropdownSearchInput() {
		return dropdownSearchInput;
	}

	public List<WebElement> getDropdownOptions() {
		return dropdownOptions;
	}

	public WebElement getSaveAndContinueButton() {
		return saveAndContinueButton;
	}

	// Business Logic Methods

	public void selectFromDropdown(WebElement dropdown, String value) {
		dropdown.click();

		try {
			if (getDropdownSearchInput().isDisplayed()) {
				getDropdownSearchInput().clear();
				getDropdownSearchInput().sendKeys(value);
			}
		} catch (Exception e) {
			// search not available
		}

		for (WebElement option : getDropdownOptions()) {
			if (option.getText().trim().equalsIgnoreCase(value)) {
				option.click();
				break;
			}
		}
	}

	// Text field input
	public void enterFullName(String name) {
		getFullNameInput().clear();
		getFullNameInput().sendKeys(name);
	}

	public void enterDesignation(String designation) {
		getDesignationInput().clear();
		getDesignationInput().sendKeys(designation);
	}

	public void clickSaveAndContinue() {
		getSaveAndContinueButton().click();
	}
}