
package com.edureka.utility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.edureka.pages.HomePage;
import com.edureka.pages.AddInstructorPage;
import com.edureka.pages.AllCoursePage;
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
import com.edureka.pages.Wishlist;
import com.edureka.pages.LoginPage;
import com.edureka.pages.MasterProgram;
import com.edureka.pages.MyProfile;
import com.edureka.pages.OrderPage;
import com.edureka.pages.OtherDetailsPage;

import com.edureka.pages.PostJobPage;

import com.edureka.pages.PartnerWithUsPage;

import com.edureka.pages.ProfessionalDetailsPage;
import com.edureka.pages.SearchHomePage;
import com.edureka.pages.SearchResultsPage;
import com.edureka.pages.SignUpPage;

import com.edureka.pages.StudyPlanPage;
import com.edureka.pages.TopicsOfInterestPage;
import com.edureka.pages.TopicsSelectionPage;
import com.edureka.pages.TrainingCourse;
import com.edureka.pages.UserDetailsPage;
import com.edureka.pages.WalletPage;

public class Pages {

	// ── ThreadLocal container ──────────────────────────────────────────────────
	private static final ThreadLocal<Pages> INSTANCE = new ThreadLocal<>();

	// ── Per-thread page object instances ──────────────────────────────────────

	// Home page and Community
	public HomePage homePage;
	public WebinarCategoryPage webinarCategoryPage;
	public WebinarHomePage webinarHomePage;
	public CorporateTrainingPage corporateTrainingPage;
	public CommunityAskQuestion communityAskQuestion;
	public CommunityHomePage communityHomePage;
	public CommunityQuestionAddedPage communityQuestionAddedPage;
	public CommunityQuestionPage communityQuestionPage;

	// Search
	public SearchHomePage shp;
	public SearchResultsPage srp;

	// Auth
	public SignUpPage signUpPage;
	public LoginPage loginPage;

	// Blogs
	public BlogHomePage blogHomePage;
	public BlogCategoryPage blogCategoryPage;
	public BlogPostPage blogPostPage;
	public BlogVideoPage blogVideoPage;
	public BlogVideoFullScreenPage blogVideoFullScreenPage;

	// Profile
	public Dashboard dashboard;
	public MyProfile myProfile;
	public CareerServicePage careerServicePage;
	public ProfessionalDetailsPage professionalDetailsPage;
	public CareerInterestsPage careerInterestsPage;
	public OtherDetailsPage otherDetailsPage;
	public ChangePasswordPage changePasswordPage;
	public TopicsOfInterestPage topicsOfInterestPage;
	public TopicsSelectionPage topicsSelectionPage;
	public WalletPage walletPage;
	public UserDetailsPage userDetailsPage;
	public LearningGoalsPage learningGoalsPage;
	public StudyPlanPage studyPlanPage;
	public OrderPage ordersPage;
	public AddInstructorPage addInstructorPage;
	public PartnerWithUsPage partnerWithUsPage;

	// Courses
	public AllCoursePage allCoursePage;
	public MasterProgram masterProgram;
	public TrainingCourse trainingCourse;
	public Wishlist wishlist;
	
	
	//postjob
	public PostJobPage postJobPage;

	// ── Private constructor — only created via loadAllPages ───────────────────
	private Pages(WebDriver driver) {

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

		// Auth
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	  signUpPage = PageFactory.initElements(driver, SignUpPage.class);

		// Blogs
		blogHomePage = PageFactory.initElements(driver, BlogHomePage.class);
		blogCategoryPage = PageFactory.initElements(driver, BlogCategoryPage.class);
		blogPostPage = PageFactory.initElements(driver, BlogPostPage.class);
		blogVideoPage = PageFactory.initElements(driver, BlogVideoPage.class);
		blogVideoFullScreenPage = PageFactory.initElements(driver, BlogVideoFullScreenPage.class);

		// Profile
		dashboard = PageFactory.initElements(driver, Dashboard.class);
		myProfile = PageFactory.initElements(driver, MyProfile.class);
		careerServicePage = PageFactory.initElements(driver, CareerServicePage.class);
		professionalDetailsPage = PageFactory.initElements(driver, ProfessionalDetailsPage.class);
		careerInterestsPage = PageFactory.initElements(driver, CareerInterestsPage.class);
		otherDetailsPage = PageFactory.initElements(driver, OtherDetailsPage.class);
		changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
		topicsOfInterestPage = PageFactory.initElements(driver, TopicsOfInterestPage.class);
		topicsSelectionPage = PageFactory.initElements(driver, TopicsSelectionPage.class);
		walletPage = PageFactory.initElements(driver, WalletPage.class);
		userDetailsPage = PageFactory.initElements(driver, UserDetailsPage.class);
		learningGoalsPage = PageFactory.initElements(driver, LearningGoalsPage.class);
		studyPlanPage = PageFactory.initElements(driver, StudyPlanPage.class);
		ordersPage = PageFactory.initElements(driver, OrderPage.class);
		addInstructorPage = PageFactory.initElements(driver, AddInstructorPage.class);
		partnerWithUsPage = PageFactory.initElements(driver, PartnerWithUsPage.class);

		// Courses
		allCoursePage = PageFactory.initElements(driver, AllCoursePage.class);
		masterProgram = PageFactory.initElements(driver, MasterProgram.class);
		trainingCourse = PageFactory.initElements(driver, TrainingCourse.class);
		wishlist = PageFactory.initElements(driver, Wishlist.class);
		
		//PostJob
		postJobPage = PageFactory.initElements(driver, PostJobPage.class);
		
	}

	/**
	 * Called once per scenario in Hook.setUp(). Creates a fresh Pages instance
	 * bound to this thread's WebDriver.
	 */
	public static void loadAllPages(WebDriver driver) {
		INSTANCE.set(new Pages(driver));
	}

	/**
	 * Returns this thread's Pages instance. Call this from every step definition
	 * instead of using static fields.
	 */
	public static Pages get() {
		Pages pages = INSTANCE.get();
		if (pages == null) {
			throw new IllegalStateException("Pages not initialised for thread " + Thread.currentThread().getName()
					+ ". Ensure Hook.setUp() ran before accessing Pages.get().");
		}
		return pages;
	}

	/**
	 * Must be called in Hook.tearDown() to prevent ThreadLocal memory leaks in
	 * thread-pool environments (Maven Surefire, CI agents, etc.).
	 */
	public static void cleanUp() {
		INSTANCE.remove();
	}
}
