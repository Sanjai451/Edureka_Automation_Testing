package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopicsOfInterestPage {

    // Locator for edit button
    @FindBy(xpath = "//span[contains(text(),'Topics of Interest')]/following::button[contains(text(),'EDIT')]")
    private WebElement editButton;

    // Locator for add now button
    @FindBy(xpath = "//button[contains(text(),'Add Now')]")
    private WebElement addNowButton;

    // Locator for topics section
    @FindBy(xpath = "//span[contains(text(),'Topics of Interest')]")
    private WebElement topicsSection;

    // Locator for selected topics list
    @FindBy(xpath = "//ul[contains(@class,'toi-list')]//label")
    private List<WebElement> selectedTopics;

    // Getter methods

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

    // Methods to interact with buttons

    public void clickEditButton() {
        getEditButton().click();
    }

    public void clickAddNow() {
        getAddNowButton().click();
    }

    // Validation methods

    public boolean isTopicsSectionDisplayed() {
        return getTopicsSection().isDisplayed();
    }

    public boolean isAnyTopicSelected() {
        return getSelectedTopics().size() > 0;
    }

    // Verify single topic is selected

    public boolean verifyTopicSelected(String expectedTopic) {

        for (WebElement topic : getSelectedTopics()) {
            if (topic.getText().trim().equalsIgnoreCase(expectedTopic)) {
                return true;
            }
        }
        return false;
    }

    // Verify multiple topics are selected

    public boolean verifyMultipleTopics(List<String> expectedTopics) {

        for (String expected : expectedTopics) {
            boolean found = false;

            for (WebElement topic : getSelectedTopics()) {
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

    // Get all selected topics as a single string

    public String getAllTopicsText() {

        StringBuilder topicsText = new StringBuilder();

        for (WebElement topic : getSelectedTopics()) {
            topicsText.append(topic.getText()).append(", ");
        }

        return topicsText.toString();
    }
}