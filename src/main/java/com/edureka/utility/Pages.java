package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.edureka.pages.BlogCategoryPage;
import com.edureka.pages.BlogHomePage;
import com.edureka.pages.BlogPostPage;
import com.edureka.pages.BlogVideoFullScreenPage;
import com.edureka.pages.BlogVideoPage;
import com.edureka.pages.CareerInterestsPage;
import com.edureka.pages.CareerServicePage;
import com.edureka.pages.ChangePasswordPage;
import com.edureka.pages.CommunityAskQuestion;
import com.edureka.pages.CommunityHomePage;
import com.edureka.pages.CommunityQuestionAddedPage;
import com.edureka.pages.CommunityQuestionPage;
import com.edureka.pages.CorporateTrainingPage;
import com.edureka.pages.Dashboard;
import com.edureka.pages.HomePage;
import com.edureka.pages.LearningGoalsPage;
import com.edureka.pages.WebinarCategoryPage;
import com.edureka.pages.WebinarHomePage;
import com.edureka.pages.LoginPage;
import com.edureka.pages.MyProfile;
import com.edureka.pages.OrderPage;
import com.edureka.pages.OtherDetailsPage;
import com.edureka.pages.ProfessionalDetailsPage;
import com.edureka.pages.SearchHomePage;
import com.edureka.pages.SearchResultsPage;
import com.edureka.pages.SignUpPage;
import com.edureka.pages.StudyPlanPage;
import com.edureka.pages.TopicsOfInterestPage;
import com.edureka.pages.TopicsSelectionPage;
import com.edureka.pages.UserDetailsPage;
import com.edureka.pages.WalletPage;


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

	public static BlogHomePage blogHomePage;
	public static BlogCategoryPage blogCategoryPage;
	public static BlogPostPage blogPostPage;
	public static BlogVideoPage blogVideoPage;
	public static BlogVideoFullScreenPage blogVideoFullScreenPage;
	
	public static Dashboard dashboard;
	public static MyProfile myProfile;
	public static CareerServicePage careerServicePage;
	public static ProfessionalDetailsPage professionalDetailsPage;
	public static CareerInterestsPage careerInterestsPage;
	public static OtherDetailsPage otherDetailsPage;
	public static ChangePasswordPage changePasswordPage;
	public static TopicsOfInterestPage topicsOfInterestPage;
	public static TopicsSelectionPage topicsSelectionPage;
	public static WalletPage walletPage;
	public static UserDetailsPage userDetailsPage;
	public static LearningGoalsPage learningGoalsPage;
	public static StudyPlanPage studyPlanPage;
	public static OrderPage ordersPage;
	
	
	public static void loadAllPages(WebDriver driver) {
		
		// Home page and Community
		homePage = PageFactory.initElements(driver, HomePage.class);
		webinarCategoryPage = PageFactory.initElements(driver, WebinarCategoryPage.class);
		webinarHomePage = PageFactory.initElements(driver, WebinarHomePage.class);
		corporateTrainingPage = PageFactory.initElements(driver, CorporateTrainingPage.class);
		communityAskQuestion = PageFactory.initElements(driver, CommunityAskQuestion.class);
		communityHomePage = PageFactory.initElements(driver, CommunityHomePage.class);
		communityQuestionAddedPage = PageFactory.initElements(driver, CommunityQuestionAddedPage.class);
		communityQuestionPage = PageFactory.initElements(driver, CommunityQuestionPage.class);
		
		// Search 
		shp = PageFactory.initElements(driver, SearchHomePage.class);
		srp = PageFactory.initElements(driver, SearchResultsPage.class);

		// Auth and Blogs
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		blogHomePage = PageFactory.initElements(driver, BlogHomePage.class);
		blogCategoryPage = PageFactory.initElements(driver, BlogCategoryPage.class);
		blogPostPage = PageFactory.initElements(driver, BlogPostPage.class);
		blogVideoPage = PageFactory.initElements(driver, BlogVideoPage.class);
		blogVideoFullScreenPage = PageFactory.initElements(driver, BlogVideoFullScreenPage.class);
		
		// Profile 
		dashboard = PageFactory.initElements(driver, Dashboard.class);
		myProfile = PageFactory.initElements(driver, MyProfile.class);
		careerServicePage = PageFactory.initElements(driver, CareerServicePage.class);
		careerInterestsPage = PageFactory.initElements(driver, CareerInterestsPage.class);
		professionalDetailsPage = PageFactory.initElements(driver, ProfessionalDetailsPage.class);
		otherDetailsPage = PageFactory.initElements(driver, OtherDetailsPage.class);
		changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
		topicsOfInterestPage = PageFactory.initElements(driver, TopicsOfInterestPage.class);
		topicsSelectionPage = PageFactory.initElements(driver, TopicsSelectionPage.class);
		walletPage = PageFactory.initElements(driver, WalletPage.class);
		userDetailsPage = PageFactory.initElements(driver, UserDetailsPage.class);
		learningGoalsPage = PageFactory.initElements(driver, LearningGoalsPage.class);
		studyPlanPage = PageFactory.initElements(driver, StudyPlanPage.class);
		ordersPage = PageFactory.initElements(driver, OrderPage.class);
	}
}
