package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OtherDetailsPage {

    // Add buttons for degree and certification

    @FindBy(xpath = "//span[text()='Add Another Degree']/ancestor::button")
    private WebElement addDegreeBtn;

    @FindBy(xpath = "//span[text()='Add Another Certification']/ancestor::button")
    private WebElement addCertificationBtn;

    // Degree input fields

    @FindBy(id = "degree-name")
    private WebElement degreeInput;

    @FindBy(id = "company-name")
    private WebElement instituteInput;

    // Degree start and end time fields

    @FindBy(name = "start_month")
    private WebElement startMonth;

    @FindBy(xpath = "(//select[@formcontrolname='start_year'])[1]")
    private WebElement startYear;

    @FindBy(xpath= "(//select[@formcontrolname='end_month'])[1]")
    private WebElement endMonth;

    @FindBy(xpath= "(//select[@formcontrolname='end_year'])[1]")
    private WebElement endYear;

    // Highest qualification radio button

    @FindBy(xpath = "//label[contains(text(),'highest educational qualification')]/preceding::input[1]")
    private WebElement highestQualificationRadio;

    // Certification input fields

    @FindBy(id = "certificate-name")
    private WebElement certificationName;

    @FindBy(id = "institute-name")
    private WebElement certificationInstitute;

    @FindBy(xpath = "(//select[@formcontrolname='start_month'])[2]")
    private WebElement certStartMonth;

    @FindBy(xpath = "(//select[@formcontrolname='start_year'])[2]")
    private WebElement certStartYear;

    @FindBy(xpath = "(//select[@formcontrolname='end_month'])[2]")
    private WebElement certEndMonth;

    @FindBy(xpath = "(//select[@formcontrolname='end_year'])[2]")
    private WebElement certEndYear;

    // Save button

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Save')]")
    private WebElement saveButton;
    
    
    // Getter methods

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

    public WebElement getStartMonth() {
        return startMonth;
    }

    public WebElement getStartYear() {
        return startYear;
    }

    public WebElement getEndMonth() {
        return endMonth;
    }

    public WebElement getEndYear() {
        return endYear;
    }

    public WebElement getHighestQualificationRadio() {
        return highestQualificationRadio;
    }

    public WebElement getCertificationName() {
        return certificationName;
    }

    public WebElement getCertificationInstitute() {
        return certificationInstitute;
    }

    public WebElement getCertStartMonth() {
        return certStartMonth;
    }

    public WebElement getCertStartYear() {
        return certStartYear;
    }

    public WebElement getCertEndMonth() {
        return certEndMonth;
    }

    public WebElement getCertEndYear() {
        return certEndYear;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    // Method to fill degree details

    public void fillDegree(String degree, String institute,
                           String smonth, String syear,
                           String emonth, String eyear) {

        addDegreeBtn.click();

        degreeInput.clear();
        degreeInput.sendKeys(degree);

        instituteInput.clear();
        instituteInput.sendKeys(institute);

        new Select(startMonth).selectByVisibleText(smonth);
        new Select(startYear).selectByVisibleText(syear);
        new Select(endMonth).selectByVisibleText(emonth);
        new Select(endYear).selectByVisibleText(eyear);

        highestQualificationRadio.click();
    }

    // Method to fill certification details

    public void fillCertification(String name, String institute,
                                  String smonth, String syear,
                                  String emonth, String eyear) {

        addCertificationBtn.click();

        certificationName.clear();
        certificationName.sendKeys(name);

        certificationInstitute.clear();
        certificationInstitute.sendKeys(institute);

        new Select(certStartMonth).selectByVisibleText(smonth);
        new Select(certStartYear).selectByVisibleText(syear);
        new Select(certEndMonth).selectByVisibleText(emonth);
        new Select(certEndYear).selectByVisibleText(eyear);
    }

    // Method to click save button

    public void clickSave() {
        saveButton.click();
    }
}