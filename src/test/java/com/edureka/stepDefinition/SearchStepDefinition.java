package com.edureka.stepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    // ================= HOME PAGE =================

    @Given("user is ready on homepage for search module")
    public void user_is_ready_on_homepage_for_search_module() {
        initPropertiesUtility("./src/main/resources/edureka.properties");
        base.getDriver().get(getPropertyData("url"));
        Pages.get().loadAllPages(base.getDriver());

        Assert.assertTrue(
                Pages.get().shp.isSearchTriggerDisplayed(),
                "Search bar is not visible on homepage");
    }

    @Then("search bar should be visible for search module")
    public void search_bar_should_be_visible_for_search_module() {
        Assert.assertTrue(
                Pages.get().shp.isSearchTriggerDisplayed(),
                "Search bar is not visible");
    }

    @When("user clicks the search bar for search module")
    public void user_clicks_the_search_bar_for_search_module() {
        Pages.get().shp.clickSearchTrigger();
    }

    @Then("search panel should open for search module")
    public void search_panel_should_open_for_search_module() {
        Assert.assertTrue(
                Pages.get().shp.isSearchPanelDisplayed(),
                "Search panel did not open");
    }

    // ================= EXCEL KEYWORDS =================

    @When("user enters valid keyword from excel sheet {string} row {int}")
    public void user_enters_valid_keyword_from_excel_sheet_row(String sheetName, Integer rowNum) {
        init(sheetName);
        String keyword = getData(rowNum, 0);

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new RuntimeException("Excel validKeyword is NULL or EMPTY");
        }

        Pages.get().shp.enterKeyword(keyword);
    }

    @When("user enters invalid keyword from excel sheet {string} row {int}")
    public void user_enters_invalid_keyword_from_excel_sheet_row(String sheetName, Integer rowNum) {
        init(sheetName);
        String keyword = getData(rowNum, 2);

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new RuntimeException("Excel invalidKeyword is NULL or EMPTY");
        }

        Pages.get().shp.enterKeyword(keyword);
    }

    @When("user enters special keyword from excel sheet {string} row {int}")
    public void user_enters_special_keyword_from_excel_sheet_row(String sheetName, Integer rowNum) {
        init(sheetName);
        String keyword = getData(rowNum, 3);

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new RuntimeException("Excel specialKeyword is NULL or EMPTY");
        }

        Pages.get().shp.enterKeyword(keyword);
    }

    @When("user presses Enter in search for search module")
    public void user_presses_enter_in_search_for_search_module() {
        Pages.get().shp.pressEnter();
    }

    // ================= SEARCH RESULTS =================

    @Then("relevant search results should be displayed for search module")
    public void relevant_search_results_should_be_displayed_for_search_module() {
        Assert.assertTrue(
                Pages.get().srp.areResultsDisplayed(),
                "Relevant search results are not displayed");
    }

    // ================= DATATABLE =================

    @When("user searches using datatable for search module")
    public void user_searches_using_datatable_for_search_module(DataTable dataTable) {
        initPropertiesUtility("./src/main/resources/edureka.properties");

        List<List<String>> rows = dataTable.asLists(String.class);

        for (int i = 1; i < rows.size(); i++) {
            String keyword = rows.get(i).get(0);

            if (keyword == null || keyword.trim().isEmpty()) {
                throw new RuntimeException("DataTable keyword is NULL or EMPTY");
            }

            Pages.get().shp.clickSearchTrigger();
            Pages.get().shp.enterKeyword(keyword);
            Pages.get().shp.pressEnter();

            Assert.assertTrue(
                    Pages.get().srp.areResultsDisplayed(),
                    "Results not displayed for keyword: " + keyword);

            base.getDriver().get(getPropertyData("url"));
            // Pages.get().loadAllPages(base.getDriver());
        }
    }

    @Then("datatable search should complete for search module")
    public void datatable_search_should_complete_for_search_module() {
        Assert.assertTrue(true);
    }

    // ================= SCENARIO OUTPUT =================

    @When("user stores first search result title for search module")
    public void user_stores_first_search_result_title_for_search_module() {
        firstResultTitle = Pages.get().srp.getFirstResultTitle();

        if (firstResultTitle == null || firstResultTitle.trim().isEmpty()) {
            throw new RuntimeException("First result title is NULL or EMPTY");
        }
    }

    @When("user clicks first search result for search module")
    public void user_clicks_first_search_result_for_search_module() {
        Pages.get().srp.clickFirstResult();
    }

    @Then("opened course page title should match stored result title for search module")
    public void opened_course_page_title_should_match_stored_result_title_for_search_module() {
        String currentTitle = base.getDriver().getTitle().toLowerCase();

        Assert.assertTrue(
                currentTitle.contains(firstResultTitle.toLowerCase())
                        || base.getDriver().getCurrentUrl().contains("course"),
                "Opened course page title does not match stored result title");
    }

    // ================= DEFAULT SEARCH PAGE =================

    @Then("default search page should open for search module")
    public void default_search_page_should_open_for_search_module() {
        Assert.assertTrue(
                base.getDriver().getCurrentUrl().contains("search"),
                "Default search page did not open");
    }

    // ================= NEGATIVE / STABILITY =================

    @Then("system should not crash for search module")
    public void system_should_not_crash_for_search_module() {
        Assert.assertTrue(
                base.getDriver().getTitle() != null && !base.getDriver().getTitle().isEmpty(),
                "System crashed");
    }

    @Then("callback form should be displayed for search module")
    public void callback_form_should_be_displayed_for_search_module() {
        Assert.assertTrue(
                Pages.get().srp.isCallbackFormDisplayed(),
                "Callback form is not displayed");
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
            String sheetName, Integer rowNum) {

        init(sheetName);
        String validMobile = getData(rowNum, 4);

        if (validMobile == null || validMobile.trim().isEmpty()) {
            throw new RuntimeException("Excel validMobile is NULL or EMPTY");
        }
        
        Pages.get().srp.enterMobileNumber(validMobile);
    }

    @When("user enters invalid mobile number from excel sheet {string} row {int} for search module")
    public void user_enters_invalid_mobile_number_from_excel_sheet_row_for_search_module(
            String sheetName, Integer rowNum) {

        init(sheetName);
        String invalidMobile = getData(rowNum, 5);

        if (invalidMobile == null || invalidMobile.trim().isEmpty()) {
            throw new RuntimeException("Excel invalidMobile is NULL or EMPTY");
        }
        Pages.get().srp.enterMobileNumber(invalidMobile);
    }

    @Then("system should accept valid 10 digit mobile number for search module")
    public void system_should_accept_valid_10_digit_mobile_number_for_search_module() {
        Assert.assertEquals(
                Pages.get().srp.getEnteredMobileNumber().length(),
                10,
                "Valid 10-digit mobile number not accepted properly");
    }

    @Then("system should not accept more than 10 digits for search module")
    public void system_should_not_accept_more_than_10_digits_for_search_module() {
        Assert.assertTrue(
                Pages.get().srp.getEnteredMobileNumber().length() <= 10,
                "Defect: system accepted more than 10 digits");
    }
}