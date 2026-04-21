package com.edureka.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard {

	@FindBy(id = "dropdown-user_drop")
	private WebElement profileIcon;

	@FindBy(linkText = "My Profile")
	private WebElement myProfileLink;

	@FindBy(linkText = "Become an Instructor")
	private WebElement becomeInstructorLink;

	@FindBy(linkText = "Become a Partner")
	private WebElement becomePartnerLink;

	// Getters
	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getMyProfileLink() {
		return myProfileLink;
	}

	public WebElement getBecomeInstructorLink() {
		return becomeInstructorLink;
	}

	public WebElement getBecomePartnerLink() {
		return becomePartnerLink;
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

	 public void clickBecomeInstructor(WebDriver driver) {
		 try {
		        getBecomeInstructorLink().click();
		    } catch (Exception e) {

		        JavascriptExecutor js = (JavascriptExecutor) driver;

		        js.executeScript("window.scrollBy(0,300)");
		        js.executeScript("arguments[0].click();", getBecomeInstructorLink());
		    }
		 
	    }

	public void clickBecomePartner(WebDriver driver) {
		 
		 
		 try {
		        getBecomePartnerLink().click();
		    } catch (Exception e) {

		        JavascriptExecutor js = (JavascriptExecutor) driver;

		        // Scroll a bit to avoid banner blocking
		        js.executeScript("window.scrollBy(0,300)");

		        // JS click fallback
		        js.executeScript("arguments[0].click();", getBecomePartnerLink());
		    }
	}
	
	
	 @FindBy(linkText = "Hire from Edureka")
	    private WebElement hireFromEdurekaLink;

	    // 🔹 Getter
	    public WebElement getHireFromEdurekaLink() {
	        return hireFromEdurekaLink;
	    }

	    // 🔹 Business Logic (your style)
	    public void clickHireFromEdureka(WebDriver driver) {

	        try {
	            // Normal click
	            getHireFromEdurekaLink().click();

	        } catch (Exception e) {

	            JavascriptExecutor js = (JavascriptExecutor) driver;

	            // Scroll DOWN slightly
	            js.executeScript("window.scrollBy(0,300)");

	            // Optional: bring element to center (more stable)
	            js.executeScript(
	                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
	                getHireFromEdurekaLink()
	            );

	            // JS click fallback
	            js.executeScript("arguments[0].click();", getHireFromEdurekaLink());
	        }
}
}