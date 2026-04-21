package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Base {
	
//	public static WebDriver driver;
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void initDriver() {
    	EdgeOptions options = new EdgeOptions();
		options.addArguments("--inprivate");
		options.addArguments("--disable-notifications");
        driver.set(new EdgeDriver(options));
    
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
	
}
