package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Page Object Model class for the Community Question Added Page
public class CommunityQuestionAddedPage {
	@FindBy(css = "[class='entry-title']")
	private WebElement titleOfQuestionPosted;
	
	// Gets the title of the posted question
	public String getTitleOfQuestion() {
		return titleOfQuestionPosted.getText();
	}
}
