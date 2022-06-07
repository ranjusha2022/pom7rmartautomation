package com.sevenrmart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmart.qa.utilities.ElementUtil;
import com.sevenrmart.qa.utilities.WaitUtil;

public class LoginPage  {

	public ElementUtil elementutil;
	public WaitUtil waitutilpage;
	WebDriver driver;
	
	@FindBy(xpath = "//b[text() = \"7rmart supermarket\"]")
	WebElement loginText;
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement passsword;
	
	@FindBy(xpath = "//button[text()=\"Sign In\"]")
	WebElement signinbutton;
	
	@FindBy(xpath = "//img[@src =\"https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png\" ]")
	WebElement adminlogo;

	public LoginPage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutil = new ElementUtil(driver);
		waitutilpage = new WaitUtil(driver);
		
	}
	
	public void loginAction(String uname,String pword)
	{
		elementutil.sendKeys(username, uname);
		elementutil.sendKeys(passsword, pword);
		waitutilpage.waitforElementClick(signinbutton);
		elementutil.click(signinbutton);
	}
	
	public boolean homePageElements() {
		boolean a = elementutil.enablecheck(adminlogo);
		return a;
	}
	
	public String loginPagetext() {
		return loginText.getText();
		
	}
	
}
