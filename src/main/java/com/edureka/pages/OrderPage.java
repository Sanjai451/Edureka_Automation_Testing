package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage {
	 	@FindBy(xpath = "//h4[contains(text(),'not enrolled')]")
	    private WebElement noCoursesMessage;

	    @FindBy(xpath = "//button[contains(text(),'Browse All Courses')]")
	    private WebElement browseCoursesButton;

	    // Getters

	    public WebElement getNoCoursesMessage() {
	        return noCoursesMessage;
	    }

	    public WebElement getBrowseCoursesButton() {
	        return browseCoursesButton;
	    }

	    // Business Logic

	    public String getNoCoursesMessageText() {
	        return noCoursesMessage.getText();
	    }

	    public boolean isNoCoursesMessageDisplayed() {
	        return noCoursesMessage.isDisplayed();
	    }

	    public void clickBrowseCourses() {
	        browseCoursesButton.click();
	    }

//	    public String getCurrentUrl() {
//	        return driver.getCurrentUrl();
//	    }

	    // Validations

	    public boolean verifyNoCoursesMessage() {
	        return isNoCoursesMessageDisplayed() &&
	               getNoCoursesMessageText().contains("not enrolled");
	    }

//	    public boolean verifyRedirectToCoursesPage() {
//	        return getCurrentUrl().contains("all-courses");
//	    }
}
