package com.qtpselenium.app.salesforce.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebConnector {
	Properties OR=null;
	Properties CONFIG=null;
	WebDriver driver = null;
	
	public WebConnector(){
		if (OR==null){
			try {
				OR = new Properties();
				OR.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\qtpselenium\\app\\salesforce\\config\\OR.properties"));
				CONFIG = new Properties();
				CONFIG.load(new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\java\\com\\qtpselenium\\app\\salesforce\\config\\PROD.properties"));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void openBrowser(String browser){
		if (CONFIG.getProperty(browser).equals("firefox")){
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void closeBrowser(){
		driver.quit();
	}
	public void navigate(String url){
		driver.navigate().to(CONFIG.getProperty(url));
	}
	public void click(String objectname){
		driver.findElement(By.xpath(OR.getProperty(objectname))).click();
	}
	public void type(String objectname, String text){
		driver.findElement(By.xpath(OR.getProperty(objectname))).sendKeys(text);
	}
	public void select(String objectname, String value){
	
		Select option = new Select(driver.findElement(By.xpath(OR.getProperty(objectname))));
		option.selectByVisibleText(value);
		
	}
	public boolean isElementPresent(String objectname){
		return driver.findElements(By.xpath(OR.getProperty(objectname))).size() > 0;
	}
}
