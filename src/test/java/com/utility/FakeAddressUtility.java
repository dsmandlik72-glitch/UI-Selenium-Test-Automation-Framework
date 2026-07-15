package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {

	public static void main(String[] args) {
		getFakeAddress();
	}

	public static AddressPOJO getFakeAddress() {

		Faker faker = new Faker(Locale.US);
		
		//AddressPOJO addressPOJO=new AddressPOJO("Infosys", "Address Line 1", "Address Line 1", "city", "12345", "9405167371", "9405167371", "Other Info", "Office Address", 5);
		AddressPOJO addressPOJO=new AddressPOJO(faker.company().name(),faker.address().buildingNumber(), faker.address().streetAddress(), faker.address().city(),
				faker.numerify("#####"),faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(),"Other Info", "Office Address", 5);
				
			

		return addressPOJO;
	}
}
