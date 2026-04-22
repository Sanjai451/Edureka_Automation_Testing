package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Utility class for initializing WebDriver instances for different browsers.
 * This class provides a factory method to create browser-specific WebDriver objects
 * with pre-configured options for private browsing and notification disabling.
 */
public class GetBrowser {
	public static WebDriver getBrowser(String s) {
	    WebDriver driver;

	    switch (s) {
		    case "chrome":
	            ChromeOptions chromeOptions = new ChromeOptions();
	            chromeOptions.addArguments("--incognito");
	            chromeOptions.addArguments("--disable-notifications");
	            driver = new ChromeDriver(chromeOptions);
	            break;
	        case "edge":
	        	EdgeOptions options = new EdgeOptions();
				options.addArguments("--inprivate");
				options.addArguments("--disable-notifications");
	            driver = new EdgeDriver(options);
	            break;
	        case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-private");
                firefoxOptions.addArguments("--disable-notifications");
                driver = new FirefoxDriver(firefoxOptions);
                break;
	        default:
	            driver = null;
	            break;
	    }

	    return driver;
	}
}
