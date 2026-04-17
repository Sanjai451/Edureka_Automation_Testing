package com.edureka.stepDefinition;

import java.awt.Window;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebinarTest extends AllFunctionality {
	Base base;
	String homePageHandle;
	public WebinarTest(Base base) {
		this.base = base;
	}
	
	@Given("user is on the Edureka homepage")
	public void user_is_on_the_edureka_homepage() {
		System.out.println("Current Page : " + getUrl(base.driver));
		homePageHandle = base.driver.getWindowHandle();
	}

	@When("user clicks on {string} from navigation menu")
	public void user_clicks_on_from_navigation_menu(String string) {
		Pages.homePage.clickOnWebinarFromNavbar();
	}

	@Then("user should be redirected to webinars page")
	public void user_should_be_redirected_to_webinars_page() {
		System.out.println("Current Page :" + getUrl(base.driver));
	}

	@Then("webinars page should load successfully")
	public void webinars_page_should_load_successfully() {
		System.out.println("Current Page :" + getUrl(base.driver));
	}

	@Then("all upcoming webinars should be displayed")
	public void all_upcoming_webinars_should_be_displayed() {
		System.out.println("All upcoming webinar : ");
		Pages.webinarHomePage.printAllUpcomingWebinarTitles();
	}

	@Then("all webinars category should be displayed")
	public void all_webinars_category_should_be_displayed() {
		System.out.println("All webinar category : ");
		Pages.webinarHomePage.printAllCategoryTitles();
	}

	@When("user selects the category {string}")
	public void user_selects_the_category(String category) {
		Pages.webinarHomePage.clickOnWebinarCategory(base.driver, category);
	}

	// user will be in webinar category page
	
	@Then("user should be navigated to {string} webinar details page")
	public void user_should_be_navigated_to_webinar_details_page(String string) {
		System.out.println("Current URL : " + getUrl(base.driver));
		
		Set<String> handles = base.driver.getWindowHandles();
		for(String p : handles) {
			if(! p.equals(homePageHandle)) {
				base.driver.switchTo().window(p);
				break;
			}
		}
	}
	

	@Then("fill the details in registration form")
	public void fill_the_details_in_registration_form(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

	    // Get first row
	    Map<String, String> userData = data.get(0);

	    String name = userData.get("Name");
	    String email = userData.get("Email");
	    String phone = userData.get("Phone");
	    String experience = userData.get("Experience");

	    // Pass to Page Object
	    Pages.webinarCategoryPage.fillDetailAndSubmit(email, phone, experience);
	}


	@Then("registration form or login page should be displayed")
	public void registration_form_or_login_page_should_be_displayed() {
		System.out.println("Current URL : " + getUrl(base.driver));
	}
}
