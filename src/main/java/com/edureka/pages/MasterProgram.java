package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MasterProgram {

@FindBy(xpath = "//button[.='Download Curriculum']")
private WebElement downLoadCurriculumButton;

@FindBy(xpath = "//div[@class='topbanner_wishlist__3disw null']")
private WebElement addToWishlistButton;

@FindBy(xpath = "//div[@class='topbanner_share__1G3OJ']")
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
