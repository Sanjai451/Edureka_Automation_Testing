package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyOrdersAndInvoicesPage {

	// Locators for no courses message and browse courses button

	@FindBy(xpath = "//h4[contains(text(),'not enrolled')]")
	private WebElement noCoursesMessage;

	@FindBy(xpath = "//button[contains(text(),'Browse All Courses')]")
	private WebElement browseCoursesButton;

	// Getter methods for elements

	public WebElement getNoCoursesMessage() {
		return noCoursesMessage;
	}

	public WebElement getBrowseCoursesButton() {
		return browseCoursesButton;
	}

	// Methods to fetch and check message

	public String getNoCoursesMessageText() {
		return noCoursesMessage.getText();
	}

	public boolean isNoCoursesMessageDisplayed() {
		return noCoursesMessage.isDisplayed();
	}

	// Method to click browse courses button

	public void clickBrowseCourses() {
		browseCoursesButton.click();
	}

//    Method to get current page URL
//    public String getCurrentUrl() {
//        return driver.getCurrentUrl();
//    }

	// Validation method to verify no courses message

	public boolean verifyNoCoursesMessage() {
		return isNoCoursesMessageDisplayed() && getNoCoursesMessageText().contains("not enrolled");
	}

//    Method to verify redirection to courses page
//    public boolean verifyRedirectToCoursesPage() {
//        return getCurrentUrl().contains("all-courses");
//    }
}