package com.edureka.stepDefinition;


import com.edureka.utility.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageTest {
	private Base base;
	
	public HomePageTest(Base base) {
		this.base = base;
	}
	
	@Given("goto home page")
	public void goto_home_page() {
		System.out.println("Done Running");
	}

	
}
