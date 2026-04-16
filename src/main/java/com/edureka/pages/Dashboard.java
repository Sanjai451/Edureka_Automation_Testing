package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard {

	@FindBy(id = "dropdown-user_drop")
	private WebElement profileIcon;

	@FindBy(linkText = "My Profile")
	private WebElement myProfileLink;

	// Getters
	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getMyProfileLink() {
		return myProfileLink;
	}

	// Business Logic Methods

	// Click on profile icon
	public void clickProfileIcon() {
		getProfileIcon().click();
	}

	// Click on My Profile
	public void clickMyProfile() {
		getMyProfileLink().click();
	}

	// Combined action
	public void navigateToMyProfile() {
		getProfileIcon().click();
		getMyProfileLink().click();
	}
}