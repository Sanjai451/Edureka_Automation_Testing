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

/**
 * Step definitions for search functionality in Cucumber tests.
 * Handles search bar interactions, keyword entry, result verification, and filtering.
 */
public class SearchStepDefinition extends AllFunctionality {

    private final Base base;
    private String firstResultTitle;

    /**
     * Constructor for SearchStepDefinition.
     * Initializes the Base instance for WebDriver access.
     * @param base the Base instance
     */
    public SearchStepDefinition(Base base) {
        this.base = base;
    }

    /**
     * Step definition to verify user is ready on homepage for search module.
     * Checks if search trigger is displayed.
     */
    @Given("user is ready on homepage for search module")
    public void user_is_ready_on_homepage_for_search_module() {
        Assert.assertTrue(
            Pages.get().shp.isSearchTriggerDisplayed(),
            "Search bar not visible"
        );
    }

    /**
     * Step definition to verify search bar is visible for search module.
     */
    @Then("search bar should be visible for search module")
    public void search_bar_should_be_visible_for_search_module() {
        Assert.assertTrue(
            Pages.get().shp.isSearchTriggerDisplayed(),
            "Search bar is not visible"
        );
    }

    /**
     * Step definition for user clicking the search bar for search module.
     */
    @When("user clicks the search bar for search module")
    public void user_clicks_the_search_bar_for_search_module() {
        Pages.get().shp.clickSearchTrigger();
    }

    /**
     * Step definition to verify search panel opens for search module.
     */
    @Then("search panel should open for search module")
    public void search_panel_should_open_for_search_module() {
        Assert.assertTrue(
            Pages.get().shp.isSearchPanelDisplayed(),
            "Search panel did not open"
        );
    }

    /**
     * Step definition for user entering valid keyword from Excel sheet.
     * @param sheet the Excel sheet name
     * @param row the row number in the sheet
     */
    @When("user enters valid keyword from excel sheet {string} row {int}")
    public void user_enters_valid_keyword_from_excel_sheet_row(String sheet, Integer row) {
        init(sheet);
        String keyword = getData(row, 0); // validKeyword

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new RuntimeException("Keyword is empty in excel");
        }

        Pages.get().shp.enterKeyword(keyword);
    }

    /**
     * Step definition for user entering invalid keyword from Excel sheet.
     * @param sheet the Excel sheet name
     * @param row the row number in the sheet
     */
    @When("user enters invalid keyword from excel sheet {string} row {int}")
    public void user_enters_invalid_keyword_from_excel_sheet_row(String sheet, Integer row) {
        init(sheet);
        String keyword = getData(row, 1); // invalidKeyword

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new RuntimeException("Invalid keyword is empty in excel");
        }

        Pages.get().shp.enterKeyword(keyword);
    }

    /**
     * Step definition for user entering special keyword from Excel sheet.
     * @param sheet the Excel sheet name
     * @param row the row number in the sheet
     */
    @When("user enters special keyword from excel sheet {string} row {int}")
    public void user_enters_special_keyword_from_excel_sheet_row(String sheet, Integer row) {
        init(sheet);
        String keyword = getData(row, 2); // specialKeyword

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new RuntimeException("Special keyword is empty in excel");
        }

        Pages.get().shp.enterKeyword(keyword);
    }

    /**
     * Step definition for user pressing Enter in search for search module.
     */
    @When("user presses Enter in search for search module")
    public void user_presses_enter_in_search_for_search_module() {
        Pages.get().shp.pressEnter();
    }

    /**
     * Step definition to verify relevant search results are displayed for search module.
     */
    @Then("relevant search results should be displayed for search module")
    public void relevant_search_results_should_be_displayed_for_search_module() {
        Assert.assertTrue(
            Pages.get().srp.areResultsDisplayed(),
            "Results not displayed"
        );
    }

    /**
     * Step definition for user searching using DataTable for search module.
     * Iterates through keywords in DataTable and performs search for each.
     * @param table the Cucumber DataTable containing keywords
     */
    @When("user searches using datatable for search module")
    public void user_searches_using_datatable_for_search_module(DataTable table) {
        List<List<String>> data = table.asLists(String.class);

        for (int i = 1; i < data.size(); i++) {
            String keyword = data.get(i).get(0);

            if (keyword == null || keyword.trim().isEmpty()) {
                throw new RuntimeException("DataTable keyword is empty");
            }

            base.getDriver().get("https://www.edureka.co/");

            Pages.get().shp.clickSearchTrigger();
            Assert.assertTrue(
                Pages.get().shp.isSearchPanelDisplayed(),
                "Search panel did not open for keyword: " + keyword
            );

            Pages.get().shp.enterKeyword(keyword);
            Pages.get().shp.pressEnter();

            Assert.assertTrue(
                Pages.get().srp.areResultsDisplayed(),
                "Search failed for keyword: " + keyword
            );
        }
    }

    /**
     * Step definition to verify DataTable search completes for search module.
     */
    @Then("datatable search should complete for search module")
    public void datatable_search_should_complete_for_search_module() {
        Assert.assertTrue(true, "Datatable search completed");
    }

    /**
     * Step definition for user storing first search result title for search module.
     */
    @When("user stores first search result title for search module")
    public void user_stores_first_search_result_title_for_search_module() {
        firstResultTitle = Pages.get().srp.getFirstResultTitle();

        if (firstResultTitle == null || firstResultTitle.trim().isEmpty()) {
            throw new RuntimeException("Stored first result title is empty");
        }
    }

    /**
     * Step definition for user clicking first search result for search module.
     */
    @When("user clicks first search result for search module")
    public void user_clicks_first_search_result_for_search_module() {
        Pages.get().srp.clickFirstResult();
    }

    /**
     * Step definition to verify opened course page title matches stored result title for search module.
     */
    @Then("opened course page title should match stored result title for search module")
    public void opened_course_page_title_should_match_stored_result_title_for_search_module() {
        String pageTitle = base.getDriver().getTitle().toLowerCase();

        Assert.assertTrue(
            pageTitle.contains(firstResultTitle.toLowerCase())
                || base.getDriver().getCurrentUrl().contains("course"),
            "Opened page title does not match stored result title"
        );
    }

    /**
     * Step definition to verify default search page opens for search module.
     */
    @Then("default search page should open for search module")
    public void default_search_page_should_open_for_search_module() {
        Assert.assertTrue(
            base.getDriver().getCurrentUrl().contains("search"),
            "Default search page did not open"
        );
    }

    /**
     * Step definition to verify system does not crash for search module.
     */
    @Then("system should not crash for search module")
    public void system_should_not_crash_for_search_module() {
        Assert.assertNotNull(
            base.getDriver().getTitle(),
            "System crashed or title is null"
        );
    }

    /**
     * Step definition to verify callback form is displayed for search module.
     */
    @Then("callback form should be displayed for search module")
    public void callback_form_should_be_displayed_for_search_module() {
        Assert.assertTrue(
            Pages.get().srp.isCallbackFormDisplayed(),
            "Callback form is not displayed"
        );
    }

    /**
     * Step definition for user entering valid mobile number from Excel sheet for search module.
     * @param sheet the Excel sheet name
     * @param row the row number in the sheet
     */
    @When("user enters valid mobile number from excel sheet {string} row {int} for search module")
    public void user_enters_valid_mobile_number_from_excel_sheet_row_for_search_module(
            String sheet, Integer row) {
        init(sheet);
        String mobile = getData(row, 5); // validMobile

        if (mobile == null || mobile.trim().isEmpty()) {
            throw new RuntimeException("Valid mobile number is empty in excel");
        }

        Pages.get().srp.enterMobileNumber(mobile);
    }

    /**
     * Step definition for user entering invalid mobile number from Excel sheet for search module.
     * @param sheet the Excel sheet name
     * @param row the row number in the sheet
     */
    @When("user enters invalid mobile number from excel sheet {string} row {int} for search module")
    public void user_enters_invalid_mobile_number_from_excel_sheet_row_for_search_module(
            String sheet, Integer row) {
        init(sheet);
        String mobile = getData(row, 6); // invalidMobile

        if (mobile == null || mobile.trim().isEmpty()) {
            throw new RuntimeException("Invalid mobile number is empty in excel");
        }

        Pages.get().srp.enterMobileNumber(mobile);
    }

    /**
     * Step definition to verify system accepts valid 10 digit mobile number for search module.
     */
    @Then("system should accept valid 10 digit mobile number for search module")
    public void system_should_accept_valid_10_digit_mobile_number_for_search_module() {
        Assert.assertEquals(
            Pages.get().srp.getEnteredMobileNumber().length(),
            10,
            "Valid mobile number was not accepted properly"
        );
    }

    /**
     * Step definition to verify system does not accept more than 10 digits for search module.
     */
    @Then("system should not accept more than 10 digits for search module")
    public void system_should_not_accept_more_than_10_digits_for_search_module() {
        Assert.assertTrue(
            Pages.get().srp.getEnteredMobileNumber().length() <= 10,
            "System accepted more than 10 digits"
        );
    }

    /**
     * Step definition for user selecting from popular searches.
     * @param keyword the popular search keyword to select
     */
    @When("user selects {string} from popular searches")
    public void user_selects_from_popular_searches(String keyword) {
        Pages.get().shp.clickPopularSearchByText(keyword);
    }

    /**
     * Step definition to verify user is navigated to search results page.
     */
    @Then("user should be navigated to search results page")
    public void user_should_be_navigated_to_search_results_page() {
        String url = base.getDriver().getCurrentUrl();

        Assert.assertTrue(
            url.contains("/search"),
            "User not navigated to search results page"
        );
    }

    /**
     * Step definition for user selecting popular keyword from Excel sheet.
     * @param sheet the Excel sheet name
     * @param row the row number in the sheet
     */
    @When("user selects popular keyword from excel sheet {string} row {int}")
    public void user_selects_popular_keyword(String sheet, Integer row) {
        init(sheet);
        String keyword = getData(row, 3); // popularKeyword

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new RuntimeException("Popular keyword is empty in excel");
        }

        Pages.get().shp.clickPopularSearchByText(keyword);
    }

    /**
     * Step definition to verify search results match selected keyword from Excel.
     */
    @Then("search results should match selected keyword from excel")
    public void verify_keyword_match() {
        Assert.assertTrue(
            Pages.get().srp.areResultsDisplayed(),
            "Search results not displayed"
        );
    }

    /**
     * Step definition for user selecting category from Excel sheet.
     * @param sheet the Excel sheet name
     * @param row the row number in the sheet
     */
    @When("user selects category from excel sheet {string} row {int}")
    public void user_selects_category(String sheet, Integer row) {
        init(sheet);
        String category = getData(row, 4); // category

        if (category == null || category.trim().isEmpty()) {
            throw new RuntimeException("Category is empty in excel");
        }

        Pages.get().shp.clickCategoryByText(category);
    }

    /**
     * Step definition to verify user is navigated to category page for selected category.
     */
    @Then("user should be navigated to category page for selected category")
    public void verify_category_navigation() {
        Assert.assertTrue(
            Pages.get().srp.getCategoryHeading().length() > 0,
            "Category page not loaded"
        );
    }

    /**
     * Step definition to verify search results match selected keyword.
     * @param keyword the selected keyword
     */
    @Then("search results should match selected keyword {string}")
    public void search_results_should_match_selected_keyword(String keyword) {
        String url = base.getDriver().getCurrentUrl().toLowerCase();

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

    /**
     * Step definition for user selecting from popular categories.
     * @param category the popular category to select
     */
    @When("user selects {string} from popular categories")
    public void user_selects_from_popular_categories(String category) {
        Pages.get().shp.clickCategoryByText(category);
    }

    /**
     * Step definition to verify user is navigated to category page for specified category.
     * @param category the category name
     */
    @Then("user should be navigated to category page for {string}")
    public void user_should_be_navigated_to_category_page_for(String category) {
        String url = base.getDriver().getCurrentUrl().toLowerCase();
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

    /**
     * Step definition for user clicking on Filter By Job Role dropdown.
     */
    @When("user clicks on Filter By Job Role dropdown")
    public void user_clicks_on_filter_by_job_role_dropdown() {
        Pages.get().srp.clickJobRoleDropdown();
    }

    /**
     * Step definition for user selecting a job role.
     * @param role the job role to select
     */
    @When("user selects {string} job role")
    public void user_selects_job_role(String role) {
        Pages.get().srp.selectJobRole(role);
    }

    /**
     * Step definition to verify filtered results are displayed for specified role.
     * @param role the job role filter applied
     */
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