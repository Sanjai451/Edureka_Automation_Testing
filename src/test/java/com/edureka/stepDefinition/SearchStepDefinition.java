package com.edureka.stepDefinition;

import java.util.List;

import org.testng.Assert;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDefinition extends AllFunctionality {

    private final Base base;
    private String firstResultTitle;

    public SearchStepDefinition(Base base) {
        this.base = base;
    }

    @Given("user is ready on homepage for search module")
    public void user_is_ready_on_homepage_for_search_module() {
        Assert.assertTrue(
            Pages.get().shp.isSearchTriggerDisplayed(),
            "Search bar not visible"
        );
    }

    @Then("search bar should be visible for search module")
    public void search_bar_should_be_visible_for_search_module() {
        Assert.assertTrue(
            Pages.get().shp.isSearchTriggerDisplayed(),
            "Search bar is not visible"
        );
    }

    @When("user clicks the search bar for search module")
    public void user_clicks_the_search_bar_for_search_module() {
        Pages.get().shp.clickSearchTrigger();
    }

    @Then("search panel should open for search module")
    public void search_panel_should_open_for_search_module() {
        Assert.assertTrue(
            Pages.get().shp.isSearchPanelDisplayed(),
            "Search panel did not open"
        );
    }

    @When("user enters valid keyword from excel sheet {string} row {int}")
    public void user_enters_valid_keyword_from_excel_sheet_row(String sheet, Integer row) {
        init(sheet);
        String keyword = getData(row, 0);

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new RuntimeException("Keyword is empty in excel");
        }

        Pages.get().shp.enterKeyword(keyword);
    }

    @When("user enters invalid keyword from excel sheet {string} row {int}")
    public void user_enters_invalid_keyword_from_excel_sheet_row(String sheet, Integer row) {
        init(sheet);
        String keyword = getData(row, 2);

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new RuntimeException("Invalid keyword is empty in excel");
        }

        Pages.get().shp.enterKeyword(keyword);
    }

    @When("user enters special keyword from excel sheet {string} row {int}")
    public void user_enters_special_keyword_from_excel_sheet_row(String sheet, Integer row) {
        init(sheet);
        String keyword = getData(row, 3);

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new RuntimeException("Special keyword is empty in excel");
        }

        Pages.get().shp.enterKeyword(keyword);
    }

    @When("user presses Enter in search for search module")
    public void user_presses_enter_in_search_for_search_module() {
        Pages.get().shp.pressEnter();
    }

    @Then("relevant search results should be displayed for search module")
    public void relevant_search_results_should_be_displayed_for_search_module() {
        Assert.assertTrue(
            Pages.get().srp.areResultsDisplayed(),
            "Results not displayed"
        );
    }

    @When("user searches using datatable for search module")
    public void user_searches_using_datatable_for_search_module(DataTable table) {

        List<List<String>> data = table.asLists(String.class);

        for (int i = 1; i < data.size(); i++) {

            String keyword = data.get(i).get(0);

            if (keyword == null || keyword.trim().isEmpty()) {
                throw new RuntimeException("DataTable keyword is empty");
            }

            // ✅ Reset page each time (VERY IMPORTANT)
            Base.getDriver().get("https://www.edureka.co/");


            Pages.get().shp.clickSearchTrigger();
            Pages.get().shp.enterKeyword(keyword);
            Pages.get().shp.pressEnter();

            Assert.assertTrue(
                Pages.get().srp.areResultsDisplayed(),
                "Search failed for keyword: " + keyword
            );
        }
    }

    @Then("datatable search should complete for search module")
    public void datatable_search_should_complete_for_search_module() {
        Assert.assertTrue(true, "Datatable search completed");
    }

    @When("user stores first search result title for search module")
    public void user_stores_first_search_result_title_for_search_module() {
        firstResultTitle = Pages.get().srp.getFirstResultTitle();

        if (firstResultTitle == null || firstResultTitle.trim().isEmpty()) {
            throw new RuntimeException("Stored first result title is empty");
        }
    }

    @When("user clicks first search result for search module")
    public void user_clicks_first_search_result_for_search_module() {
        Pages.get().srp.clickFirstResult();
    }

    @Then("opened course page title should match stored result title for search module")
    public void opened_course_page_title_should_match_stored_result_title_for_search_module() {

        String pageTitle = Base.getDriver().getTitle().toLowerCase();

        Assert.assertTrue(
            pageTitle.contains(firstResultTitle.toLowerCase())
                || Base.getDriver().getCurrentUrl().contains("course"),
            "Opened page title does not match stored result title"
        );

    }

    @Then("default search page should open for search module")
    public void default_search_page_should_open_for_search_module() {
        Assert.assertTrue(
        		
            Base.getDriver().getCurrentUrl().contains("search"),
            "Default search page did not open"
        );

    }

    @Then("system should not crash for search module")
    public void system_should_not_crash_for_search_module() {

        Assert.assertNotNull(
            Base.getDriver().getTitle(),
            "System crashed or title is null"
        );

    }

    @Then("callback form should be displayed for search module")
    public void callback_form_should_be_displayed_for_search_module() {
        Assert.assertTrue(
            Pages.get().srp.isCallbackFormDisplayed(),
            "Callback form is not displayed"
        );
    }

    // ================= CALLBACK PAGE =================

    @Given("user is on no-results callback form page using excel sheet {string} row {int} for search module")
    public void user_is_on_no_results_callback_form_page_using_excel_sheet_row_for_search_module(
            String sheetName, Integer rowNum) {

        initPropertiesUtility("./src/main/resources/edureka.properties");
        base.getDriver().get(getPropertyData("url"));

        // Pages.get().loadAllPages(base.getDriver());

        init(sheetName);
        String invalidKeyword = getData(rowNum, 2);

        if (invalidKeyword == null || invalidKeyword.trim().isEmpty()) {
            throw new RuntimeException("Excel invalidKeyword is NULL or EMPTY");
        }

        Pages.get().shp.clickSearchTrigger();
        Pages.get().shp.enterKeyword(invalidKeyword);
        Pages.get().shp.pressEnter();

        Assert.assertTrue(
                Pages.get().srp.isCallbackFormDisplayed(),
                "No-results callback form page not reached");
    }

    // ================= MOBILE =================


    @When("user enters valid mobile number from excel sheet {string} row {int} for search module")
    public void user_enters_valid_mobile_number_from_excel_sheet_row_for_search_module(
            String sheet, Integer row) {
        init(sheet);
        String mobile = getData(row, 4);

        if (mobile == null || mobile.trim().isEmpty()) {
            throw new RuntimeException("Valid mobile number is empty in excel");
        }

        Pages.get().srp.enterMobileNumber(mobile);

    }

    @When("user enters invalid mobile number from excel sheet {string} row {int} for search module")
    public void user_enters_invalid_mobile_number_from_excel_sheet_row_for_search_module(
            String sheet, Integer row) {
        init(sheet);
        String mobile = getData(row, 5);

        if (mobile == null || mobile.trim().isEmpty()) {
            throw new RuntimeException("Invalid mobile number is empty in excel");
        }
        Pages.get().srp.enterMobileNumber(mobile);

    }

    @Then("system should accept valid 10 digit mobile number for search module")
    public void system_should_accept_valid_10_digit_mobile_number_for_search_module() {
        Assert.assertEquals(

            Pages.get().srp.getEnteredMobileNumber().length(),
            10,
            "Valid mobile number was not accepted properly"
        );

    }

    @Then("system should not accept more than 10 digits for search module")
    public void system_should_not_accept_more_than_10_digits_for_search_module() {
        Assert.assertTrue(
            Pages.get().srp.getEnteredMobileNumber().length() <= 10,
            "System accepted more than 10 digits"
        );
    }

    @When("user selects {string} from popular searches")
    public void user_selects_from_popular_searches(String keyword) {
        Pages.get().shp.clickPopularSearchByText(keyword);
    }

    @Then("user should be navigated to search results page")
    public void user_should_be_navigated_to_search_results_page() {
        String url = Base.getDriver().getCurrentUrl();

        Assert.assertTrue(
            url.contains("/search"),
            "User not navigated to search results page"
        );
    }

    @Then("search results should match selected keyword {string}")
    public void search_results_should_match_selected_keyword(String keyword) {
        String url = Base.getDriver().getCurrentUrl().toLowerCase();

        Assert.assertTrue(
            url.contains(keyword.toLowerCase().replace(" ", "-"))
                || url.contains(keyword.toLowerCase()),
            "Keyword not matching in URL"
        );

        Assert.assertTrue(
            Pages.get().srp.areResultsDisplayed(),
            "Search results not displayed"
        );
    }

    @When("user selects {string} from popular categories")
    public void user_selects_from_popular_categories(String category) {
        Pages.get().shp.clickCategoryByText(category);
    }

    @Then("user should be navigated to category page for {string}")
    public void user_should_be_navigated_to_category_page_for(String category) {
        String url = Base.getDriver().getCurrentUrl().toLowerCase();
        String formatted = category.toLowerCase()
                                   .replace(" & ", " ")
                                   .replace("&", "")
                                   .replace(" ", "-")
                                   .trim();

        Assert.assertTrue(
            url.contains(formatted.split("-")[0]),
            "Navigation to category page failed"
        );

        Assert.assertTrue(
            Pages.get().srp.getCategoryHeading().toLowerCase()
                .contains(category.toLowerCase().split(" ")[0]),
            "Category heading mismatch"
        );
    }

    @When("user clicks on Filter By Job Role dropdown")
    public void user_clicks_on_filter_by_job_role_dropdown() {
        Pages.get().srp.clickJobRoleDropdown();
    }

    @When("user selects {string} job role")
    public void user_selects_job_role(String role) {
        Pages.get().srp.selectJobRole(role);
    }

    @Then("filtered results should be displayed for {string}")
    public void filtered_results_should_be_displayed_for(String role) {
        Assert.assertTrue(
            Pages.get().srp.areResultsDisplayed(),
            "Filtered results not displayed"
        );

        Assert.assertTrue(
            Pages.get().srp.isJobRoleSelected(role),
            "Filter not applied correctly"
        );

    }
}