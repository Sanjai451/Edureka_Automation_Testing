package com.edureka.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends AllFunctionality {

    private Base base;

    public Hook(Base base) {
        this.base = base;
    }

    @Before
    public void setUp() throws IOException {

        initPropertiesUtility("./src/main/resources/edureka.properties");
        String url = getPropertyData("url");
        
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        base.setDriver(driver);

        setMaximizeBrowser(base.getDriver());
        implicitlyWait(base.getDriver(), 5);

        base.getDriver().get(url);
    }

    @After
    public void tearDown() {
        if (base.getDriver() != null) {
            base.getDriver().quit();
            base.unload();
        }
    }
}