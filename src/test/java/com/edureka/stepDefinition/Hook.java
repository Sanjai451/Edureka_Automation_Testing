package com.edureka.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends AllFunctionality {
	
	private Base base;
	
	public Hook(Base base) {
		this.base = base;
	}
	
	@Before
	public void setUp() throws IOException {
		base.driver = new EdgeDriver();
		
		initPropertiesUtility("./src/main/resources/edureka.properties");
		String URL = getPropertyData("url");
//		String USERNAME = getPropertyData("username");
//		String PASSWORD = getPropertyData("password");
		
		setMaximizeBrowser(base.driver);
		implicitlyWait(base.driver, 5);
		
		
		base.driver.get(URL);
		
		Pages.loadAllPages(base.driver);
		
	}
	
	@After
	public void tearDown(){

//		base.driver.quit();
	}
}
