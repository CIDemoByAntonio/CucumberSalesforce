package com.qtpselenium.cucumber.message.test;

import org.junit.Assert;

import com.qtpselenium.cucumber.massage.MessageUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class TestPrintMessage {
	MessageUtil messageUtil;
	@Given ("^I type a \"([^\"]*)\"$")
	public void i_type_(String message){
		messageUtil = new MessageUtil(message);
	}
	@Then ("^The \"([^\"]*)\" should show on the screen$")
	public void the_message_is(String message){
		Assert.assertEquals(message,messageUtil.printMessage());
	}

}
