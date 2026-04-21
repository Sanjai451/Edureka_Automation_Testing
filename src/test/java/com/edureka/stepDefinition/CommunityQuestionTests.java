package com.edureka.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.ExtentReportManager;
import com.edureka.utility.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommunityQuestionTests extends AllFunctionality {
	
	private Base base;
	private ExtentTest logs;
	private WebDriverWait wait;
	
	public CommunityQuestionTests(Base base) {
		this.base = base;
		logs = ExtentReportManager.getTest();
		this.wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(15));
	}
	
	@When("user navigates to Community section from footer link")
	public void user_navigates_to_community_section_from_footer_link() {
		Pages.get().homePage.goToCommunityPage(base.getDriver());
//		Pages.get().communityHomePage.performLogin("sanjai6369kumar@gmail.com", "Password");
		
		// Wait for community page to load (URL or key element)
        wait.until(driver -> driver.getCurrentUrl().contains("community"));

        assertTrue(base.getDriver().getCurrentUrl().contains("community"),
                "Community page not loaded");

        logs.log(Status.PASS, "Navigated to Community Page");
	}

	@When("user clicks on question {string}")
	public void user_clicks_on_question(String question) {
		Pages.get().communityHomePage.clickOnQuestion(base.getDriver(), question);
		logs.log(Status.INFO,"User clicked on question " + question);
	}

	@When("user should see the question fully")
	public void user_should_see_the_question_fully() {

	}

	@When("user add comment for the question")
	public void user_add_comment_for_the_question() {
		Pages.get().communityQuestionPage.addCommentForQuestion(base.getDriver(), "Test comment");
		logs.log(Status.INFO,"User add comments to the question");
	}

	@Then("verify the comment is added")
	public void verify_the_comment_is_added() {
		
	}

	@When("user clicks on Ask a Question")
	public void user_clicks_on_ask_a_question() {
		Pages.get().communityHomePage.clickAskQuestion(base.getDriver());
		logs.log(Status.INFO,"User clicked on 'Ask a Question'");
	}

	@When("user enters question details")
	public void user_enters_question_details(io.cucumber.datatable.DataTable dataTable) {

		init("CommunityQuestions");
		String title = getData(1, 0);
		String category = getData(1, 1);
		String tag = getData(0, 3);
		
		Pages.get().communityAskQuestion.fillQuestionDetails(base.getDriver(), title, category, tag);
		logs.log(Status.INFO,"User filled Details for Question");
	}

	@When("user submits the question")
	public void user_submits_the_question() {}

	@Then("question should be posted successfully in the forum")
	public void question_should_be_posted_successfully_in_the_forum() {
		String titleString = Pages.get().communityQuestionAddedPage.getTitleOfQuestion();
		System.out.println("Question Added : " + titleString);
		logs.log(Status.INFO,"Question Added Successfully");
	}
	
	@When("user add answer for the question")
	public void user_add_answer_for_the_question() {
		Pages.get().communityQuestionPage.addAnswerForQuestion(base.getDriver(), "Test Answer");
		logs.log(Status.INFO,"Answer added to the question");
	}

	@Then("verify the answer is added")
	public void verify_the_answer_is_added() {
		System.out.println(Pages.get().communityQuestionAddedPage.getTitleOfQuestion());
	}
}
