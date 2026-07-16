package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Size;
import com.ui.pages.MyAccountPage;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer Dress";
	private SearchResultPage searchResultPage;

	@BeforeMethod(description = "User Logs into the application and searches for a product")
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("dmandlik92@gmail.com", "Aurangabad@123")
				.searchForAProduct(SEARCH_TERM);
	}

	@Test(description = "Verify if the logged in user is able to buy a dress", groups = { "e2e", "smoke", "sanity" })
	public void checkoutTest() {
	String result	=searchResultPage.clickOnTheProductAtIndex(0).changeSize(2).addProductToCart().proceedToCheckout()
				.goToConfirmAddressPage().goToShippmentPage().goToPaymentPage().makePaymentByWire();
	
	Assert.assertTrue(result.contains("complete"));
	
	System.out.println(result);
	}
}
