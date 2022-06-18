package com.sevenrmart.qa.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenrmart.qa.constants.Constants;

public class WaitUtil {
	
	 WebDriver driver;
	private WebDriverWait wait;

	 public WaitUtil(WebDriver driver)
		{
			this.driver = driver;
		}
	 
	 public void waitforElementVisible(WebElement element) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.visibilityOf(element));
		 
	 }

	public void implicitWait() {
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}

	public void waitforElementClick(WebElement element) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

}
