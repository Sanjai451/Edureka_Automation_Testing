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
    private Pages pages;
    private String firstResultTitle;

    public SearchStepDefinition(Base base) {
        this.base = base;
    }

    @Given("user is ready on homepage for search module")
    public void user_is_ready_on_homepage_for_search_module() {
        initPropertiesUtility("./src/main/resources/edureka.properties");
        String url = getPropertyData("url");

        base.getDriver().get(url);
        pages = new Pages(base.getDriver());

        Assert.assertTrue(
                pages.shp.isSearchTriggerDisplayed(),
                "Search bar not visible");
    }

    @Then("search bar should be visible for search module")
    public void search_bar_should_be_visible_for_search_module() {
        Assert.assertTrue(pages.shp.isSearchTriggerDisplayed());
    }

    @When("user clicks the search bar for search module")
    public void user_clicks_the_search_bar_for_search_module() {
        pages.shp.clickSearchTrigger();
    }

    @Then("search panel should open for search module")
    public void search_panel_should_open_for_search_module() {
        Assert.assertTrue(pages.shp.isSearchPanelDisplayed());
    }

    @When("user enters valid keyword from excel sheet {string} row {int}")
    public void user_enters_valid_keyword_from_excel_sheet_row(String sheet, Integer row) {
        init(sheet);
        String keyword = getData(row, 0);

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new RuntimeException("Keyword EMPTY");
        }

        pages.shp.enterKeyword(keyword);
    }

    @When("user enters invalid keyword from excel sheet {string} row {int}")
    public void user_enters_invalid_keyword_from_excel_sheet_row(String sheet, Integer row) {
        init(sheet);
        pages.shp.enterKeyword(getData(row, 2));
    }

    @When("user enters special keyword from excel sheet {string} row {int}")
    public void user_enters_special_keyword_from_excel_sheet_row(String sheet, Integer row) {
        init(sheet);
        pages.shp.enterKeyword(getData(row, 3));
    }

    @When("user presses Enter in search for search module")
    public void user_presses_enter_in_search_for_search_module() {
        pages.shp.pressEnter();
    }

    @Then("relevant search results should be displayed for search module")
    public void relevant_search_results_should_be_displayed_for_search_module() {
        Assert.assertTrue(
                pages.srp.areResultsDisplayed(base.getDriver()),
                "Results not displayed");
    }

    @When("user searches using datatable for search module")
    public void user_searches_using_datatable_for_search_module(DataTable table) {
        initPropertiesUtility("./src/main/resources/edureka.properties");
        String url = getPropertyData("url");

        List<List<String>> data = table.asLists(String.class);

        for (int i = 1; i < data.size(); i++) {
            String keyword = data.get(i).get(0);

            if (keyword == null || keyword.trim().isEmpty()) {
                throw new RuntimeException("DataTable keyword EMPTY");
            }

            pages.shp.clickSearchTrigger();
            pages.shp.enterKeyword(keyword);
            pages.shp.pressEnter();

            Assert.assertTrue(
                    pages.srp.areResultsDisplayed(base.getDriver()),
                    "Fail for: " + keyword);

            base.getDriver().get(url);
            pages = new Pages(base.getDriver());
        }
    }

    @Then("datatable search should complete for search module")
    public void datatable_search_should_complete_for_search_module() {
        Assert.assertTrue(true);
    }

    @When("user stores first search result title for search module")
    public void user_stores_first_search_result_title_for_search_module() {
        firstResultTitle = pages.srp.getFirstResultTitle();

        if (firstResultTitle == null || firstResultTitle.trim().isEmpty()) {
            throw new RuntimeException("Title EMPTY");
        }
    }

    @When("user clicks first search result for search module")
    public void user_clicks_first_search_result_for_search_module() {
        pages.srp.clickFirstResult();
    }

    @Then("opened course page title should match stored result title for search module")
    public void opened_course_page_title_should_match_stored_result_title_for_search_module() {
        String title = base.getDriver().getTitle().toLowerCase();

        Assert.assertTrue(
                title.contains(firstResultTitle.toLowerCase())
                        || base.getDriver().getCurrentUrl().contains("course"),
                "Mismatch");
    }

    @Then("default search page should open for search module")
    public void default_search_page_should_open_for_search_module() {
        Assert.assertTrue(base.getDriver().getCurrentUrl().contains("search"));
    }

    @Then("system should not crash for search module")
    public void system_should_not_crash_for_search_module() {
        Assert.assertTrue(base.getDriver().getTitle() != null);
    }

    @Then("callback form should be displayed for search module")
    public void callback_form_should_be_displayed_for_search_module() {
        Assert.assertTrue(pages.srp.isCallbackFormDisplayed());
    }

    @Given("user is on no-results callback form page using excel sheet {string} row {int} for search module")
    public void user_is_on_no_results_callback_form_page_using_excel_sheet_row_for_search_module(
            String sheet, Integer row) {

        initPropertiesUtility("./src/main/resources/edureka.properties");
        String url = getPropertyData("url");

        base.getDriver().get(url);
        pages = new Pages(base.getDriver());

        init(sheet);
        String keyword = getData(row, 2);

        pages.shp.clickSearchTrigger();
        pages.shp.enterKeyword(keyword);
        pages.shp.pressEnter();

        Assert.assertTrue(pages.srp.isCallbackFormDisplayed());
    }

    @When("user enters valid mobile number from excel sheet {string} row {int} for search module")
    public void user_enters_valid_mobile_number_from_excel_sheet_row_for_search_module(
            String sheet, Integer row) {
        init(sheet);
        pages.srp.enterMobileNumber(base.getDriver(), getData(row, 4));
    }

    @When("user enters invalid mobile number from excel sheet {string} row {int} for search module")
    public void user_enters_invalid_mobile_number_from_excel_sheet_row_for_search_module(
            String sheet, Integer row) {
        init(sheet);
        pages.srp.enterMobileNumber(base.getDriver(), getData(row, 5));
    }

    @Then("system should accept valid 10 digit mobile number for search module")
    public void system_should_accept_valid_10_digit_mobile_number_for_search_module() {
        Assert.assertEquals(pages.srp.getEnteredMobileNumber().length(), 10);
    }

    @Then("system should not accept more than 10 digits for search module")
    public void system_should_not_accept_more_than_10_digits_for_search_module() {
        Assert.assertTrue(
                pages.srp.getEnteredMobileNumber().length() <= 10,
                "Defect found");
    }
}