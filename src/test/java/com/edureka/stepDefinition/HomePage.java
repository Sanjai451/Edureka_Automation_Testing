package com.edureka.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.ExtentReportManager;
import com.edureka.utility.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Step definitions for home page interactions in Cucumber tests.
 * Handles navigation, login, and UI element clicks on the Edureka home page.
 */
public class HomePage extends AllFunctionality{
	private Base base;
	private ExtentTest logs;

	/**
	 * Constructor for HomePageTest.
	 * Initializes base and logs using the provided Base instance.
	 * @param base the Base instance for WebDriver access
	 */
	public HomePage(Base base) {
		this.base = base;
		logs = ExtentReportManager.getTest();
	}

	/**
	 * Step definition for navigating to the home page.
	 * Loads properties and navigates to the URL from config.
	 */
	@Given("goto home page")
	public void goto_home_page() {
		initPropertiesUtility("./src/main/resources/edureka.properties");
		String homePageUrl = getPropertyData("url");
//		System.out.println("Home page URL : " + homePageUrl);
		base.getDriver().get(homePageUrl);
		System.out.println("Navigated to home page");
	}

	/**
	 * Step definition for clicking on the Edureka logo.
	 */
	@When("the user clicks on the Edureka logo")
	public void the_user_clicks_on_the_edureka_logo() {
		Pages.get().homePage.clickOnEdurekaLogo();
	}
	
	/**
	 * Step definition for verifying user is on the Edureka homepage.
	 */
	@Given("the user is on the Edureka homepage")
	public void the_user_is_on_the_edureka_homepage() {
		System.out.println("Current URL : " + getUrl(base.getDriver()) + " From home page Checking message");
	}
	
	/**
	 * Step definition for verifying user is on the homepage.
	 */
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		System.out.println("Current URL : " + getUrl(base.getDriver()) + " From home page Checking message");
	}
	
	/**
	 * Step definition for user login to view forum icon.
	 * Opens login popup, enters credentials, and logs in.
	 */
	@Given("User needs to login to view forum icon on home page")
	public void user_needs_to_login_to_view_forum_icon_on_home_page() {
		Pages.get().loginPage.openLoginPopup();
		
		String USERNAME = getPropertyData("username");
		String PASSWORD = getPropertyData("password");
		
//		System.out.println("USERNAME : " + USERNAME);
//		System.out.println("PASSWORD : " + PASSWORD);
		
	    Pages.get().loginPage.enterEmail(USERNAME);
	    Pages.get().loginPage.enterPassword(PASSWORD);
	    Pages.get().loginPage.clickLogin();
	    
	    try {Thread.sleep(4000);} catch (Exception e) {}
	    
	}
	
	/**
	 * Step definition for clicking on a navigation button.
	 * @param string the name of the button to click
	 */
	@When("the user clicks on {string} in the navigation")
	public void the_user_clicks_on_in_the_navigation(String string) {
		Pages.get().homePage.clickOnButtonFromNavbar(base.getDriver(), string);
	}

	/**
	 * Step definition for verifying redirection to a specific page.
	 * @param string the expected page identifier in URL
	 */
	@Then("the user should be redirected to the {string} page")
	public void the_user_should_be_redirected_to_the_page(String string) {
		String currPageURL = getUrl(base.getDriver());
		System.out.println("redirected URL : " + currPageURL);
		
		By loaderLocator = By.cssSelector("[class*='loader_loader_div']");
		
		WebDriverWait wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(10));

        // Wait until loader is invisible or removed from DOM
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
    	
    	System.out.println("Loader disappeared");
    	
		assertTrue(currPageURL.contains(string));
	}
	
	/**
	 * Step definition for clicking on community navigation items.
	 * @param string the community item to click (e.g., forum)
	 */
	@When("the user clicks on {string} in the navigation under community")
	public void the_user_clicks_on_in_the_navigation_under_community(String string) {
		if(string.contains("forum")) {
			// click on forum
			Pages.get().homePage.clickOnForum();
		}else {
			System.out.println("Invalid text " + string);
			assertTrue(false);
		}
	}


	/**
	 * Step definition for clicking on resources navigation items from home page.
	 * @param link the resource link to click
	 */
	@When("the user clicks on {string} in the navigation under resources from home page")
	public void the_user_clicks_on_in_the_navigation_under_resources_from_home_page(String link) {
		System.out.println("Clicking under resources : " + link);
		Pages.get().homePage.clickOnButtonFromNavbarUnderResources(link);
	}


	/**
	 * Step definition for verifying the page reloads to a specific URL.
	 * @param string the expected URL substring
	 */
	@Then("the page should go to {string}")
	public void the_page_should_reload_to(String string) {
		assertTrue(getUrl(base.getDriver()).contains(string));
	}
	
	/**
	 * Step definition for user login to perform actions on community page.
	 * Opens login popup, enters credentials, and logs in with delays.
	 */
	@Given("user logs in for performing action in community page")
	public void user_logs_in_for_performing_action_in_community_page() {
		Pages.get().loginPage.openLoginPopup();
		
		String USERNAME = getPropertyData("username");
		String PASSWORD = getPropertyData("password");
		
	    Pages.get().loginPage.enterEmail(USERNAME);
	    Pages.get().loginPage.enterPassword(PASSWORD);
	    
	    try {Thread.sleep(1000);} catch (Exception e) {}
	    
	    Pages.get().loginPage.clickLogin();
	    
	    try {Thread.sleep(5000);} catch (Exception e) {}
	    
	}

}
