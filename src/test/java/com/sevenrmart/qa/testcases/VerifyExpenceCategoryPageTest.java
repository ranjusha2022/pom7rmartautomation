package com.sevenrmart.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.sevenrmart.qa.pages.ExpenseCategoryPage;

public class VerifyExpenceCategoryPageTest extends BasePageTest {

	private static final String CATEGORY = "Juice";
	private ExpenseCategoryPage expenseCategoryPage;
	
	@Test(dataProvider = "userData", priority = 1)
	public void beforeTest(String uname, String pword) {
		loginpage.loginAction(uname, pword);// from excel sheet
	}

	@Test(priority = 2)
	public void openManageExpense() {
		// click manage expense
		expenseCategoryPage = new ExpenseCategoryPage(driver);
		expenseCategoryPage.clickManageExpenseMenu();
		assertTrue(expenseCategoryPage.isSubmenuVisble());
		
	}
	
	@Test(priority = 3)
	public void clickExpenseCategory() {
		// click expense category
		expenseCategoryPage.clickExpenseCategorySubMenu();
		//TODO: verify expense category main title
	}
	
	@Test(priority = 4)
	public void addNewCategory() {
		// click on new & save category
		expenseCategoryPage.addNewCategory(CATEGORY);
		// verify success alert
		assertTrue(expenseCategoryPage.isSuccessAlertDisplayed());
	}
	
	@Test(priority = 5)
	public void addDuplicateCategory() {
		// click on new & save category
		expenseCategoryPage.addNewCategory(CATEGORY);
		// verify duplicate category alert
		assertTrue(expenseCategoryPage.isFailureAlertDisplayed());
	}
	
	@Test(priority = 6)
	public void searchCategory() throws InterruptedException {
		expenseCategoryPage.searchCategory(CATEGORY);
		assertFalse(expenseCategoryPage.isNoResultMessageDisplayed());
	}
	
	@Test(priority = 7)
	public void deleteCategory() throws InterruptedException {
		expenseCategoryPage.searchCategory(CATEGORY);
		elementutil.click(expenseCategoryPage.getDeleteIcon());
		driver.switchTo().alert().accept();
		// verify delete category alert
		assertTrue(expenseCategoryPage.isSuccessAlertDisplayed());
	}
	
	
	
}
