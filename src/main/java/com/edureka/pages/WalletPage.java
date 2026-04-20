package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WalletPage {

    // Locators

    @FindBy(xpath = "//h4[contains(text(),'Account Balance')]")
    private WebElement accountBalanceTitle;

    @FindBy(xpath = "//span[contains(@class,'b_amount')]")
    private WebElement accountBalanceAmount;

    @FindBy(xpath = "//p[contains(text(),'Promotional Credits')]/following-sibling::h4")
    private WebElement promotionalCreditsAmount;

    @FindBy(xpath = "//p[contains(text(),'Referral & Refund Credits')]/following-sibling::h4")
    private WebElement referralCreditsAmount;

    // Getters

    public WebElement getAccountBalanceTitle() {
        return accountBalanceTitle;
    }

    public WebElement getAccountBalanceAmount() {
        return accountBalanceAmount;
    }

    public WebElement getPromotionalCreditsAmount() {
        return promotionalCreditsAmount;
    }

    public WebElement getReferralCreditsAmount() {
        return referralCreditsAmount;
    }

    // Business Logic

    public boolean isAccountBalanceDisplayed() {
        return accountBalanceTitle.isDisplayed();
    }

    public String getAccountBalance() {
        return accountBalanceAmount.getText();
    }

    public String getPromotionalCredits() {
        return promotionalCreditsAmount.getText();
    }

    public String getReferralCredits() {
        return referralCreditsAmount.getText();
    }

    // Validation

    public boolean verifyWalletBalanceVisible() {
        return isAccountBalanceDisplayed()
                && accountBalanceAmount.isDisplayed()
                && promotionalCreditsAmount.isDisplayed()
                && referralCreditsAmount.isDisplayed();
    }
}