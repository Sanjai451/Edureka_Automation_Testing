package com.edureka.utility;

import org.openqa.selenium.WebDriver;

public class Base {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public void setDriver(WebDriver driver) {
        tlDriver.set(driver);
    }

    public WebDriver getDriver() {
        return tlDriver.get();
    }

    public void unload() {
        tlDriver.remove();
    }
}