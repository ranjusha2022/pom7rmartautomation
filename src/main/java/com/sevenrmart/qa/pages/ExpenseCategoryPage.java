package com.sevenrmart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmart.qa.utilities.ElementUtil;
import com.sevenrmart.qa.utilities.WaitUtil;

public class ExpenseCategoryPage {

	@FindBy(xpath = "/html/body/div/aside[1]/div/div[4]/div/div/nav/ul/li[2]/a")
	private WebElement manageExpenseMenu;

	@FindBy(xpath = "//p[text() = \"Expense Category\"]")
	private WebElement expenseCategorySubmenu;

	@FindBy(xpath = "//h1[text() = \"Expense Category\"]")
	private WebElement expenseCategoryHeader;

	@FindBy(xpath = "//a[text() = \" New\"]")
	private WebElement expenseCategoryNewButton;

	@FindBy(id = "name")
	private WebElement expenseCategoryTitle;

	@FindBy(xpath = "//button[@name = \"Create\"]")
	private WebElement expenseCategorySave;
	
	@FindBy(xpath = "//a[text()= \" Search\"]")
	private WebElement expenseCategorySearch;
	
	@FindBy(id = "un")
	private WebElement searchElement;
	
	@FindBy(name= "Search")
	private WebElement searchButton;
	
	@FindBy(id = "res")
	private WebElement searchNoFound;
	
	@FindBy(xpath = "//a[@class=\"btn btn-sm btn btn-danger btncss\"]")
	private WebElement deleteIcon;

	@FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible\"]")
	private WebElement successAlert;
	
	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	private WebElement failureAlert;

	private ElementUtil elementutil;

	private WaitUtil waitutil;

	public ExpenseCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		elementutil = new ElementUtil(driver);
		waitutil = new WaitUtil(driver);
	}

	public void clickManageExpenseMenu() {
		elementutil.click(manageExpenseMenu);
	}

	public void clickExpenseCategorySubMenu() {
		elementutil.click(expenseCategorySubmenu.findElement(By.xpath("./..")));
	}

	public void addNewCategory(String categoryTitle) {
		elementutil.click(expenseCategoryNewButton);
		elementutil.sendKeys(expenseCategoryTitle, categoryTitle);
		elementutil.click(expenseCategorySave);
	}
	
	public void searchCategory(String text) {
		elementutil.click(expenseCategorySearch);
		elementutil.sendKeys(searchElement, text);
		elementutil.click(searchButton);
		
		
	}

	public boolean isNoResultMessageDisplayed() {
		try {
			return searchNoFound.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}


	public boolean isSuccessAlertDisplayed() {
		return successAlert.isDisplayed();
	}

	public boolean isFailureAlertDisplayed() {
		return failureAlert.isDisplayed();
	}
	
	public boolean isSubmenuVisble() {
		return expenseCategorySubmenu.isDisplayed();
	}
	
	public WebElement getDeleteIcon() {
		return deleteIcon;
	}

	

}
