package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Base {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	 public static void initDriver() {
	    	EdgeOptions options = new EdgeOptions();
			options.addArguments("--inprivate");
			options.addArguments("--disable-notifications");
	        driver.set(new EdgeDriver(options));
	    }

	    public static void quitDriver() {
	        driver.get().quit();
	        driver.remove();
	    }

	    public static WebDriver getDriver() {
	        return driver.get();
	    }

    
}