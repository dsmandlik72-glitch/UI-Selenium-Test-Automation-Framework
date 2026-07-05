package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListeners.class})
public class LoginTest extends TestBase {

	/*
	 * Principles of writing Test Scripts Test Method!!! 1.Test Script Small!! 2.You
	 * can not have conditional statements, loops, try catch in your test method
	 * TestScripts =====> Test Steps 3.Reduce the use of Local Variables 4.Atleast
	 * one assertion!!!
	 * 
	 * 
	 */
	
	Logger logger = LoggerUtility.getLogger(this.getClass());


	
	@Test(description = "Verifies with the valid user is able to login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {

		assertEquals(
				homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Dhananjay Mandlik");

	}

//	@Test(description = "Verifies with the valid user is able to login into the application", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
//	public void loginCSVTest(User user) {
//
//		assertEquals(
//				homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Dhananjay Mandlik");
//
//	}
//
//	@Test(description = "Verifies with the valid user is able to login into the application", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//
//	public void loginExcelTest(User user) {
//		assertEquals(
//				homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Jatin Sharma");
//
//	}
}
