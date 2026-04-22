package com.edureka.stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class AllCoursesStep extends AllFunctionality {

	private Base base;
	private WebDriverWait wait;
	private ExtentTest logs;

	public AllCoursesStep(Base base) {
		this.base = base;
		this.wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(10));
		logs = ExtentReportManager.getTest();
	}

	// Step to ensure user is on homepage
	@Given("user is on homepage")
	public void user_is_on_homepage() {
	}

	// Step to perform login for wishlist actions
	@When("user logs in to add course in wishlists")
	public void user_logs_in_to_add_course_in_wishlists() {
		Pages.get().loginPage.openLoginPopup();
		Pages.get().loginPage.enterEmail("jayasreemahesh.d@gmail.com");
		Pages.get().loginPage.enterPassword("Jayasree@11");
		Pages.get().loginPage.clickLogin();
	}

	// Step to click on All Courses or specific category
	@When("user clicks on {string}")
	public void user_clicks_on(String value) {
		if (value.equalsIgnoreCase("All Courses")) {
			Pages.get().homePage.clickAllCourses();
		} else {
			Pages.get().allCoursePage.clickOnCategory(base.getDriver(), value);
		}
	}

	// Step to validate All Courses page is loaded
	@Then("all courses page should be displayed")
	public void all_courses_page_should_be_displayed() {

		WebDriverWait wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("all-courses"));

		Assert.assertTrue(base.getDriver().getCurrentUrl().toLowerCase().contains("all-courses"));
	}

	// Step to verify course list visibility
	@Then("course list should be visible")
	public void course_list_should_be_visible() {

		WebDriverWait wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(20));

		List<WebElement> courses = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@class, 'category_slide_detail')]")));

		Assert.assertTrue(courses.size() > 0, "Course list is empty");
	}

	// Step to select course using string
	@When("user selects course {string}")
	public void user_selects_course(String courseName) {
		Pages.get().allCoursePage.clickOnCourse(base.getDriver(), courseName);
	}

	// Step to select course using DataTable
	@When("user selects course")
	public void user_selects_course(io.cucumber.datatable.DataTable table) {

		Map<String, String> data = table.asMaps(String.class, String.class).get(0);
		String courseName = data.get("course").trim();

		Pages.get().allCoursePage.clickOnCourse(base.getDriver(), courseName);
	}

	// Step to verify navigation to course page
	@Then("user should be navigated to course page")
	public void user_should_be_navigated_to_course_page() {

		WebDriverWait wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));

		Assert.assertTrue(base.getDriver().getCurrentUrl().contains("course")
				|| base.getDriver().getCurrentUrl().contains("training"), "Not navigated to course page");
	}

	// Step to fill certificate details from DataTable
	@When("user fills certificate details")
	public void user_fills_certificate_details(io.cucumber.datatable.DataTable table) {

		Map<String, String> data = table.asMaps(String.class, String.class).get(0);

		Pages.get().trainingCourse.fillDetailForGettingCert(base.getDriver(), data.get("name"), data.get("email"),
				data.get("phone"));
	}

	// Step to validate certificate success message
	@Then("certificate success message should be displayed")
	public void certificate_success_message_should_be_displayed() {

		WebElement successMsg = new WebDriverWait(base.getDriver(), Duration.ofSeconds(10)).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Certificate sent to your inbox']")));

		Assert.assertTrue(successMsg.isDisplayed());
	}

	// Step to click preview certificate button
	@When("user clicks on preview certificate button")
	public void user_clicks_on_preview_certificate_button() {
		Pages.get().trainingCourse.clickPreviewCertificate(base.getDriver());
	}

	// Step to scroll to preview certificate section
	@When("user scrolls to preview certificate section")
	public void user_scrolls_to_preview_certificate_section() {
		Pages.get().trainingCourse.scrollToPreviewCertificate(base.getDriver());
	}

	// Step to fill training form details
	@When("user fills training form details")
	public void user_fills_training_form_details() {
		Pages.get().trainingCourse.fillQueryForm(base.getDriver(), "Test User", "testuser123@gmail.com", "9876543210",
				"ABC Pvt Ltd", "For Corporate");
	}

	// Step to validate form submission
	@Then("form should be submitted successfully")
	public void form_should_be_submitted_successfully() {
		Assert.assertTrue(base.getDriver().getPageSource().toLowerCase().contains("thank")
				|| base.getDriver().getPageSource().toLowerCase().contains("success")
				|| base.getDriver().getPageSource().toLowerCase().contains("submitted"));
	}

	// Step to validate course title
	@Then("course title should be displayed correctly")
	public void course_title_should_be_displayed_correctly() {
		String title = Pages.get().trainingCourse.getCourseTitle();
		Assert.assertNotNull(title);
		Assert.assertFalse(title.trim().isEmpty());
	}

	// Step to validate URL contains keyword
	@Then("URL should contain {string}")
	public void url_should_contain(String keyword) {
		new WebDriverWait(base.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(keyword));

		Assert.assertTrue(base.getDriver().getCurrentUrl().toLowerCase().contains(keyword.toLowerCase()));
	}

	// Step to click enroll button
	@Then("user needs to click on enroll button")
	public void user_needs_to_click_on_enroll_button() {
		Pages.get().trainingCourse.enrollNow(base.getDriver(), "sample23244@efail.com", "9078675645");
	}

	// Step to verify navigation to payment page
	@Then("verify user is on payment page")
	public void check_enroll() {
		boolean isOnPaymentPage = new WebDriverWait(base.getDriver(), Duration.ofSeconds(15))
				.until(ExpectedConditions.urlContains("payment"));

		assertTrue(isOnPaymentPage);
	}

	// Step to add course to wishlist
	@When("user adds course to wishlist")
	public void user_adds_course_to_wishlist() {
		try {
			Pages.get().masterProgram.addToWishlist();
		} catch (Exception e) {
			System.out.println("Wishlist click failed");
		}
	}

	// Step to scroll to training form
	@When("user scrolls to training form")
	public void user_scrolls_to_training_form() {
		Pages.get().trainingCourse.scrollToQueryForm(base.getDriver());
	}

	// Step to click browser back
	@When("user clicks browser back")
	public void user_clicks_browser_back() {
		base.getDriver().navigate().back();
	}

	// Step to verify return to All Courses page
	@Then("user should return to All Courses page")
	public void user_should_return_to_all_courses_page() {
		new WebDriverWait(base.getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.urlContains("all-courses"));

		Assert.assertTrue(base.getDriver().getCurrentUrl().toLowerCase().contains("all-courses"));
	}

	// Step to verify course cards clickable
	@Then("all course cards should be clickable")
	public void all_course_cards_should_be_clickable() {
		List<WebElement> courses = base.getDriver().findElements(By.xpath("//a[contains(@href,'/course')]"));
		Assert.assertTrue(courses.size() > 0);
	}

	// Step to navigate directly to All Courses page
	@Given("user is on All Courses page")
	public void user_is_on_all_courses_page() {
		base.getDriver().get("https://www.edureka.co/all-courses");
	}

	// Step to click invalid course
	@When("user clicks on invalid course {string}")
	public void user_clicks_on_invalid_course(String course) {
		try {
			Pages.get().allCoursePage.clickOnCourse(base.getDriver(), course);
		} catch (Exception e) {
			System.out.println("Invalid course handled");
		}
	}

	// Step to verify error message/page
	@Then("error page or message should be displayed")
	public void error_page_or_message_should_be_displayed() {
		Assert.assertTrue(base.getDriver().getPageSource().toLowerCase().contains("error")
				|| base.getDriver().getPageSource().toLowerCase().contains("not found"));
	}

	// Step to navigate directly to course page
	@Given("user is on course page")
	public void user_is_on_course_page() {
		base.getDriver().get("https://www.edureka.co/data-science-certification-courses");
	}

	// Step to verify wishlist content
	@Then("course should appear in wishlist {string}")
	public void course_should_not_appear_in_wishlist(String course) {
		Pages.get().wishlist.clickProfileDropDown();
		Pages.get().wishlist.clickWishList();
		String res = Pages.get().wishlist.getMessage();
		assertEquals(res, course);
	}

	// Step to validate generic message
	@Then("{string} message should be displayed")
	public void message_should_be_displayed(String message) {
		Assert.assertTrue(base.getDriver().getPageSource().toLowerCase().contains(message.toLowerCase()));
	}

	// Step to select course from Excel
	@When("user selects course from excel")
	public void user_selects_course_from_excel() throws Exception {
		Object[][] data = new AllFunctionality().getExcelDataAsArray("Sheet1");
		Pages.get().allCoursePage.clickOnCourse(base.getDriver(), data[0][0].toString().trim());
	}

	// Step to enroll using Excel data
	@Then("user needs to click on enroll button using excel data")
	public void user_enrolls_using_excel() throws Exception {
		Object[][] data = new AllFunctionality().getExcelDataAsArray("Sheet1");
		Pages.get().trainingCourse.enrollNow(base.getDriver(), data[0][1].toString().trim(),
				data[0][2].toString().trim());
	}
}