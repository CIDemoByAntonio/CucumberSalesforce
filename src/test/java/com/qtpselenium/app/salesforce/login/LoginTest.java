package com.qtpselenium.app.salesforce.login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qtpselenium.app.salesforce.util.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginTest {
	WebDriver driver;
	WebConnector selenium = new WebConnector();
	
	String errorText="Login - Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	@Given ("^I go to \"([^\"]*)\" on \"([^\"]*)\"$")
	public void i_go_to_Salesforce(String url, String browser){
		selenium.openBrowser(browser);
		selenium.navigate(url);
		
	}
	@And ("^I enter my \"([^\"]*)\" as \"([^\"]*)\"$")
	public void i_enter_username(String object, String text){
		System.out.println("Entering in " + object + " as " + text);
		selenium.type(object, text);
	}
	@And ("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void i_enter_password(String object, String text){
		System.out.println("Entering in " + object + " as " + text);
		selenium.type(object, text);
		
	}
	@And ("^I click on \"([^\"]*)\"$")
	public void i_click_on(String object){
		System.out.println("Clicking on " + object);
		selenium.click(object);
		
	}
	@Then ("^login should be \"([^\"]*)\"$")
	public void then_login_should_be(String expectedresult){
		System.out.println(selenium.isElementPresent("loginerror"));
		//Assert.assertTrue(errorText.equals(selenium.isElementPresent("loginerror")));
		selenium.closeBrowser();
	}

}
