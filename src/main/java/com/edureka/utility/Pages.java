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
import com.edureka.pages.LoginPage;
import com.edureka.pages.SearchHomePage;
import com.edureka.pages.SearchResultsPage;
import com.edureka.pages.SignUpPage;


public class Pages {
	
	public static HomePage homePage;
	public static WebinarCategoryPage webinarCategoryPage;
	public static WebinarHomePage webinarHomePage;
	public static CorporateTrainingPage corporateTrainingPage;
	
	public static CommunityAskQuestion communityAskQuestion;
	public static CommunityHomePage communityHomePage;
	public static CommunityQuestionAddedPage communityQuestionAddedPage;
	public static CommunityQuestionPage communityQuestionPage;

	public static SearchHomePage shp;
	public static SearchResultsPage srp;
	public static SignUpPage signUpPage;
	public static LoginPage loginPage;
	
	public static void loadAllPages(WebDriver driver) {
		homePage = PageFactory.initElements(driver, HomePage.class);
		webinarCategoryPage = PageFactory.initElements(driver, WebinarCategoryPage.class);
		webinarHomePage = PageFactory.initElements(driver, WebinarHomePage.class);
		corporateTrainingPage = PageFactory.initElements(driver, CorporateTrainingPage.class);
		
		communityAskQuestion = PageFactory.initElements(driver, CommunityAskQuestion.class);
		communityHomePage = PageFactory.initElements(driver, CommunityHomePage.class);
		communityQuestionAddedPage = PageFactory.initElements(driver, CommunityQuestionAddedPage.class);
		communityQuestionPage = PageFactory.initElements(driver, CommunityQuestionPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		shp = PageFactory.initElements(driver, SearchHomePage.class);
		srp = PageFactory.initElements(driver, SearchResultsPage.class);

		loginPage = PageFactory.initElements(driver, LoginPage.class);
		signUpPage = PageFactory.initElements(driver, SignUpPage.class);
//	public static WebinarCategoryPage webinarCategoryPage;
//	public static WebinarHomePage webinarHomePage;
//	public static CorporateTrainingPage corporateTrainingPage;
	
//		webinarCategoryPage = PageFactory.initElements(driver, WebinarCategoryPage.class);
//		webinarHomePage = PageFactory.initElements(driver, WebinarHomePage.class);
//		corporateTrainingPage = PageFactory.initElements(driver, CorporateTrainingPage.class);
	
	}
}
