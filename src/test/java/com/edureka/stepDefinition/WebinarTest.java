package com.edureka.stepDefinition;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
 * Test step definitions for Webinar-related scenarios.
 * This class contains Cucumber step implementations for navigating to webinars,
 * validating pages, and filling registration forms.
 */
public class WebinarTest extends AllFunctionality {
	private Base base;
	private String homePageHandle;
	private ExtentTest logs;
	private WebDriverWait wait;
	
	/**
	 * Constructor for WebinarTest.
	 * Initializes the base, logs, and wait objects.
	 * @param base the Base instance for WebDriver access
	 */
	public WebinarTest(Base base) {
		this.base = base;
		logs = ExtentReportManager.getTest();
		this.wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(15));
	}
	
	
	/**
	 * Step definition for ensuring the user is on the Edureka homepage.
	 * Stores the home page handle and verifies the URL.
	 */
	@Given("user is on the Edureka homepage")
	public void user_is_on_the_edureka_homepage() {
//		System.out.println("Current Page : " + getUrl(base.getDriver()));
//		homePageHandle = base.getDriver().getWindowHandle();
//		logs.log(Status.PASS,"User is on edureka home page");
		WebDriver driver = base.getDriver();

        // Store current window handle for later tab switching
        homePageHandle = driver.getWindowHandle();

        // Assert user is on homepage using URL
        wait.until(driver1 -> getUrl(driver1).contains("edureka"));
        Assert.assertTrue(getUrl(driver).contains("edureka"),
                "User is not on Edureka homepage");

	}

	/**
	 * Step definition for clicking on the webinar navigation menu item.
	 * Waits for the element to be clickable before clicking.
	 */
	@When("user clicks on {string} from navigation menu")
	public void user_clicks_on_from_navigation_menu(String string) {
//		Pages.get().homePage.clickOnWebinarFromNavbar();
//		logs.log(Status.PASS,"Navigated to Webinar Page");
		// Wait for navigation element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(
                Pages.get().homePage.getWebinarNavElement()));

        Pages.get().homePage.clickOnWebinarFromNavbar();

	}

	@Then("user should be redirected to webinars page")
	public void user_should_be_redirected_to_webinars_page() {
//		System.out.println("Current Page :" + getUrl(base.getDriver()));
//		logs.log(Status.PASS,"Redirected to Webinar Page");
		
		 // Wait until URL changes to webinar page
        wait.until(driver -> getUrl(driver).contains("webinars"));

        Assert.assertTrue(getUrl(base.getDriver()).contains("webinars"),
                "User not redirected to webinars page");

	}

	@Then("webinars page should load successfully")
	public void webinars_page_should_load_successfully() {
		wait.until(driver -> getUrl(driver).contains("webinar"));
		
		System.out.println("87 Current Page :" + getUrl(base.getDriver()));
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
			logs.log(Status.PASS,"Unable to switch tab");
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
	

	/**
	 * Step definition for filling the registration form using data from a DataTable.
	 * Extracts email, phone, and experience from the first row and submits the form.
	 * @param dataTable the Cucumber DataTable containing form data
	 */
	@Then("fill the details in registration form")
	public void fill_the_details_in_registration_form(io.cucumber.datatable.DataTable dataTable) {
		
		if(base.getDriver().getWindowHandles().size() < 2) {
			System.out.println("Filling failed : No webinar present at the page at this time + " + new Date());
			logs.log(Status.WARNING,"No webinar present at the page at this time");
			return;
		}
		
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
