package com.sevenrmart.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.sevenrmart.qa.constants.Constants;

public class ConfigUtil {

	static Properties pro = new Properties();

	public ConfigUtil() {
		File src = new File(Constants.propertyConfig_File);

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationUrl() {

		String url = pro.getProperty("baseUrl");
		return url;
	}

	public String getUserName() {

		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword() {

		String password = pro.getProperty("password");
		return password;
	}
	
	public String getPropertyValue(String key)
	{
		String value=pro.get(key).toString();
		return value;
	}

}
