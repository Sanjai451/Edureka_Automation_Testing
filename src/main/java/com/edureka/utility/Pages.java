package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.edureka.pages.CommunityAskQuestion;
import com.edureka.pages.CommunityHomePage;
import com.edureka.pages.CommunityQuestionAddedPage;
import com.edureka.pages.CommunityQuestionPage;
import com.edureka.pages.CorporateTrainingPage;
import com.edureka.pages.HomePage;
import com.edureka.pages.WebinarCategoryPage;
import com.edureka.pages.WebinarHomePage;


public class Pages {
	
	public static HomePage homePage;
	public static WebinarCategoryPage webinarCategoryPage;
	public static WebinarHomePage webinarHomePage;
	public static CorporateTrainingPage corporateTrainingPage;
	
	public static CommunityAskQuestion communityAskQuestion;
	public static CommunityHomePage communityHomePage;
	public static CommunityQuestionAddedPage communityQuestionAddedPage;
	public static CommunityQuestionPage communityQuestionPage;
	
	public static void loadAllPages(WebDriver driver) {
		homePage = PageFactory.initElements(driver, HomePage.class);
		webinarCategoryPage = PageFactory.initElements(driver, WebinarCategoryPage.class);
		webinarHomePage = PageFactory.initElements(driver, WebinarHomePage.class);
		corporateTrainingPage = PageFactory.initElements(driver, CorporateTrainingPage.class);
		
		communityAskQuestion = PageFactory.initElements(driver, CommunityAskQuestion.class);
		communityHomePage = PageFactory.initElements(driver, CommunityHomePage.class);
		communityQuestionAddedPage = PageFactory.initElements(driver, CommunityQuestionAddedPage.class);
		communityQuestionPage = PageFactory.initElements(driver, CommunityQuestionPage.class);
	}
}
