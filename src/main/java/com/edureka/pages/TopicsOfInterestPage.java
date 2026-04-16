package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopicsOfInterestPage {

    //  BUTTONS 

    // Edit Button
    @FindBy(xpath = "//span[contains(text(),'Topics of Interest')]/following::button[contains(text(),'EDIT')]")
    private WebElement editButton;

    // Add Now Button
    @FindBy(xpath = "//button[contains(text(),'Add Now')]")
    private WebElement addNowButton;

    // SECTION 

    @FindBy(xpath = "//span[contains(text(),'Topics of Interest')]")
    private WebElement topicsSection;

    //  SELECTED TOPICS

    // All selected topics
    @FindBy(xpath = "//ul[contains(@class,'toi-list')]//label")
    private List<WebElement> selectedTopics;

    //  GETTERS 

    public WebElement getEditButton() {
        return editButton;
    }

    public WebElement getAddNowButton() {
        return addNowButton;
    }

    public WebElement getTopicsSection() {
        return topicsSection;
    }

    public List<WebElement> getSelectedTopics() {
        return selectedTopics;
    }

    //  BUSINESS METHODS 

    public void clickEditButton() {
        editButton.click();
    }

    public void clickAddNow() {
        addNowButton.click();
    }

    //  VALIDATION METHODS

    //  Verify section displayed
    public boolean isTopicsSectionDisplayed() {
        return topicsSection.isDisplayed();
    }

    //  Verify at least one topic selected
    public boolean isAnyTopicSelected() {
        return selectedTopics.size() > 0;
    }

    // Verify single topic
    public boolean verifyTopicSelected(String expectedTopic) {

        for (WebElement topic : selectedTopics) {
            if (topic.getText().trim().equalsIgnoreCase(expectedTopic)) {
                return true;
            }
        }
        return false;
    }

    // Verify multiple topics
    public boolean verifyMultipleTopics(List<String> expectedTopics) {

        for (String expected : expectedTopics) {
            boolean found = false;

            for (WebElement topic : selectedTopics) {
                if (topic.getText().trim().equalsIgnoreCase(expected)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }
        return true;
    }

    // Get all topics text 
    public String getAllTopicsText() {

        StringBuilder topicsText = new StringBuilder();

        for (WebElement topic : selectedTopics) {
            topicsText.append(topic.getText()).append(", ");
        }

        return topicsText.toString();
    }
}