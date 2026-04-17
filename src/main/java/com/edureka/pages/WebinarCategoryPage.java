package com.edureka.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebinarCategoryPage {
	
    private WebDriver driver;
    private WebDriverWait wait;
    
    public WebinarCategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//a[.='Join Now']")
    private WebElement joinNowButton;
    
    @FindBy(xpath = "//label[@for='email']/following-sibling::input")
    private WebElement emailInputField;
    
    @FindBy(name = "Experience")
    private WebElement selectDropdown;
    
    @FindBy(name = "phone_no")
    private WebElement phoneNumber;
    
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;
    
    @FindBy(xpath = "//div[@class='top_title']//h1")
    private WebElement titlePage;
    
    public void fillDetailAndSubmit(String email, String phone, String experience) {
    	Select sel = new Select(selectDropdown);
    	sel.selectByContainsVisibleText(experience);
    	emailInputField.sendKeys(email);
    	phoneNumber.sendKeys(phone);
    	submitButton.click();
    }
    
    public String getTitle() {
    	return titlePage.getText();
    }
    
}
