package com.edureka.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    
    @FindBy(xpath = "//button[.='Enroll Now']")
    WebElement enrollNowButton;
    
    @FindBy(xpath = "//div[contains(@class,'modal')]//input[@name='email']")
    WebElement emailPopUpInput;

    @FindBy(xpath = "//div[contains(@class,'modal')]//input[@name='phone']")
    WebElement phonePopUpInput;

    @FindBy(xpath = "//div[contains(@class,'modal')]//button[.='ENROLL NOW']")
    WebElement enrollNowPopupButton;
    
//    @FindBy(name = "email")
//    WebElement emailPopUpInput;
//    
//    @FindBy(name = "phone")
//    WebElement phonePopUpInput;
//    
//    @FindBy(xpath = "//button[.='ENROLL NOW']")
//    WebElement enrollNowPopupButton;
    
    @FindBy(xpath = "//button[.='GET A SAMPLE CERTIFICATE']")
    WebElement getSampleCertificateButton;
    
    @FindBy(id = "sampleCertificateName")
    WebElement nameForGettingCertificate;
    

    @FindBy(id = "sampleCertificateEmail")
    WebElement emailForGettingCertificate;
    

    @FindBy(id = "sampleCertificatePhone")
    WebElement phoneForGettingCertificate;
    
    @FindBy(xpath = "//button[.='PREVIEW CERTIFICATE']")
    WebElement previewCert;
    
    @FindBy(xpath = "//h4[.='Certificate sent to your inbox']")
    WebElement successMessageforCertPreview;
    

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
   
    public void enrollNow(WebDriver driver, String email, String phone) {
    	enrollButton.click();
    	fillDetailsInPopup(driver, email, phone);
    }
    
    public void fillDetailsInPopup(WebDriver driver, String email, String phone) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement emailField = wait.until(
            ExpectedConditions.visibilityOf(emailPopUpInput)
        );

        WebElement phoneField = wait.until(
            ExpectedConditions.visibilityOf(phonePopUpInput)
        );

        emailField.clear();
        emailField.sendKeys(email);

        phoneField.clear();
        phoneField.sendKeys(phone);

        WebElement enrollBtn = wait.until(
            ExpectedConditions.elementToBeClickable(enrollNowPopupButton)
        );

        enrollBtn.click();
    }
    
    public void selectDropDown(String value) {
    Select select = new Select(selectField);
    select.selectByVisibleText(value);
    }

//    public void fillQueryForm(String name, String email, String phone, String companyName, String training) {
//        nameField.sendKeys(name);
//        companyNameField.sendKeys(companyName);
//        emailField.sendKeys(email);
//        phoneField.sendKeys(phone);
//        selectDropDown(training);
//        submitBtn.click();
//    }
    
    public void fillQueryForm(WebDriver driver, String name, String email, String phone, String companyName, String training) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 🔁 Re-locate elements AFTER scroll (important)
        WebElement nameFieldFresh = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.name("first_name"))
        );

        WebElement companyFieldFresh = driver.findElement(By.id("formCompanyName"));
        WebElement emailFieldFresh = driver.findElement(By.name("email"));
        WebElement phoneFieldFresh = driver.findElement(By.name("phone"));
        WebElement dropdownFresh = driver.findElement(By.id("taningForm.ControlSelect1"));
//        WebElement submitFresh = driver.findElement(By.xpath("//button[.='Submit']"));

        nameFieldFresh.clear();
        nameFieldFresh.sendKeys(name);

        companyFieldFresh.clear();
        companyFieldFresh.sendKeys(companyName);

        emailFieldFresh.clear();
        emailFieldFresh.sendKeys(email);

        phoneFieldFresh.clear();
        phoneFieldFresh.sendKeys(phone);

        Select select = new Select(dropdownFresh);
        select.selectByVisibleText(training);

        JavascriptExecutor js = (JavascriptExecutor) driver;

     // re-locate fresh element (avoid stale)
     WebElement submitFresh = driver.findElement(By.xpath("//button[.='Submit']"));

     // scroll to center (important)
     js.executeScript(
         "arguments[0].scrollIntoView({block:'center'});",
         submitFresh
     );

     // small wait for UI stabilization
     try { Thread.sleep(500); } catch (Exception e) {}

     // JS click (bypass interactability issue)
     js.executeScript("arguments[0].click();", submitFresh);
    }
    
    public void scrollToQueryForm(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block: 'center'});",
            nameField
        );
    }
    
    public void scrollToPreviewCertificate(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            getSampleCertificateButton
        );
    }
    
    public void fillDetailForGettingCert(String name, String email, String phone) {
    	
    	previewCert.click();
    	
    	nameForGettingCertificate.sendKeys(name);
    	emailForGettingCertificate.sendKeys(email);
    	phoneForGettingCertificate.sendKeys(phone);
    	previewCert.click();
    	
    	try {
			Thread.sleep(2000);
		} catch (Exception e) {}
    }

    public void clickPreviewCertificate(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // re-locate to avoid stale
        WebElement sampleCert = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[.='GET A SAMPLE CERTIFICATE']")
            )
        );

//        js.executeScript(
//            "arguments[0].scrollIntoView({block:'center'});",
//            sampleCert
//        );

        // JS click
        js.executeScript("arguments[0].click();", sampleCert);
    }
    public void fillDetailForGettingCert(WebDriver driver, String name, String email, String phone) {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // ✅ WAIT for popup to appear (important fix)
        WebElement nameFresh = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("sampleCertificateName")
            )
        );

        WebElement emailFresh = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("sampleCertificateEmail")
            )
        );

        WebElement phoneFresh = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("sampleCertificatePhone")
            )
        );

        nameFresh.clear();
        nameFresh.sendKeys(name);

        emailFresh.clear();
        emailFresh.sendKeys(email);

        phoneFresh.clear();
        phoneFresh.sendKeys(phone);

        // 🔥 Now click submit inside popup
        WebElement previewSubmit = driver.findElement(
            By.xpath("//button[contains(text(),'PREVIEW CERTIFICATE')]")
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", previewSubmit);
    }
}