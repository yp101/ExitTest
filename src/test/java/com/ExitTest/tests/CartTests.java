package com.ExitTest.tests;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.pages.CartTest;
import com.ExitTest.pages.HomePage;
import com.ExitTest.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CartTests extends BaseTest {
	
	private String sheetName1 = prop.getProperty("AddToCartPageSheetName");
	
	
	@Test(groups= {"validLogin"},priority=18, enabled = true)
	public void AddProductToCart() throws InterruptedException {
		

		String testCaseName1 = "UserAddsProductToCart";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Add to cart");
			fetchData = reader.getRowTestData(sheetName1, testCaseName1);
	
			String executionRequired = fetchData.get("Execution Required");
			String username = fetchData.get("Username");
			String password = fetchData.get("Password");
			String title=fetchData.get("Expected Title");
			LoginPage login=new LoginPage(driver);
			HomePage home=new HomePage(driver);
	
			login.enterUserName(username);
			login.enterPassword(password);
			login.clickSubmit();
	
			String search=fetchData.get("ProductSearch");
			Thread.sleep(5000);
			
			home.searchProduct(search);
			Thread.sleep(5000);
			
			CartTest add=new CartTest(driver);
			
			add.clickProduct();
			Thread.sleep(2000);
			log.info("Add to cart button was clicked button was clicked");
			Assert.assertEquals(driver.getTitle(),title);
			extentTest.log(LogStatus.PASS, "Add To Cart Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}

	}
	
	@Test(groups= {"validLogin"},priority=19, enabled = true)
	public void RemoveProductFromCart() throws InterruptedException {
		
		String testCaseName1 = "UserRemoveProductFromCart";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Removing Product from cart ");
			fetchData = reader.getRowTestData(sheetName1, testCaseName1);
	
			String executionRequired = fetchData.get("Execution Required");
			String username = fetchData.get("Username");
			String password = fetchData.get("Password");
			String title=fetchData.get("Expected Title");
			LoginPage login=new LoginPage(driver);
			HomePage home=new HomePage(driver);
	
			login.enterUserName(username);
			login.enterPassword(password);
			login.clickSubmit();
	
			String search=fetchData.get("ProductSearch");
			Thread.sleep(5000);
			
			home.searchProduct(search);
			Thread.sleep(5000);
			
			CartTest add=new CartTest(driver);
		
			add.clickProduct();
			add.removeProduct();
			Thread.sleep(10000);
			log.info("Remove button was clicked button was clicked");
			Assert.assertEquals(add.message.getText(),title);
			extentTest.log(LogStatus.PASS, "Remove from Cart Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}
	}
	
	
	@Test(groups= {"validLogin"},priority=20, enabled = true)
	public void SaveForLater() throws InterruptedException {
		

		String testCaseName1 = "UserClickSaveForLater";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of save for later");
			fetchData = reader.getRowTestData(sheetName1, testCaseName1);
	
			String executionRequired = fetchData.get("Execution Required");
			String username = fetchData.get("Username");
			String password = fetchData.get("Password");
			String title = fetchData.get("Expected Title");
			LoginPage login=new LoginPage(driver);
			HomePage home=new HomePage(driver);
	
			login.enterUserName(username);
			login.enterPassword(password);
			login.clickSubmit();
	
			String search=fetchData.get("ProductSearch");
			Thread.sleep(5000);
			
			home.searchProduct(search);
			Thread.sleep(5000);
			CartTest add=new CartTest(driver);
	
			add.clickProduct();
			Thread.sleep(2000);
			add.saveForLater();
	
			Thread.sleep(5000);
			log.info("Save for later button was clicked ");
			Assert.assertEquals(add.later.getText(), title);
			extentTest.log(LogStatus.PASS, "Save For Later Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}
	}
	
	
	
	@Test(groups= {"validLogin"},priority=21, enabled = true)
	public void checkSize() throws InterruptedException {
		

		String testCaseName1 = "UserClicksOnCheckSize";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of check Size Chart");
			fetchData = reader.getRowTestData(sheetName1, testCaseName1);
	
			String executionRequired = fetchData.get("Execution Required");
			String username = fetchData.get("Username");
			String password = fetchData.get("Password");
			String title=fetchData.get("Expected Title");
			LoginPage login=new LoginPage(driver);
			HomePage home=new HomePage(driver);
	
			login.enterUserName(username);
			login.enterPassword(password);
			login.clickSubmit();
	
			String search=fetchData.get("ProductSearch");
			Thread.sleep(5000);
			home.searchProduct(search);
			Thread.sleep(5000);
			CartTest add=new CartTest(driver);
			

			add.clickprod();
			Thread.sleep(2000);
			add.clickSizeChart();
			Thread.sleep(2000);
	
			Thread.sleep(5000);
			log.info(" check Size Chart button was clicked ");
			Assert.assertEquals(add.size.getText(), title);
			extentTest.log(LogStatus.PASS, " check Size Chart Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}
	}

}
