package com.edureka.stepDefinition;

import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class TopicOfInterest {

    private Base base;

    public TopicOfInterest(Base base) {
        this.base = base;
    }

    AllFunctionality util = new AllFunctionality();

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

        util.init("Topics");

        topicsFromExcel.clear();
        topicsFromExcel.add(util.getData(1, 0));
        topicsFromExcel.add(util.getData(1, 1));
        topicsFromExcel.add(util.getData(1, 2));
    }

    // SELECT TOPICS
    @When("user selects topics from excel")
    public void selectTopicsFromExcel() {

        Pages.topicsSelectionPage.selectMultipleTopics(topicsFromExcel);

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

        base.driver.navigate().refresh();

        String afterRefresh = Pages.topicsOfInterestPage.getAllTopicsText();

        Assert.assertEquals(
                afterRefresh,
                topicsBeforeRefresh,
                "Topics not persisted after refresh"
        );
    }
}