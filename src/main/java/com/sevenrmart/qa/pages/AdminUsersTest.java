package com.sevenrmart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminUsersTest {
	@FindBy(xpath = "//a[text() = \" New\"]")
	private WebElement newAdminButton;

	@FindBy(id = "username")
	private WebElement newUserTextfield;

	@FindBy(id = "password")
	private WebElement passwordTextfield;

	@FindBy(id = "user_type")
	private WebElement userTypeDropDown;

}
