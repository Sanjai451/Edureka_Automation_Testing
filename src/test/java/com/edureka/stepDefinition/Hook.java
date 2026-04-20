package com.edureka.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends AllFunctionality {

    private final Base base;

    public Hook(Base base) {
        this.base = base;
    }


    @Before
    public void setUp() throws IOException {
        // Initialise a fresh WebDriver for this thread
        base.initDriver();

        initPropertiesUtility("./src/main/resources/edureka.properties");
        String url = getPropertyData("url");

        setMaximizeBrowser(base.getDriver());
        implicitlyWait(base.getDriver(), 5);

        base.getDriver().get(url);

        // Initialise page objects bound to this thread's driver
        Pages.loadAllPages(base.getDriver());
    }

    @After
    public void tearDown() {
        // Quit the browser and remove the driver from ThreadLocal
        Base.quitDriver();

        // Remove the Pages ThreadLocal to prevent memory leaks
        Pages.cleanUp();
    }
}