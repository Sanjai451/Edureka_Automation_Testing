package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CommunityAskQuestion {
	
	@FindBy(id = "title")
	private WebElement titleInput;
	
	@FindBy(id = "category_1")
	private WebElement categoryDowndown;
	
	@FindBy(id = "tags")
	private WebElement tagInput;
	
	@FindBy(xpath = "//button[.='Ask the Question']")
	private WebElement submit;
	
	
	
	public void fillQuestionDetails(String title, String category, String tag) {
		Select select = new Select(categoryDowndown);
		select.selectByVisibleText(category);
		
		titleInput.sendKeys(title);
		tagInput.sendKeys(tag);
		
		submit.click();
		
	}
	
	
}
