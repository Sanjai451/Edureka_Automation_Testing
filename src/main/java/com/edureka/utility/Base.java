package com.edureka.utility;

import org.openqa.selenium.WebDriver;

public class Base {


	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


	 public static void initDriver(String broswer) {
			WebDriver browDriver = GetBrowser.getBrowser(broswer);
	        driver.set(browDriver);
	    }

	    public static void quitDriver() {
	    	if (driver.get() != null) {
	            driver.get().quit();
	            driver.remove();
	        }
	    }

	    public static WebDriver getDriver() {
	        return driver.get();
	    }

}
