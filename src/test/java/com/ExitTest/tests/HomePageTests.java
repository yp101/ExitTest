package com.ExitTest.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.pages.HomePage;
import com.ExitTest.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTests extends BaseTest {
	
	private String sheetName1 = prop.getProperty("homePageSheetName");
	
	@Test(groups= {"validLogin"},priority=1, enabled = true)
	public void productSearch() throws InterruptedException {

		String testCaseName1 = "UserSearchTheProduct";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String,String>();
			extentTest = extent.startTest("Verifying the functionality of Search product");
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

			log.info("Search button was clicked button");
			Assert.assertEquals(driver.getTitle(), title);
			extentTest.log(LogStatus.PASS, "Search product Functionality is working fine");
			extent.endTest(extentTest);
			
	}
	
	
	@Test(groups= {"validLogin"},priority=1, enabled = true)
	public void wishlistProduct() throws InterruptedException {

		String testCaseName1 = "UserWishlistProduct";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Wishlist product");
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
			Thread.sleep(2000);
			home.searchProduct(search);
			Thread.sleep(2000);
			home.addToWishlist();
			Thread.sleep(2000);
			log.info("Wishlist button was clicked button");
			Assert.assertEquals(home.message.getText(),title);
			extentTest.log(LogStatus.PASS, "Wishlist Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}

	}

	@Test(groups= {"validLogin"},priority=1, enabled = true)
	public void removeWishlistProduct() throws InterruptedException {

		String testCaseName1 = "UserRemoveProductFromWishlist";
		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Remove Wishlist product");
			fetchData = reader.getRowTestData(sheetName1, testCaseName1);
	
			String username = fetchData.get("Username");
			String password = fetchData.get("Password");
			String title=fetchData.get("Expected Title");
			LoginPage login=new LoginPage(driver);
			HomePage home=new HomePage(driver);
	
			login.enterUserName(username);
			login.enterPassword(password);
			login.clickSubmit();
	
			
			Thread.sleep(2000);
			home.removeFromWishlist();
			Thread.sleep(5000);
			log.info("Remove Wishlist button was clicked button");
			Assert.assertEquals(home.wishlistMessage.getText(),title);
			extentTest.log(LogStatus.PASS, "Remove Wishlist Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}
 
	}
	
	@Test(groups= {"validLogin"},priority=1, enabled = true)
	public void myOrders() throws InterruptedException {

		String testCaseName1 = "UserClickOrders";

		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Myorder");
		fetchData = reader.getRowTestData(sheetName1, testCaseName1);

		String username = fetchData.get("Username");
		String password = fetchData.get("Password");
		String title=fetchData.get("Expected Title");
		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);

		login.enterUserName(username);
		login.enterPassword(password);
		login.clickSubmit();

		
		Thread.sleep(2000);
		home.yourOrders();
		Thread.sleep(5000);
		log.info("Myorder button was clicked ");
		Assert.assertEquals(driver.getTitle(),title);
		extentTest.log(LogStatus.PASS, "Myorder Functionality is working fine");
		extent.endTest(extentTest);
		}
		catch(AssertionError e) {
		extentTest.log(LogStatus.FAIL,"failed");
		extent.endTest(extentTest);

		}

	}
	
	@Test(groups= {"validLogin"},priority=1, enabled = true)
	public void superCoin() throws InterruptedException {

		String testCaseName1 = "UserClickSuperCoins";
		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Super Coin");
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

		
		Thread.sleep(5000);
		home.superCoin();
		
		Thread.sleep(5000);
		log.info("Myorder button was clicked button");
		Assert.assertEquals(driver.getTitle(), title);
		Thread.sleep(5000);
		
		
		extentTest.log(LogStatus.PASS, "Super Coin Functionality is working fine");
		extent.endTest(extentTest);
		}
		catch(AssertionError e) {
		extentTest.log(LogStatus.FAIL,"failed");
		extent.endTest(extentTest);

		}
		
	}
	
	@Test(groups= {"validLogin"},priority=1, enabled = true)
	public void flipkartLogo() throws InterruptedException {

		String testCaseName1 = "UserClickFlipkartLogo";
		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Flipkart Logo");
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
			
			Thread.sleep(2000);
			home.searchProduct(search);
			Thread.sleep(2000);
			home.flipkartLogo();
			
			Thread.sleep(5000);
			log.info("Flipkart logo was clicked button");
			Assert.assertEquals(driver.getTitle(), title);
			Thread.sleep(5000);
			extentTest.log(LogStatus.PASS, "Flipkart Logo Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}

	}
	
	
	@Test(groups= {"validLogin"},priority=1, enabled = true)
	public void flipkartPlusZone() throws InterruptedException {

		String testCaseName1 = "UserClickFlipkartPlusZone";
		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Flipkart PlusZone");
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
			
			Thread.sleep(2000);
			home.searchProduct(search);
			Thread.sleep(2000);
			home.flipkartPlusZone();
			
			Thread.sleep(5000);
			log.info("Flipkart Plus Zone button was clicked");
			Assert.assertEquals(driver.getTitle(),title);
			Thread.sleep(5000);
			extentTest.log(LogStatus.PASS, "Flipkart Plus Zone Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}

	}
	
	
	
	@Test(groups= {"validLogin"},priority=1, enabled = true)
	public void flipkartCoupons() throws InterruptedException {
		String testCaseName1 = "UserClickCoupons";
		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Flipkart Coupons");
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
		
			Thread.sleep(2000);
			home.getCoupons();;
			
			Thread.sleep(5000);
			log.info("Flipkart coupons was checked ");
			Assert.assertEquals(home.cuponcheck.getText(),title);
			Thread.sleep(5000);
			extentTest.log(LogStatus.PASS, "Flipkart Coupons Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}

	}
	
	@Test(groups= {"validLogin"},priority=1, enabled = true)
		public void flipkartNotifications() throws InterruptedException {

			String testCaseName1 = "UserClickNotifications";
			HashMap<String, String> fetchData = new HashMap<String,String>();
			try{
				extentTest = extent.startTest("Verifying the functionality of Flipkart Notification");
				fetchData = reader.getRowTestData(sheetName1, testCaseName1);
	
				String username = fetchData.get("Username");
				String password = fetchData.get("Password");
				String title=fetchData.get("Expected Title");
				LoginPage login=new LoginPage(driver);
				HomePage home=new HomePage(driver);
	
				login.enterUserName(username);
				login.enterPassword(password);
				login.clickSubmit();
	
				
				Thread.sleep(2000);
				home.flipkartNotifications();
				
				Thread.sleep(5000);
				log.info("Flipkart Notification button was clicked ");
				Assert.assertEquals(home.caughtup.getText(),title);
				Thread.sleep(5000);
				extentTest.log(LogStatus.PASS, "Flipkart Notification Functionality is working fine");
				extent.endTest(extentTest);
				}
				catch(AssertionError e) {
				extentTest.log(LogStatus.FAIL,"failed");
				extent.endTest(extentTest);

				}

		}

	@Test(groups= {"validLogin"},priority=1, enabled = true)
	public void flipkartFilterType() throws InterruptedException {

		String testCaseName1 = "UserClicksNIKE";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of product by using some filter");
			fetchData = reader.getRowTestData(sheetName1, testCaseName1);
	
			String username = fetchData.get("Username");
			String password = fetchData.get("Password");
			String title=fetchData.get("Expected Title");
			LoginPage login=new LoginPage(driver);
			HomePage home=new HomePage(driver);
	
			login.enterUserName(username);
			login.enterPassword(password);
			login.clickSubmit();
	
			
			Thread.sleep(2000);
			String search=fetchData.get("ProductSearch");
			Thread.sleep(5000);
			home.searchProduct(search);;
			
			Thread.sleep(5000);
			home.productFilterType();
			Thread.sleep(2000);
			log.info("Filter NIKE was clicked ");
			Assert.assertEquals(home.filtermessage.getText(), title);
			Thread.sleep(5000);
			extentTest.log(LogStatus.PASS, "Filter Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}

	}
	
	@Test(groups= {"validLogin"},priority=1, enabled = true)
	public void clickNext() throws InterruptedException {

		String testCaseName1 = "UserClicksNextButton";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the nextpage functionality of product");
			fetchData = reader.getRowTestData(sheetName1, testCaseName1);
	
			String username = fetchData.get("Username");
			String password = fetchData.get("Password");
			String title=fetchData.get("Expected Title");
			LoginPage login=new LoginPage(driver);
			HomePage home=new HomePage(driver);
	
			login.enterUserName(username);
			login.enterPassword(password);
			login.clickSubmit();
	
			
			Thread.sleep(2000);
			String search=fetchData.get("ProductSearch");
			Thread.sleep(5000);
			home.searchProduct(search);;
			
			Thread.sleep(5000);
			home.nextpage();
			
			
			Thread.sleep(2000);
			log.info("Nextpage is clicked ");
			Assert.assertEquals(home.nextpagemsg.getText(), title);
			Thread.sleep(5000);
			extentTest.log(LogStatus.PASS, "nextpage Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}

	}
	

}
