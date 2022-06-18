package com.sevenrmart.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenrmart.qa.constants.Constants;
import com.sevenrmart.qa.pages.LoginPage;
import com.sevenrmart.qa.utilities.ConfigUtil;
import com.sevenrmart.qa.utilities.ElementUtil;
import com.sevenrmart.qa.utilities.ExcelRead;
import com.sevenrmart.qa.utilities.WaitUtil;

public class BasePageTest {

	protected WebDriver driver;
	protected ElementUtil elementutil;
	protected LoginPage loginpage;
	protected WaitUtil waitutilpage;
	
	protected ConfigUtil configUtil = new ConfigUtil();

	protected String baseUrl = configUtil.getApplicationUrl();
	protected String username = configUtil.getUserName();
	protected String password = configUtil.getPassword();

	@Test
	

	@Parameters("browser")
	@BeforeClass (alwaysRun = true)
	public void setUp(@Optional("chrome") String browsername) {
		String path = System.getProperty("user.dir");
		if (browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", path + configUtil.getPropertyValue("chromepath"));
			driver = new ChromeDriver();
		} else if ((browsername.equals("edge"))) {

			System.setProperty("webdriver.edge.driver", path + configUtil.getPropertyValue("edgepath"));
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get(baseUrl);

	    elementutil = new ElementUtil(driver);
		waitutilpage = new WaitUtil(driver);
		loginpage = new LoginPage(driver);
	}

	@DataProvider()
	public Object[][] userData() throws InvalidFormatException, IOException {
		Object[][] data = ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "testData_Sheet1");
		return data;
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

		String destination = Constants.screenShot_path + name + dateName + ".png";

		File finalDestination = new File(destination);

		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterTest
	public void afterTest() {
	}

}
