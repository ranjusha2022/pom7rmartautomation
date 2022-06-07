package com.sevenrmart.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import com.sevenrmart.qa.constants.Constants;
import com.sevenrmart.qa.pages.LoginPage;
import com.sevenrmart.qa.utilities.ElementUtil;
import com.sevenrmart.qa.utilities.WaitUtil;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BasePageTest {
	
	public WebDriver driver;
	ElementUtil elementutil = new ElementUtil(driver);
	public LoginPage loginpage;
	public WaitUtil waitutilpage;
	
	public String baseUrl = elementutil.getApplicationUrl();
	public String username = elementutil.getUserName();
	public String password = elementutil.getPassword();
	
	
  @Test
  public void f() {
  }
  
  
@Parameters("browser")
  @BeforeClass
  public void setUp(@Optional("chrome")String browsername) {
		String path=System.getProperty("user.dir");
		if(browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", path+ ElementUtil.getPropertyValue("chromepath"));
			driver=new ChromeDriver();
		}else if((browsername.equals("edge"))) {

			System.setProperty("webdriver.edge.driver",path+ ElementUtil.getPropertyValue("edgepath"));
			driver=new EdgeDriver();
		}	
		
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
  
   loginpage = new LoginPage(driver);
   waitutilpage = new WaitUtil(driver);
   
  }
  
  @AfterMethod
	public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			takeScreenShotOnFailure(iTestResult.getName());

		}
	}

	public String takeScreenShotOnFailure(String name) throws IOException {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());


		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		
		String destination =Constants.screenShot_path + name + dateName + ".png";

		File finalDestination = new File(destination);

		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

  @AfterTest
  public void afterTest() {
  }

}
