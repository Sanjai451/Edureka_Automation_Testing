package com.edureka.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model class for the Community Ask Question Page of the Edureka website.
 * This class handles the functionality for filling out and submitting a new question
 * in the community forum, including title, category selection, and tags.
 */
public class CommunityAskQuestion {
	
	@FindBy(id = "title")
	private WebElement titleInput;
	
	@FindBy(id = "category_1")
	private WebElement categoryDowndown;
	
	@FindBy(id = "tags")
	private WebElement tagInput;
	
	@FindBy(xpath = "//button[.='Ask the Question']")
	private WebElement submit;
	
	
	
	/**
	 * Fills out the question details form and submits the question.
	 * Waits for the category dropdown to be clickable, selects the category,
	 * enters the title and tags, then clicks the submit button.
	 * @param driver the WebDriver instance
	 * @param title the title of the question to enter
	 * @param category the category to select from the dropdown
	 * @param tag the tags to enter for the question
	 */
	public void fillQuestionDetails(WebDriver driver, String title, String category, String tag) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(categoryDowndown));
		
		Select select = new Select(categoryDowndown);
		select.selectByVisibleText(category);
		
		titleInput.sendKeys(title);
		tagInput.sendKeys(tag);
		
		submit.click();
		
	}
	
	
}
