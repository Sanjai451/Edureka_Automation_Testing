package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterProgram {

    WebDriver driver;

    public MasterProgram(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Download Curriculum']")
    private WebElement downLoadCurriculumButton;

    @FindBy(xpath = "//div[contains(@class,'wishlist')]")
    private WebElement addToWishlistButton;

    @FindBy(xpath = "//div[contains(@class,'share')]")
    private WebElement shareButton;

    @FindBy(id = "formEmail-requestbox")
    private WebElement talkToAdvisorEmailInput;

    @FindBy(id = "formPhoneNumber-requestbox")
    private WebElement talkToAdvisorPhoneInput;

    @FindBy(xpath = "//button[.='Request a Call']")
    private WebElement requestACallButton;

    public void addToWishlist() {
        addToWishlistButton.click();
    }

    public void clickDownloadCurriculum() {
        downLoadCurriculumButton.click();
    }
}