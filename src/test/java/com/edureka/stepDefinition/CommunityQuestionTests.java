package com.edureka.stepDefinition;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommunityQuestionTests extends AllFunctionality {
	
	private Base base;
	
	public CommunityQuestionTests(Base base) {
		this.base = base;
	}
	
	@When("user navigates to Community section from footer link")
	public void user_navigates_to_community_section_from_footer_link() {
		Pages.homePage.goToCommunityPage();
	}

	@When("user clicks on question {string}")
	public void user_clicks_on_question(String question) {
		Pages.communityHomePage.clickOnQuestion(base.driver, question);
	}

	@When("user should see the question fully")
	public void user_should_see_the_question_fully() {
		
	}

	@When("user add comment for the question")
	public void user_add_comment_for_the_question() {
		Pages.communityQuestionPage.addCommentForQuestion(base.driver, "Test comment");
	}

	@Then("verify the comment is added")
	public void verify_the_comment_is_added() {

	}

	@When("user clicks on Ask a Question")
	public void user_clicks_on_ask_a_question() {
		Pages.communityHomePage.clickAskQuestion();
	}

	@When("user enters question details")
	public void user_enters_question_details(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		
		// here it will fill and submit 
		Pages.communityAskQuestion.fillQuestionDetails(null, null, null);
	}

	@When("user submits the question")
	public void user_submits_the_question() {
		// will be submitted prior
	}

	@Then("question should be posted successfully in the forum")
	public void question_should_be_posted_successfully_in_the_forum() {
		String titleString = Pages.communityQuestionAddedPage.getTitleOfQuestion();
		System.out.println("Question Added : " + titleString);
	}
	
	@When("user add answer for the question")
	public void user_add_answer_for_the_question() {
		Pages.communityQuestionPage.addAnswerForQuestion(base.driver, "Test Answer");
	}

	@Then("verify the answer is added")
	public void verify_the_answer_is_added() {
		
	}
}
