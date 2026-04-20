package com.edureka.stepDefinition;

import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class TopicOfInterest extends AllFunctionality {

    private Base base;

    public TopicOfInterest(Base base) {
        this.base = base;
    }

   
    List<String> topicsFromExcel = new ArrayList<>();
    String topicsBeforeRefresh;

    // NAVIGATION
    @Given("user clicks on Topics of Interest tab")
    public void clickTopicsTab() {
        Pages.myProfile.clickTopicsOfInterest();
    }

    // CLICK ADD NOW
    @When("user clicks Add Now button")
    public void clickAddNow() {
        Pages.topicsOfInterestPage.clickAddNow();
    }

    // READ FROM EXCEL
    @When("user reads topics from excel")
    public void readTopicsExcel() {

    	init("Topics");
    	topicsFromExcel.clear();
    	topicsFromExcel.add(getData(1, 0));
    	topicsFromExcel.add(getData(1, 1));
    	topicsFromExcel.add(getData(1, 2));
    }

    // SELECT TOPICS
    @When("user selects topics from excel")
    public void selectTopicsFromExcel() {

        boolean result = Pages.topicsSelectionPage.selectMultipleTopics(topicsFromExcel);

        Assert.assertTrue(result, "One or more topics not found");
    }

    // SAVE
    @When("user clicks Save and Continue in Topics")
    public void clickSaveContinueTopics() {
        Pages.topicsSelectionPage.clickSaveAndContinue();
    }

    // VALIDATE SAVE
    @Then("topics should be saved successfully")
    public void topicsSaved() {

        Assert.assertTrue(
                Pages.topicsOfInterestPage.isAnyTopicSelected(),
                "Topics not saved"
        );
    }

    // VALIDATE PERSISTENCE
    @Then("topics should persist after page refresh")
    public void verifyPersistence() {

        topicsBeforeRefresh = Pages.topicsOfInterestPage.getAllTopicsText();

        base.getDriver().navigate().refresh();

        String afterRefresh = Pages.topicsOfInterestPage.getAllTopicsText();

        Assert.assertEquals(
                afterRefresh,
                topicsBeforeRefresh,
                "Topics not persisted after refresh"
        );
    }
}s