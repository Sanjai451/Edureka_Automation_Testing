package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.ExtentReportManager;
import com.edureka.utility.Pages;

public class MyWallet extends AllFunctionality {

	private Base base;
	private ExtentTest logs;

	public MyWallet(Base base) {
		this.base = base;
		logs = ExtentReportManager.getTest();
	}

	// CLICK MY WALLET
	@Given("user clicks on My Wallet")
	public void user_clicks_on_my_wallet() {
		Pages.get().myProfile.clickMyWallet();
		logs.log(Status.PASS, "Clicked on My Wallet section");
	}

	// SECTION VISIBILITY

	@Then("account balance section should be displayed")
	public void account_balance_section_should_be_displayed() {
		Assert.assertTrue(Pages.get().walletPage.isAccountBalanceDisplayed(), "Account Balance section not visible");
		logs.log(Status.PASS, "Account Balance section is visible");
	}

	@Then("promotional credits section should be displayed")
	public void promotional_credits_section_should_be_displayed() {
		Assert.assertTrue(Pages.get().walletPage.getPromotionalCreditsAmount().isDisplayed(),
				"Promotional credits section not visible");
		logs.log(Status.PASS, "Promotional Credits section is visible");
	}

	@Then("referral credits section should be displayed")
	public void referral_credits_section_should_be_displayed() {
		Assert.assertTrue(Pages.get().walletPage.getReferralCreditsAmount().isDisplayed(),
				"Referral credits section not visible");
		logs.log(Status.PASS, "Referral Credits section is visible");
	}

	// ACCOUNT BALANCE

	@Then("account balance amount should be displayed")
	public void account_balance_amount_should_be_displayed() {
		String balance = Pages.get().walletPage.getAccountBalance();

		logs.log(Status.PASS, "Captured Account Balance: " + balance);

		Assert.assertFalse(balance.isEmpty(), "Account balance is empty");

		logs.log(Status.PASS, "Account balance is displayed");
	}

	@Then("account balance should be in valid format")
	public void account_balance_should_be_in_valid_format() {
		String balance = Pages.get().walletPage.getAccountBalance();

		logs.log(Status.PASS, "Validating Account Balance format: " + balance);

		Assert.assertTrue(balance.matches(".*\\d+.*"), "Invalid account balance format");

		logs.log(Status.PASS, "Account balance format is valid");
	}

	// PROMOTIONAL CREDITS

	@Then("promotional credits amount should be displayed")
	public void promotional_credits_amount_should_be_displayed() {

		String promo = Pages.get().walletPage.getPromotionalCredits();

		logs.log(Status.PASS, "Captured Promotional Credits: " + promo);

		Assert.assertFalse(promo.isEmpty(), "Promotional credits empty");

		logs.log(Status.PASS, "Promotional credits are displayed");
	}

	@Then("promotional credits value should be valid")
	public void promotional_credits_value_should_be_valid() {

		String promo = Pages.get().walletPage.getPromotionalCredits();

		logs.log(Status.PASS, "Validating Promotional Credits value: " + promo);

		Assert.assertTrue(promo.matches(".*\\d+.*"), "Invalid promotional credits value");

		logs.log(Status.PASS, "Promotional credits value is valid");
	}

	// REFERRAL CREDITS

	@Then("referral credits amount should be displayed")
	public void referral_credits_amount_should_be_displayed() {

		String ref = Pages.get().walletPage.getReferralCredits();

		logs.log(Status.PASS, "Captured Referral Credits: " + ref);

		Assert.assertFalse(ref.isEmpty(), "Referral credits empty");

		logs.log(Status.PASS, "Referral credits are displayed");
	}

	@Then("referral credits value should be valid")
	public void referral_credits_value_should_be_valid() {

		String ref = Pages.get().walletPage.getReferralCredits();

		logs.log(Status.PASS, "Validating Referral Credits value: " + ref);

		System.out.println("ref : '" + ref + "'");

		// Clean value
		String cleanedRef = ref.replaceAll("[^0-9.]", "");

		Assert.assertTrue(!cleanedRef.isEmpty(), "Referral credits value is empty");

		double value = Double.parseDouble(cleanedRef);

		Assert.assertTrue(value >= 0, "Invalid referral credits value");

		logs.log(Status.PASS, "Referral credits value is valid: " + value);
	}
}