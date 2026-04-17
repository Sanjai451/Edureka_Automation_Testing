package com.edureka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    
    @FindBy(xpath = "//input[@placeholder='Search courses']")
    WebElement homeSearchBar;
    
    @FindBy(xpath = "//span[contains(@class,'user_name')]")
    WebElement profileIcon;

    @FindBy(xpath = "//a[text()='My Profile']")
    WebElement myProfile;

    @FindBy(xpath = "//a[text()='My Orders']")
    WebElement myOrders;

    @FindBy(xpath = "//a[text()='My Wishlist']")
    WebElement myWishlist;

    @FindBy(xpath = "//a[text()='Change Password']")
    WebElement changePassword;
    
    @FindBy(xpath = "//button[.='Resources']")
    WebElement resourceIcon;
    
    @FindBy(css = "[href='/blog']")
    WebElement blogFromNavbar;
    
    @FindBy(css = "[href='/webinars']")
    WebElement webinarFromNavbar;
    
    @FindBy(css = "[href='/community']")
    WebElement communityFromNavbar;
    
    public void clickOnWebinarFromNavbar() {
    	resourceIcon.click();
    	webinarFromNavbar.click();
    }
    
    public void clickOnBlogFromNavbar() {
    	resourceIcon.click();
    	blogFromNavbar.click();
    }
    
    public void clickOnCommunityFromNavbar() {
    	resourceIcon.click();
    	communityFromNavbar.click();
    }

    
    public void clickHomeSearchBar() {
        homeSearchBar.click();
    }

    public void enterKeywordInHomeSearchBar(String value) {
        homeSearchBar.sendKeys(value);
    }
	
	public void openProfileMenu() {
	    profileIcon.click();
	}

	public void clickMyProfile() {
	    myProfile.click();
	}

	public void clickMyOrders() {
	    myOrders.click();
	}

	public void clickMyWishlist() {
	    myWishlist.click();
	}

	public void clickChangePassword() {
	    changePassword.click();
	}

    public void clickOnCategory(WebDriver driver, String value) {
		driver.findElement(By.xpath("//a[.='" +  value + "']")).click();
	}
	
	public void clickOnCourse(WebDriver driver, String value) {
		driver.findElement(By.xpath("//h2[.='" +  value + "']")).click();
	}

}