package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.edureka.pages.LoginPage;
import com.edureka.pages.SignUpPage;


public class Pages {
	
	public static LoginPage loginPage;
	public static SignUpPage singupPage;
	
	
	public static void loadAllPages(WebDriver driver) {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		singupPage=PageFactory.initElements(driver, SignUpPage.class);
		
	}
}
