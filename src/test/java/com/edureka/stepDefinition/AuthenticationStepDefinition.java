package com.edureka.stepDefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.ExtentReportManager;
import com.edureka.utility.Pages;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.pages.LoginPage;
import com.edureka.pages.SignUpPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AuthenticationStepDefinition extends AllFunctionality {

    private Base base;

    private SignUpPage signupPage;
    private LoginPage loginPage;
	

    public AuthenticationStepDefinition(Base base) {
        this.base = base;
        
    }

    // ---------------- SIGNUP ----------------

    @Given("User is in signup page")
    public void user_is_in_signup_page() {
        signupPage = Pages.get().signUpPage;
        signupPage.openSignupPage();
        
    }

    @When("User navigates to signup page")
    public void user_navigates_to_signup_page() {
        signupPage = Pages.get().signUpPage;
        signupPage.openSignupPage();
    }

    @And("User enters signup details")
    public void user_enters_signup_details(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps();

        String email = data.get(0).get("email");
        String number = data.get(0).get("number");

        signupPage.enterEmail(email);
        signupPage.enterNumber(number);
        
    }

    @And("User clicks on signup button")
    public void user_clicks_on_signup_button() {
        signupPage.clickSignup();
        
    }

    @Then("Account should be created successfully")
    public void account_should_be_created_successfully() {
        System.out.println("Signup completed successfully");
        
    }
    
    @When("User enters password in login form")
    public void user_enters_password_in_login_form() {

        loginPage = Pages.get().loginPage;

        init("AuthData");
        String password = getData(1, 1);

        loginPage.enterPassword(password);
        
    }
    
    @And("User clicks on show password icon")
    public void user_clicks_on_show_password_icon() {
        loginPage.clickShowIcon();  
    }

    @Then("Password should be visible")
    public void password_should_be_visible() {
        Assert.assertEquals(loginPage.getPasswordFieldType(), "text");
        
    }

    // ---------------- LOGIN ----------------

    @Given("User is on login page")
    public void user_is_on_login_page() {
        loginPage = Pages.get().loginPage;
        loginPage.openLoginPopup();
        
        
    }

    @When("User enters login credentials from Excel")
    public void user_enters_login_credentials_from_excel() {

        init("AuthData");

        String email = getData(1, 0);
        String password = getData(1, 1);
      

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        
    }

    @Then("User should be redirected to dashboard")
    public void user_redirected_dashboard() {
        Assert.assertFalse(base.getDriver().getCurrentUrl().contains("login"));
        
    }
}