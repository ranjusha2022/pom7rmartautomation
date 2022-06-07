package com.sevenrmart.qa.testcases;

import org.testng.annotations.Test;

import com.sevenrmart.qa.constants.Constants;
import com.sevenrmart.qa.pages.LoginPage;
import com.sevenrmart.qa.utilities.ExcelRead;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class VerifyLoginPageTest extends BasePageTest {
	
  @Test(dataProvider = "userData", priority = 1)
  public void loginAction(String uname1, String pword1) {
	  String expected = "7rmart supermarket";
	  String actual = loginpage.loginPagetext();
	  Assert.assertEquals(actual, expected);
	  loginpage.loginAction(uname1, pword1);//from excel sheet
	 // loginpage.loginAction(username, password); //from properties file
  }
  
  @DataProvider()
  
  public Object[][] userData() throws InvalidFormatException, IOException
  {
	  Object[][] data = ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "testData_Sheet1");
	  return data;
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
