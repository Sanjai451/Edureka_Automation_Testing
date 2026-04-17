package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OtherDetailsPage {

    // ================= ADD BUTTONS =================

    @FindBy(xpath = "//span[contains(text(),'Add Another Degree')]/ancestor::button")
    private WebElement addDegreeBtn;

    @FindBy(xpath = "//span[contains(text(),'Add Another Certification')]/ancestor::button")
    private WebElement addCertificationBtn;


    // ================= DEGREE FIELDS =================

    @FindBy(id = "degree-name")
    private WebElement degreeInput;

    @FindBy(id = "company-name")
    private WebElement instituteInput;


    // ================= TIME PERIOD =================

    // Month dropdown
    @FindBy(xpath = "//select[@formcontrolname='start_month']")
    private WebElement startMonthDropdown;

    // Year dropdown
    @FindBy(xpath = "//select[@formcontrolname='start_year']")
    private WebElement startYearDropdown;


    // ================= SAVE BUTTON =================

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Save')]")
    private WebElement saveButton;


    // ================= GETTERS =================

    public WebElement getAddDegreeBtn() {
        return addDegreeBtn;
    }

    public WebElement getAddCertificationBtn() {
        return addCertificationBtn;
    }

    public WebElement getDegreeInput() {
        return degreeInput;
    }

    public WebElement getInstituteInput() {
        return instituteInput;
    }

    public WebElement getStartMonthDropdown() {
        return startMonthDropdown;
    }

    public WebElement getStartYearDropdown() {
        return startYearDropdown;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }


    // ================= ACTION METHODS =================

    public void clickAddDegree() {
        addDegreeBtn.click();
    }

    public void clickAddCertification() {
        addCertificationBtn.click();
    }

    public void enterDegree(String degree) {
        degreeInput.clear();
        degreeInput.sendKeys(degree);
    }

    public void enterInstitute(String institute) {
        instituteInput.clear();
        instituteInput.sendKeys(institute);
    }

    public void selectStartMonth(String month) {
        startMonthDropdown.sendKeys(month); // or use Select class
    }

    public void selectStartYear(String year) {
        startYearDropdown.sendKeys(year);
    }

    public void clickSave() {
        saveButton.click();
    }


    // ================= COMBINED METHOD =================

    public void fillOtherDetails(String degree, String institute, String month, String year) {

        clickAddDegree();

        enterDegree(degree);
        enterInstitute(institute);

        selectStartMonth(month);
        selectStartYear(year);
    }
}