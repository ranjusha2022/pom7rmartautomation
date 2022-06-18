package com.sevenrmart.qa.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;

	}

	public void sendKeys(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void click(WebElement element) {
		element.click();
	}

	public void acceptAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void dismissAlert() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	public String getAlertText() {
		Alert al = driver.switchTo().alert();
		String t = al.getText();
		return t;
	}

	public boolean enablecheck(WebElement element) {
		element.isDisplayed();
		return true;
	}
}
