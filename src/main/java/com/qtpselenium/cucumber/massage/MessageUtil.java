package com.qtpselenium.cucumber.massage;

public class MessageUtil {
	private String message;
	//Constructor
	//@ param m essage to be printed
	public MessageUtil(String message){
	this.message = message;
	}
	// prints the m essage
	public String printMessage(){
	System .out.println(message);
	return message;
	}
}
