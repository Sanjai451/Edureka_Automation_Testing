package com.edureka.stepDefinition;

import static org.testng.Assert.assertTrue;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageTest extends AllFunctionality{
	private Base base;

	public HomePageTest(Base base) {
		this.base = base;
	}

	@Given("goto home page")
	public void goto_home_page() {
		initPropertiesUtility("./src/main/resources/edureka.properties");
		String homePageUrl = getPropertyData("url");
		System.out.println("Home page URL : " + homePageUrl);
		base.driver.get(homePageUrl);
		System.out.println("Navigated to home page");
	}

	@When("the user clicks on the Edureka logo")
	public void the_user_clicks_on_the_edureka_logo() {
		Pages.homePage.clickOnEdurekaLogo();
	}
	
	@Given("the user is on the Edureka homepage")
	public void the_user_is_on_the_edureka_homepage() {
		System.out.println("Current URL : " + getUrl(base.driver) + " From home page Checking message");
	}
	
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		System.out.println("Current URL : " + getUrl(base.driver) + " From home page Checking message");
	}
	
	@Given("User needs to login to view forum icon on home page")
	public void user_needs_to_login_to_view_forum_icon_on_home_page() {
		Pages.loginPage.openLoginPopup();
	    Pages.loginPage.enterEmail("sanjai6369kumar@gmail.com");
	    Pages.loginPage.enterPassword("Password");
	    Pages.loginPage.clickLogin();
	    
	    try {Thread.sleep(4000);} catch (Exception e) {}
	    
	}
	
	@When("the user clicks on {string} in the navigation")
	public void the_user_clicks_on_in_the_navigation(String string) {
		Pages.homePage.clickOnButtonFromNavbar(base.driver, string);
	}

	@Then("the user should be redirected to the {string} page")
	public void the_user_should_be_redirected_to_the_page(String string) {
		String currPageURL = getUrl(base.driver);
		System.out.println("redirected URL : " + currPageURL);
		assertTrue(currPageURL.contains(string));
	}
	
	@When("the user clicks on {string} in the navigation under community")
	public void the_user_clicks_on_in_the_navigation_under_community(String string) {
		if(string.contains("forum")) {
			// click on forum
			Pages.homePage.clickOnForum();
		}else {
			System.out.println("Invalid text " + string);
			assertTrue(false);
		}
	}


	@When("the user clicks on {string} in the navigation under resources from home page")
	public void the_user_clicks_on_in_the_navigation_under_resources_from_home_page(String link) {
		System.out.println("Clicking under resources : " + link);
		Pages.homePage.clickOnButtonFromNavbarUnderResources(link);
	}


	@Then("the page should go to {string}")
	public void the_page_should_reload_to(String string) {
		assertTrue(getUrl(base.driver).contains(string));
	}
	
	@Given("user logs in for performing action in community page")
	public void user_logs_in_for_performing_action_in_community_page() {
		Pages.loginPage.openLoginPopup();
	    Pages.loginPage.enterEmail("sanjai6369kumar@gmail.com");
	    Pages.loginPage.enterPassword("Password");
	    
	    try {
			Thread.sleep(1000);
		} catch (Exception e) {}
	    
	    Pages.loginPage.clickLogin();
	    
	    try {Thread.sleep(5000);} catch (Exception e) {}
	    
	}

}
