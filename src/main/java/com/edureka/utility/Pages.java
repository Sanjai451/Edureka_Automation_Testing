package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.edureka.pages.BlogCategoryPage;
import com.edureka.pages.BlogHomePage;
import com.edureka.pages.BlogPostPage;
import com.edureka.pages.BlogVideoFullScreenPage;
import com.edureka.pages.BlogVideoPage;
import com.edureka.pages.HomePage;
import com.edureka.pages.LoginPage;
import com.edureka.pages.SearchHomePage;
import com.edureka.pages.SearchResultsPage;
import com.edureka.pages.SignUpPage;


public class Pages {
	
	public static HomePage homePage;
//	public static WebinarCategoryPage webinarCategoryPage;
//	public static WebinarHomePage webinarHomePage;
//	public static CorporateTrainingPage corporateTrainingPage;
	public static SearchHomePage shp;
	public static SearchResultsPage srp;
	public static SignUpPage signUpPage;
	public static LoginPage loginPage;
	
	public static BlogHomePage blogHomePage;
	public static BlogCategoryPage blogCategoryPage;
	public static BlogPostPage blogPostPage;
	public static BlogVideoPage blogVideoPage;
	public static BlogVideoFullScreenPage blogVideoFullScreenPage;
	
	public static void loadAllPages(WebDriver driver) {
		homePage = PageFactory.initElements(driver, HomePage.class);
		shp = PageFactory.initElements(driver, SearchHomePage.class);
		srp = PageFactory.initElements(driver, SearchResultsPage.class);

		loginPage = PageFactory.initElements(driver, LoginPage.class);
		signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		
		blogHomePage = PageFactory.initElements(driver, BlogHomePage.class);
		blogCategoryPage = PageFactory.initElements(driver, BlogCategoryPage.class);
		blogPostPage = PageFactory.initElements(driver, BlogPostPage.class);
		blogVideoPage = PageFactory.initElements(driver, BlogVideoPage.class);
		blogVideoFullScreenPage = PageFactory.initElements(driver, BlogVideoFullScreenPage.class);
		
//		webinarCategoryPage = PageFactory.initElements(driver, WebinarCategoryPage.class);
//		webinarHomePage = PageFactory.initElements(driver, WebinarHomePage.class);
//		corporateTrainingPage = PageFactory.initElements(driver, CorporateTrainingPage.class);
	}
}
