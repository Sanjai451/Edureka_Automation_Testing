package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//button[.='Log in']")
    WebElement loginLink;

    @FindBy(xpath = "//form//input[@id='loginFormEmail']")
    WebElement email;

    @FindBy(xpath = "//form//input[@id='loginPassword']")
    WebElement password;

    @FindBy(xpath = "//button[.='LOG IN']")
    WebElement loginBtn;

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