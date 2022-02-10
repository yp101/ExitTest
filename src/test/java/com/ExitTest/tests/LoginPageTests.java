package com.ExitTest.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

//import org.apache.loging.log4j.loger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ExitTest.pages.LoginPage;
import com.ExitTest.utils.CommonUtils;
import com.ExitTest.utils.ReadDataFromExcel;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTests extends BaseTest {

	private String sheetName = prop.getProperty("loginPageSheetName");

	@Test(groups = { "validLogin" }, priority = 1, enabled = true)

	public void validLogin() throws InterruptedException {
		String testCaseName = "UserEntersValidMobileNumberAndValidPassword";
		HashMap<String, String> fetchData = new HashMap<String, String>();
		try {
			extentTest = extent.startTest("Verifying the functionality of Valid Login page");


			fetchData = reader.getRowTestData(sheetName, testCaseName);

			String username = fetchData.get("Username");
			String password = fetchData.get("Password");
			String title = fetchData.get("Expected Title");
			String executionRequired = fetchData.get("Execution Required");
			// log all data
			CommonUtils.logTestData(sheetName, testCaseName);

			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);

			login.enterUserName(username);
			login.enterPassword(password);
			Thread.sleep(2000);
			login.clickSubmit();

			Assert.assertEquals(driver.getTitle(), title);
			log.info("login button was clicked");
			extentTest.log(LogStatus.PASS, "Valid Login Functionality is working successfully");
			extent.endTest(extentTest);

		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, "failed");
			extent.endTest(extentTest);

		}

	}

	
	@Test(groups = { "invalidLogin" }, priority = 1, enabled = true)
	public void invalidUsername() throws InterruptedException {

		String testCaseName = "UserEntersInvalidMobileNumberAndValidPassword";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String, String>();
		try {
			extentTest = extent.startTest("Verifying the functionality of Login page");
			fetchData = reader.getRowTestData(sheetName, testCaseName);

			// String executionRequired = fetchData.get("Execution Required");
			String username = fetchData.get("Username");
			String password = fetchData.get("Password");
			String message = fetchData.get("Message");
			String executionRequired = fetchData.get("Execution Required");
			// log all data
			CommonUtils.logTestData(sheetName, testCaseName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);

			login.enterUserName(username);
			login.enterPassword(password);
			Thread.sleep(2000);
			login.clickSubmit();
			Assert.assertEquals(login.message.getText(), message);
			log.info("login button was clicked");
			extentTest.log(LogStatus.INFO, "Invalid username Functionality is working fine");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, "failed");
			extent.endTest(extentTest);

		}
	}

	@Test(groups = { "invalidLogin" }, priority = 1, enabled = true)
	public void invalidPassword() {

		String testCaseName = "UserEntersValidMobileNumberAndInvalidPassword";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String, String>();
		try {
			extentTest = extent.startTest("Verifying the functionality of Login page");
			fetchData = reader.getRowTestData(sheetName, testCaseName);

			String executionRequired = fetchData.get("Execution Required");
			String username = fetchData.get("Username");
			String password = fetchData.get("Password");
			String message = fetchData.get("Message");
			// log all data
			CommonUtils.logTestData(sheetName, testCaseName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);

			login.enterUserName(username);
			login.enterPassword(password);
			login.clickSubmit();
			Assert.assertEquals(login.message.getText(), message);
			log.info("login button was clicked");
			extentTest.log(LogStatus.INFO, "InValid Password Functionality is working fine");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, "failed");
			extent.endTest(extentTest);

		}

	}
	

		@Test(groups = { "invalidLogin" }, priority = 1, enabled = true)
		public void invalidUsernameAndPassword() {

			String testCaseName = "UserEntersInvalidMobileNumberAndInvalidPassword";
			// Fetching all test data from excel file
			HashMap<String, String> fetchData = new HashMap<String, String>();
			try {
				extentTest = extent.startTest("Verifying the functionality of Login page");
				fetchData = reader.getRowTestData(sheetName, testCaseName);

				String executionRequired = fetchData.get("Execution Required");
				String username = fetchData.get("Username");
				String password = fetchData.get("Password");
				String message = fetchData.get("Message");
				// log all data
				CommonUtils.logTestData(sheetName, testCaseName);

				// if execution required field is no
				CommonUtils.toCheckExecutionRequired(executionRequired);

				LoginPage login = new LoginPage(driver);

				login.enterUserName(username);
				login.enterPassword(password);
				login.clickSubmit();
				Assert.assertEquals(login.message.getText(), message);
				log.info("login button was clicked");
				extentTest.log(LogStatus.INFO, "InValid UserName and Password Functionality is working fine");
				extent.endTest(extentTest);
			} catch (AssertionError e) {
				extentTest.log(LogStatus.FAIL, "failed");
				extent.endTest(extentTest);

			}

		}
}