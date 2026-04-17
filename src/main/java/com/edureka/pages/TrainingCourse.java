package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TrainingCourse {

@FindBy(tagName = "h1")
private WebElement title;

@FindBy(xpath = "//span[contains(text(),'Learners')]/..//span[@class='title_lltt__I4OeA']")
    WebElement learnersCount;

@FindBy(xpath = "//button[.='Enroll Now']")
private WebElement enrollButton;

@FindBy(xpath = "//img[@alt='Play Edureka course Preview Video']")
    WebElement previewVideoBtn;

@FindBy(name = "first_name")
    WebElement nameField;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "phone")
    WebElement phoneField;
   
    @FindBy(name = "query")
    WebElement queryField;
   
    @FindBy(id = "formCompanyName")
    WebElement companyNameField;
   
    @FindBy(id = "taningForm.ControlSelect1")
    WebElement selectField;

    @FindBy(xpath = "//button[.='Submit']")
    WebElement submitBtn;

@FindBy(xpath = "//button[.='Download Curriculum']")
private WebElement downloadCurruculumButton;

public String getCourseTitle() {
return title.getText();
}

    public void clickEnrollNow() {
        enrollButton.click();
    }

    public void downloadCurriculum() {
        downloadCurruculumButton.click();
    }

    public void playPreviewVideo() {
        previewVideoBtn.click();
    }
   
    public void selectDropDown(String value) {
    Select select = new Select(selectField);
    select.selectByVisibleText(value);
    }

    public void fillQueryForm(String name, String email, String phone, String companyName, String training) {
        nameField.sendKeys(name);
        companyNameField.sendKeys(companyName);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);
        selectDropDown(training);
        submitBtn.click();
    }


}