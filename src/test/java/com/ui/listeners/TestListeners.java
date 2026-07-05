package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListeners implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	ExtentSparkReporter extentSparkReporter;// Use for HTML Report Look & Style
	ExtentReports extentReports;// Use to Dump the data in the Report
	ExtentTest extentTest;// Use to store Test Info in the report

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		// extentTest=extentReports.createTest(result.getMethod().getMethodName());
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
	}

	public void onTestFailure(ITestResult result) {
		
		
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		
/*"The listener is a separate class, so it doesn't have direct access to the homePage object or the WebDriver created in TestBase. 
 * When a test fails, TestNG passes an ITestResult object. 
 * Using result.getInstance(), 
 * I get the object of the currently executing test class, such as LoginTest. 
 * Since all my test classes extend TestBase, I cast it to TestBase and call getInstance(), which returns the homePage object. 
 * Because HomePage extends BrowserUtility, I can call takeScreenShot() on that object and capture a screenshot using the same WebDriver instance that executed the test*/
		
		
		Object testclass = result.getInstance();


		BrowserUtility browserUtility = ((TestBase) testclass).getInstance();
		logger.info("Capturing the screenshot for the failed tests");

		String screenshotPath=browserUtility.takeScreenShot(result.getMethod().getMethodName());
		logger.info("Attaching the screenshot for HTML File");

		ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");

	}

	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ExtentReporterUtility.setupSparkReporter("report.html");

	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
		ExtentReporterUtility.flushReport();
	}

}
