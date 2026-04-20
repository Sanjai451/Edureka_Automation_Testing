package com.edureka.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class SignUpPage {
	
	Base base;
	public SignUpPage(Base base){
		this.base = base;
	}

    @FindBy(xpath = "//button[.='Sign up']")
    WebElement signupLink;

    @FindBy(id = "signupFormEmail")
    WebElement email;

    @FindBy(id = "signupFormPhone")
    WebElement number;

    @FindBy(xpath = "//button[contains(text(),'SIGN')]")
    WebElement signupBtn;

    @FindBy(css = "[placeholder='Create Password']")
    WebElement createPassword;

    @FindBy(xpath = "//button[contains(text(),'Start')]")
    WebElement startLearningBtn;

    public void openSignupPage() {

     

        JavascriptExecutor js = (JavascriptExecutor) base.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true);", signupLink);
        js.executeScript("arguments[0].click();", signupLink);
    }

    public void enterEmail(String e) {
        email.sendKeys(e);
    }

    public void enterNumber(String p) {
        number.sendKeys(p);
    }

    public void clickSignup() {
        signupBtn.click();
    }

    public void enterCreatePassword(String pwd) {
        createPassword.sendKeys(pwd);
    }

    public void clickStartLearning() {
        startLearningBtn.click();
    }
}