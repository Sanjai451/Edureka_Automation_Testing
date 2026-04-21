package com.edureka.stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

public class MyWallet extends AllFunctionality{

    private Base base;

    public MyWallet(Base base) {
        this.base = base;
    }

    // CLICK MY WALLET
    @Given("user clicks on My Wallet")
    public void user_clicks_on_my_wallet() {
        Pages.get().myProfile.clickMyWallet();
    }

    // SECTION VISIBILITY

    @Then("account balance section should be displayed")
    public void account_balance_section_should_be_displayed() {
        Assert.assertTrue(
                Pages.get().walletPage.isAccountBalanceDisplayed(),
                "Account Balance section not visible"
        );
    }

    @Then("promotional credits section should be displayed")
    public void promotional_credits_section_should_be_displayed() {
        Assert.assertTrue(
                Pages.get().walletPage.getPromotionalCreditsAmount().isDisplayed(),
                "Promotional credits section not visible"
        );
    }

    @Then("referral credits section should be displayed")
    public void referral_credits_section_should_be_displayed() {
        Assert.assertTrue(
                Pages.get().walletPage.getReferralCreditsAmount().isDisplayed(),
                "Referral credits section not visible"
        );
    }

    // ACCOUNT BALANCE

    @Then("account balance amount should be displayed")
    public void account_balance_amount_should_be_displayed() {
        String balance = Pages.get().walletPage.getAccountBalance();
        Assert.assertFalse(balance.isEmpty(), "Account balance is empty");
    }

    @Then("account balance should be in valid format")
    public void account_balance_should_be_in_valid_format() {
        String balance = Pages.get().walletPage.getAccountBalance();

        Assert.assertTrue(
                balance.matches(".*\\d+.*"),
                "Invalid account balance format"
        );
    }

    // PROMOTIONAL CREDITS

    @Then("promotional credits amount should be displayed")
    public void promotional_credits_amount_should_be_displayed() {
        String promo = Pages.get().walletPage.getPromotionalCredits();
        Assert.assertFalse(promo.isEmpty(), "Promotional credits empty");
    }

    @Then("promotional credits value should be valid")
    public void promotional_credits_value_should_be_valid() {
        String promo = Pages.get().walletPage.getPromotionalCredits();

        Assert.assertTrue(
                promo.matches(".*\\d+.*"),
                "Invalid promotional credits value"
        );
    }

    // REFERRAL CREDITS

    @Then("referral credits amount should be displayed")
    public void referral_credits_amount_should_be_displayed() {
        String ref = Pages.get().walletPage.getReferralCredits();
        Assert.assertFalse(ref.isEmpty(), "Referral credits empty");
    }

    @Then("referral credits value should be valid")
    public void referral_credits_value_should_be_valid() {
    	String ref = Pages.get().walletPage.getReferralCredits();

    	System.out.println("ref : '" + ref + "'");

    	// Remove currency symbols, spaces, commas
    	String cleanedRef = ref.replaceAll("[^0-9.]", "");

    	Assert.assertTrue(
    	        !cleanedRef.isEmpty(),
    	        "Referral credits value is empty"
    	);

    	double value = Double.parseDouble(cleanedRef);

    	Assert.assertTrue(
    	        value >= 0,
    	        "Invalid referral credits value"
    	);
    }
}