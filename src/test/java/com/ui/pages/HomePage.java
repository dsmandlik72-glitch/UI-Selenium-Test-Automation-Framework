package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;

import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());

//Page Object Design Pattern
//Rules
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	
	public HomePage(WebDriver driver) {
		super(driver);//To call the Parent Class Constructor from the child constructor
		//goToWebSite(readProperty(QA, "URL"));
		goToWebSite(JSONUtility.readJson(QA).getUrl());
		maximizeWindow();

	}
	
	
	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);//To call the Parent Class Constructor from the child constructor
		//goToWebSite(readProperty(QA, "URL"));
		goToWebSite(JSONUtility.readJson(QA).getUrl());
		maximizeWindow();

	}

	public LoginPage goToLoginPage() {//Page Functions======>In Page Object Design Pattern Void return type is never used
		logger.info("Trying to performing click to go to Sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage=new LoginPage(getDriver());
		return loginPage;
	}
}
