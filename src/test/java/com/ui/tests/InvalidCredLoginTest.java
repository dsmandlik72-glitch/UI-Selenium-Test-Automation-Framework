package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListeners.class})
public class InvalidCredLoginTest extends TestBase {

	/*
	 * Principles of writing Test Scripts Test Method!!! 1.Test Script Small!! 2.You
	 * can not have conditional statements, loops, try catch in your test method
	 * TestScripts =====> Test Steps 3.Reduce the use of Local Variables 4.Atleast
	 * one assertion!!!
	 * 
	 * 
	 */
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS="dmandlik92@gmail.com";
	private static final String INVALID_PASSWORD="Appa@123";



	@Test(description = "Verifies if the proper error message is shown for the user when they enter invalid credentials", groups = { "e2e",
			"sanity" })

	public void loginExcelTest() {
		assertEquals(
				homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMessage(),"Authentication failed.");
	}
}
