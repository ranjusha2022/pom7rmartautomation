package com.sevenrmart.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sevenrmart.qa.constants.Constants;

public class ElementUtil  {
		
	private WebDriver driver;
		
	public ElementUtil (WebDriver driver)
	{
		this.driver = driver;
		
		File src=new File(Constants.propertyConfig_File);

		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		} 
	}
	
	
	static Properties pro = new Properties();

	public String getApplicationUrl() {

		String url=pro.getProperty("baseUrl");		
		return url;			
	}
	

	public String getUserName() {
		
		String username =pro.getProperty("username");		
		return username;	
	}
	
	public String getPassword() {

		String password=pro.getProperty("password");		
		return password;			
	}
	
	public void sendKeys(WebElement element, String value)
	{
		element.clear();
		element.sendKeys(value);
	}
	
	public void click(WebElement element)
	{
		element.click();
	}
	
	public void acceptAlert()
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
	public void dismissAlert()
	{
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}
	
	public String getAlertText()
	{
		Alert al = driver.switchTo().alert();
		String t = al.getText();
		return t;
	}
	
	public static String getPropertyValue(String key)
	{
		String value=pro.get(key).toString();
		return value;
	}


	public boolean enablecheck(WebElement element) {		
		element.isDisplayed();
		return true;
	}
	

}
