package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopicsOfInterestPage {

    // Buttons

    @FindBy(xpath = "//span[contains(text(),'Topics of Interest')]/following::button[contains(text(),'EDIT')]")
    private WebElement editButton;

    @FindBy(xpath = "//button[contains(text(),'Add Now')]")
    private WebElement addNowButton;

    // Section

    @FindBy(xpath = "//span[contains(text(),'Topics of Interest')]")
    private WebElement topicsSection;

    // Selected topics

    @FindBy(xpath = "//ul[contains(@class,'toi-list')]//label")
    private List<WebElement> selectedTopics;

    // Getters

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

    // Business methods

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

    public boolean verifyTopicSelected(String expectedTopic) {

        for (WebElement topic : getSelectedTopics()) {
            if (topic.getText().trim().equalsIgnoreCase(expectedTopic)) {
                return true;
            }
        }
        return false;
    }

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

    public String getAllTopicsText() {

        StringBuilder topicsText = new StringBuilder();

        for (WebElement topic : getSelectedTopics()) {
            topicsText.append(topic.getText()).append(", ");
        }

        return topicsText.toString();
    }
}