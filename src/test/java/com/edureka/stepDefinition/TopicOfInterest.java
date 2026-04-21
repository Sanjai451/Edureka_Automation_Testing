package com.edureka.stepDefinition;

import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;
import com.edureka.utility.ExtentReportManager;

public class TopicOfInterest extends AllFunctionality {

    private Base base;
    private ExtentTest logs;

    public TopicOfInterest(Base base) {
        this.base = base;
        logs = ExtentReportManager.getTest();
    }

    List<String> topicsFromExcel = new ArrayList<>();
    String topicsBeforeRefresh;

    // NAVIGATION
    @Given("user clicks on Topics of Interest tab")
    public void clickTopicsTab() {
        Pages.get().myProfile.clickTopicsOfInterest();
        logs.log(Status.PASS, "Clicked on Topics of Interest tab");
    }

    // CLICK ADD NOW
    @When("user clicks Add Now button")
    public void clickAddNow() {
        Pages.get().topicsOfInterestPage.clickAddNow();
        logs.log(Status.PASS, "Clicked Add Now button");
    }

    // READ FROM EXCEL
    @When("user reads topics from excel")
    public void readTopicsExcel() {

        init("Topics");
        topicsFromExcel.clear();
        topicsFromExcel.add(getData(1, 0));
        topicsFromExcel.add(getData(1, 1));
        topicsFromExcel.add(getData(1, 2));

        logs.log(Status.PASS, "Read Topics from Excel: " + topicsFromExcel);
    }

    // SELECT TOPICS
    @When("user selects topics from excel")
    public void selectTopicsFromExcel() {

        boolean result = Pages.get().topicsSelectionPage.selectMultipleTopics(topicsFromExcel);

        logs.log(Status.PASS, "Selecting Topics: " + topicsFromExcel);

        Assert.assertTrue(result, "One or more topics not found");

        logs.log(Status.PASS, "All topics selected successfully");
    }

    // SAVE
    @When("user clicks Save and Continue in Topics")
    public void clickSaveContinueTopics() {
        Pages.get().topicsSelectionPage.clickSaveAndContinue();
        logs.log(Status.PASS, "Clicked Save and Continue in Topics");
    }

    // VALIDATE SAVE
    @Then("topics should be saved successfully")
    public void topicsSaved() {

        boolean isSaved = Pages.get().topicsOfInterestPage.isAnyTopicSelected();

        logs.log(Status.PASS, "Validating topics are saved");

        Assert.assertTrue(
                isSaved,
                "Topics not saved"
        );

        logs.log(Status.PASS, "Topics saved successfully");
    }

    // VALIDATE PERSISTENCE
    @Then("topics should persist after page refresh")
    public void verifyPersistence() {

        topicsBeforeRefresh = Pages.get().topicsOfInterestPage.getAllTopicsText();

        logs.log(Status.PASS, "Topics before refresh: " + topicsBeforeRefresh);

        base.getDriver().navigate().refresh();

        String afterRefresh = Pages.get().topicsOfInterestPage.getAllTopicsText();

        logs.log(Status.PASS, "Topics after refresh: " + afterRefresh);

        Assert.assertEquals(
                afterRefresh,
                topicsBeforeRefresh,
                "Topics not persisted after refresh"
        );

        logs.log(Status.PASS, "Topics persisted successfully after refresh");
    }
}