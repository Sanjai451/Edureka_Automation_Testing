package com.edureka.stepDefinition;

import java.awt.Window;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.support.FindBy;

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
		System.out.println("Current Page : " + getUrl(base.getDriver()));
		homePageHandle = base.getDriver().getWindowHandle();
	}

	@When("user clicks on {string} from navigation menu")
	public void user_clicks_on_from_navigation_menu(String string) {
		Pages.get().homePage.clickOnWebinarFromNavbar();
	}

	@Then("user should be redirected to webinars page")
	public void user_should_be_redirected_to_webinars_page() {
		System.out.println("Current Page :" + getUrl(base.getDriver()));
	}

	@Then("webinars page should load successfully")
	public void webinars_page_should_load_successfully() {
		System.out.println("Current Page :" + getUrl(base.getDriver()));
	}

	@Then("all upcoming webinars should be displayed")
	public void all_upcoming_webinars_should_be_displayed() {
		
		if(Pages.get().webinarHomePage.getUpcomingWebinarsTitles().size() > 0) {
			System.out.println("All upcoming webinar : ");
			Pages.get().webinarHomePage.printAllUpcomingWebinarTitles();
		}else {
			System.out.println("No upcoming webinars available at the time");
		}
		
	}

	@Then("all webinars category should be displayed")
	public void all_webinars_category_should_be_displayed() {
		if(Pages.get().webinarHomePage.getAllWebinarsCategory().size() > 1) {
			System.out.println("All webinar category : ");
			Pages.get().webinarHomePage.printAllCategoryTitles();			
		}
		else {
			System.out.println("No webinars available at the time");
		}
	}

	@When("user selects the category {string}")
	public void user_selects_the_category(String category) {
		
		if(Pages.get().webinarHomePage.getAllWebinarsCategory().size() > 1) {
			System.out.println("Navigating to category : " + category);
			Pages.get().webinarHomePage.clickOnWebinarCategory(base.getDriver(), category);
		}
		else {
			System.out.println("No webinars available at the time");
		}
		
	}

	// user will be in webinar category page
	
	@Then("user should be navigated to {string} webinar details page")
	public void user_should_be_navigated_to_webinar_details_page(String string) {
		
		if(base.getDriver().getWindowHandles().size() < 2) {
			System.out.println("Only one tab available : Unable to switch");
			return;
		}
		
		System.out.println("Current URL : " + getUrl(base.getDriver()));
		
		Set<String> handles = base.getDriver().getWindowHandles();
		for(String p : handles) {
			if(! p.equals(homePageHandle)) {
				base.getDriver().switchTo().window(p);
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
		// Double, Byte, Short, Long, BigInteger or) BigDecimal.
		
		if(base.getDriver().getWindowHandles().size() < 2) {
			System.out.println("Filling failed : No webinar present at the page at this time + " + new Date());
			return;
		}
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
	    Pages.get().webinarCategoryPage.fillDetailAndSubmit(email, phone, experience);
	}


	@Then("registration form or login page should be displayed")
	public void registration_form_or_login_page_should_be_displayed() {
		System.out.println("Current URL : " + getUrl(base.getDriver()));
	}
}
