package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase{

	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPOJO address;
	@BeforeMethod(description="Valid First Time user logs into the application")
	public void setUp() {
		
		myAccountPage=homePage.goToLoginPage().doLoginWith("dmandlik92@gmail.com", "Aurangabad@123");
		
		//address= new AddressPOJO("Infosys", "Address Line 1", "Address Line 1", "city", "12345", "9405167371", "9405167371", "Other Info", "Office Address", 5);
		address=FakeAddressUtility.getFakeAddress();
	}
	
	@Test
	public void addNewAddress() {
	String newAddress=myAccountPage.goToAddAddressPage().saveAddress(address);
	System.out.println(newAddress);
	System.out.println(address.getAddressAlias().toUpperCase());
	Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
	}
}
