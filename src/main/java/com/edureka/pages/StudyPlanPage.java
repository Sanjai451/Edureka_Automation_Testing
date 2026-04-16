package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudyPlanPage {

    // Day dropdown

    @FindBy(xpath = "//label[contains(text(),'Day 1')]/following::ngx-select-dropdown[1]//button")
    private WebElement dayDropdown;

    // From dropdown

    @FindBy(xpath = "//span[contains(text(),'From')]/following::button[contains(@class,'ngx-dropdown-button')][1]")
    private WebElement fromDropdown;

    // To dropdown

    @FindBy(xpath = "//span[contains(text(),'To')]/following::button[contains(@class,'ngx-dropdown-button')][3]")
    private WebElement toDropdown;

    // Common dropdown elements

    @FindBy(xpath = "//div[contains(@class,'search-container')]//input")
    private WebElement searchInput;

    @FindBy(xpath = "//ul[contains(@class,'available-items')]//li")
    private List<WebElement> dropdownOptions;

    // Add day button

    @FindBy(xpath = "//button[contains(text(),'Add another day')]")
    private WebElement addDayButton;

    // Save button

    @FindBy(xpath = "//button[contains(text(),'Save and Continue')]")
    private WebElement saveButton;

    // Getters

    public WebElement getDayDropdown() {
        return dayDropdown;
    }

    public WebElement getFromDropdown() {
        return fromDropdown;
    }

    public WebElement getToDropdown() {
        return toDropdown;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public List<WebElement> getDropdownOptions() {
        return dropdownOptions;
    }

    public WebElement getAddDayButton() {
        return addDayButton;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    // Universal dropdown method (search + click)

    public void selectFromDropdown(WebElement dropdown, String value) {

    	dropdown.click();

        try {
            if (searchInput.isDisplayed()) {
                searchInput.clear();
                searchInput.sendKeys(value);
            }
        } catch (Exception e) {
        }

        for (WebElement option : dropdownOptions) {
            if (option.getText().trim().equalsIgnoreCase(value)) {
                option.click();
                break;
            }
        }
    }

    // Business methods

    public void selectDay(String day) {
        selectFromDropdown(dayDropdown, day);
    }

    public void selectFromTime(String time) {
        selectFromDropdown(fromDropdown, time);
    }

    public void selectToTime(String time) {
        selectFromDropdown(toDropdown, time);
    }

    public void clickAddDay() {
        addDayButton.click();
    }

    public void clickSave() {
        saveButton.click();
    }

    // Combined method

    public void fillStudyPlan(String day, String fromTime, String toTime) {
        selectDay(day);
        selectFromTime(fromTime);
        selectToTime(toTime);
    }
}