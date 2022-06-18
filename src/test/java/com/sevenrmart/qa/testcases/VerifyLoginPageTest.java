package com.sevenrmart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLoginPageTest extends BasePageTest {
	
  @Test(dataProvider = "userData", priority = 1, groups = "smoke")
  public void loginAction(String uname1, String pword1) {
	  String expected = "7rmart supermarket";
	  String actual = loginpage.loginPagetext();
	  Assert.assertEquals(actual, expected);
	  loginpage.loginAction(uname1, pword1);//from excel sheet
	 // loginpage.loginAction(username, password); //from properties file
  }

}
