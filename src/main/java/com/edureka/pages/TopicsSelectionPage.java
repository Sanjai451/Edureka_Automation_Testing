package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopicsSelectionPage {

    // Topic options list
    @FindBy(xpath = "//ul[contains(@class,'achieve-list')]//li")
    private List<WebElement> topicOptions;

    // Save and Continue button
    @FindBy(xpath = "//button[contains(text(),'Save and Continue')]")
    private WebElement saveAndContinueButton;

    // Get all topic options
    public List<WebElement> getTopicOptions() {
        return topicOptions;
    }

    // Get save button
    public WebElement getSaveAndContinueButton() {
        return saveAndContinueButton;
    }

    // Select single topic
    public boolean selectTopic(String topicName) {

        for (WebElement topic : topicOptions) {

            if (topic.getText().trim().equalsIgnoreCase(topicName)) {
                topic.click();
                return true;
            }
        }

        return false;
    }

    // Select multiple topics
    public boolean selectMultipleTopics(List<String> topics) {

        boolean allSelected = true;

        for (String topicName : topics) {

            boolean result = selectTopic(topicName);

            if (!result) {
                allSelected = false;
            }
        }

        return allSelected;
    }

    // Click save and continue
    public void clickSaveAndContinue() {
        saveAndContinueButton.click();
    }
}