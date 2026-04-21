package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

    @FindBy(xpath = "//button[.='Log in']")
    WebElement loginLink;

    @FindBy(xpath = "//form//input[@id='loginFormEmail']")
    WebElement email;

    @FindBy(xpath = "//form//input[@id='loginPassword']")
    WebElement password;

    @FindBy(xpath = "//button[.='LOG IN']")
    WebElement loginBtn;
    
    @FindBy(linkText = "Forgot?")
    WebElement showIcon;

    public void clickShowIcon() {
        showIcon.click();
    }

    public String getPasswordFieldType() {
        return password.getAttribute("type");
    }

    public void openLoginPopup() {
        loginLink.click();
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() {
        loginBtn.click();
    }
}