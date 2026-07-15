package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({ com.ui.listeners.TestListeners.class })

public class SearchProductTest extends TestBase {

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed Summer Dress";

	@BeforeMethod
	public void setUp() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("dmandlik92@gmail.com", "Aurangabad@123");
	}

	@Test(description = "Verify if the logged in user is able to search for a product and corrects products search result are displayed", groups = {
			"e2e", "smoke", "sanity" })
	public void verifyproductSearchTest() {
//		String data=myAccountPage.searchForAProduct("Printed Summer Dress").getSearchResultTitle();
//		System.out.println(data);
		boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM)
				.isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);

	}
}
