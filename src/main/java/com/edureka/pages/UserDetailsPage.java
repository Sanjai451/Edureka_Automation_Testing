package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserDetailsPage {

	// Locator for full name input field
	@FindBy(id = "fullName")
	private WebElement fullNameInput;

	// Locator for designation input field
	@FindBy(id = "designation")
	private WebElement designationInput;

	// Dropdown elements for industry and experience

	@FindBy(xpath = "(//button[contains(@class,'ngx-dropdown-button')])[2]")
	private WebElement industryDropdown;

	@FindBy(xpath = "(//button[contains(@class,'ngx-dropdown-button')])[1]")
	private WebElement experienceDropdown;

	// Dropdown elements for timezone selection

	@FindBy(xpath = "//label[contains(text(),'Select Current TimeZone')]/following::button[1]")
	private WebElement currentTimezoneDropdown;

	@FindBy(xpath = "//label[text()='Select TimeZone']/following::button[1]")
	private WebElement preferredTimezoneDropdown;

	// Dropdown elements for weekdays time selection

	@FindBy(xpath = "//label[contains(text(),'Weekdays')]/following::div[contains(@class,'input-group timepicker')][1]//button")
	private WebElement weekdaysFromDropdown;

	@FindBy(xpath = "//label[contains(text(),'Weekdays')]/following::div[contains(@class,'input-group timepicker')][2]//button")
	private WebElement weekdaysToDropdown;

	// Dropdown elements for weekends time selection

	@FindBy(xpath = "//label[contains(text(),'Weekends')]/following::div[contains(@class,'input-group timepicker')][1]//button")
	private WebElement weekendsFromDropdown;

	@FindBy(xpath = "//label[contains(text(),'Weekends')]/following::div[contains(@class,'input-group timepicker')][2]//button")
	private WebElement weekendsToDropdown;

	// Common elements for dropdown handling

	@FindBy(xpath = "//div[contains(@class,'search-container')]//input")
	private WebElement dropdownSearchInput;

	@FindBy(xpath = "//ul[contains(@class,'available-items')]//li")
	private List<WebElement> dropdownOptions;

	// Locator for save and continue button

	@FindBy(xpath = "//button[contains(text(),'Save and Continue')]")
	private WebElement saveAndContinueButton;

	// Getter methods

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

	// Method to select value from dropdown

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

	// Methods to enter text values

	public void enterFullName(String name) {
		getFullNameInput().clear();
		getFullNameInput().sendKeys(name);
	}

	public void enterDesignation(String designation) {
		getDesignationInput().clear();
		getDesignationInput().sendKeys(designation);
	}

	// Method to click save and continue

	public void clickSaveAndContinue() {
		getSaveAndContinueButton().click();
	}
}