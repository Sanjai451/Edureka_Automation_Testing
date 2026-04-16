package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LearningGoalsPage {

	@FindBy(xpath = "//ul[contains(@class,'achieve-list')]//li")
	private List<WebElement> learningGoalOptions;

	@FindBy(xpath = "//button[contains(text(),'Save and Continue')]")
	private WebElement saveAndContinueButton;

	// Getters
	public WebElement getSaveAndContinueButton() {
		return saveAndContinueButton;
	}

	public List<WebElement> getLearningGoalOptions() {
		return learningGoalOptions;
	}

	// Business Logic Methods

	public void selectLearningGoal(String goalName) {
		for (WebElement option : getLearningGoalOptions()) {   
			if (option.getText().trim().equalsIgnoreCase(goalName)) {
				option.click();
				break;
			}
		}
	}

	public void clickSaveAndContinue() {
		getSaveAndContinueButton().click();  
	}
}