package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

import java.util.List;

import org.testng.Assert;

import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class MyOrderAndInvoices {

    private Base base;

    public MyOrderAndInvoices(Base base) {
        this.base = base;
    }

    // NAVIGATION
    @Given("user clicks on My Orders and Invoices")
    public void user_clicks_on_my_orders_and_invoices() {
        Pages.myProfile.clickMyOrders();
    }

    // NO COURSES MESSAGE

    @Then("no courses message should be displayed")
    public void no_courses_message_should_be_displayed() {
        Assert.assertTrue(
                Pages.ordersPage.isNoCoursesMessageDisplayed(),
                "No courses message not displayed"
        );
    }

    @Then("message should indicate no enrolled courses")
    public void message_should_indicate_no_enrolled_courses() {

        String message = Pages.ordersPage.getNoCoursesMessageText();

        Assert.assertTrue(
                message.toLowerCase().contains("not enrolled"),
                "Incorrect no courses message"
        );
    }

    // CLICK BUTTON

    @When("user clicks Browse All Courses button")
    public void user_clicks_browse_all_courses_button() {
        Pages.ordersPage.clickBrowseCourses();
    }

    // REDIRECTION

    @Then("user validates redirection")
    public void user_validates_redirection(DataTable dataTable) {

        List<List<String>> data = dataTable.asLists();
        String expectedUrlPart = data.get(1).get(0);

        String currentUrl = base.driver.getCurrentUrl();

        System.out.println("Current URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains(expectedUrlPart),
                "Redirection failed. Expected URL to contain: " + expectedUrlPart
        );
    }
}