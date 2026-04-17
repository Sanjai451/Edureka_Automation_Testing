package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunityQuestionAddedPage {
	@FindBy(css = "[class='entry-title']")
	private WebElement titleOfQuestionPosted;
	
	public String getTitleOfQuestion() {
		return titleOfQuestionPosted.getText();
	}
}
