package com.edureka.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wishlist {
	WebDriverWait wait;
	
	public Wishlist(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(id = "dropdown-user_drop")
	private WebElement profileDropDown;
	
	@FindBy(xpath = "//a[.='My Wishlist']")
	private WebElement wishList;
	
	@FindBy(xpath = "//span[contains(., 'not match any courses')]")
	private WebElement notFound;
	
	public void clickProfileDropDown() {
		profileDropDown.click();
	}
	
	public void clickWishList() {
		wishList.click();
	}
	
	public String getMessage() {
		wait.until(ExpectedConditions.visibilityOf(notFound));
		return notFound.getText();
	}

}
