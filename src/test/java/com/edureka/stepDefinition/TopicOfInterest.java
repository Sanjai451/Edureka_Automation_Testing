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

	// Constructor to initialize base
	public TopicOfInterest(Base base) {
		this.base = base;
	}

	// List to store topics from excel
	List<String> topicsFromExcel = new ArrayList<>();

	// Variable to store topics before refresh
	String topicsBeforeRefresh;

	// Step to click topics of interest tab
	@Given("user clicks on Topics of Interest tab")
	public void clickTopicsTab() {
		Pages.get().myProfile.clickTopicsOfInterest();
	}

	// Step to click add now button
	@When("user clicks Add Now button")
	public void clickAddNow() {
		Pages.get().topicsOfInterestPage.clickAddNow();
	}

	// Step to read topics from excel
	@When("user reads topics from excel")
	public void readTopicsExcel() {

		init("Topics");
		topicsFromExcel.clear();
		topicsFromExcel.add(getData(1, 0));
		topicsFromExcel.add(getData(1, 1));
		topicsFromExcel.add(getData(1, 2));
	}

	// Step to select topics
	@When("user selects topics from excel")
	public void selectTopicsFromExcel() {

		boolean result = Pages.get().topicsSelectionPage.selectMultipleTopics(topicsFromExcel);

		Assert.assertTrue(result, "One or more topics not found");
	}

	// Step to click save and continue
	@When("user clicks Save and Continue in Topics")
	public void clickSaveContinueTopics() {
		Pages.get().topicsSelectionPage.clickSaveAndContinue();
	}

	// Step to validate topics saved
	@Then("topics should be saved successfully")
	public void topicsSaved() {

		boolean isSaved = Pages.get().topicsOfInterestPage.isAnyTopicSelected();

		Assert.assertTrue(isSaved, "Topics not saved");
	}

	// Step to validate topics persistence after refresh
	@Then("topics should persist after page refresh")
	public void verifyPersistence() {

		topicsBeforeRefresh = Pages.get().topicsOfInterestPage.getAllTopicsText();

		base.getDriver().navigate().refresh();

		String afterRefresh = Pages.get().topicsOfInterestPage.getAllTopicsText();

		Assert.assertEquals(afterRefresh, topicsBeforeRefresh, "Topics not persisted after refresh");
	}
}