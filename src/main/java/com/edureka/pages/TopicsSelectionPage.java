package com.edureka.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopicsSelectionPage {

	// Topic Options
	@FindBy(xpath = "//ul[contains(@class,'achieve-list')]//li")
	private List<WebElement> topicOptions;
	@FindBy(xpath = "//button[contains(text(),'Save and Continue')]")
	private WebElement saveAndContinueButton;

	// Getters

	public List<WebElement> getTopicOptions() {
		return topicOptions;
	}

	public WebElement getSaveAndContinueButton() {
		return saveAndContinueButton;
	}

	// Business Logic
	// Select topic dynamically
	public void selectTopic(String topicName) {
		for (WebElement topic : topicOptions) {
			if (topic.getText().trim().equalsIgnoreCase(topicName)) {
				topic.click();
				break;
			}
		}
	}

	// Select multiple topics
	public void selectMultipleTopics(List<String> topics) {
		for (String topicName : topics) {
			selectTopic(topicName);
		}
	}

	// Save
	public void clickSaveAndContinue() {
		saveAndContinueButton.click();
	}
}