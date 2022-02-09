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
	
	@Test(groups= {"validLogin"},priority=8, enabled = true)
	public void productSearch() throws InterruptedException {

		String testCaseName1 = "whenUserSearchTheProduct";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String,String>();
//		try{
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
//			}
//			catch(AssertionError e) {
//			extentTest.log(LogStatus.FAIL,"failed");
//			extent.endTest(extentTest);
//
//			}
			
	}
	
	
	@Test(groups= {"validLogin"},priority=9, enabled = true)
	public void wishlistProduct() throws InterruptedException {

		String testCaseName1 = "whenUserWishlistProduct";
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
			//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			home.searchProduct(search);
			//driver.manage().timeouts().implicitlyWait(230,TimeUnit.SECONDS);
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


	
		//		extentTest.log(LogStatus.PASS,"Login done Successfully!!!");
//		extent.endTest(extentTest);
	}

	@Test(groups= {"validLogin"},priority=10, enabled = true)
	public void removeWishlistProduct() throws InterruptedException {

		String testCaseName1 = "whenUserRemoveProductFromWishlist";
		// Fetching all test data from excel file
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
 
	
		//		extentTest.log(LogStatus.PASS,"Login done Successfully!!!");
//		extent.endTest(extentTest);
	}
	
	@Test(groups= {"validLogin"},priority=11, enabled = true)
	public void myOrders() throws InterruptedException {

		String testCaseName1 = "whenUserClickOrders";
		// Fetching all test data from excel file
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
		//		extentTest.log(LogStatus.PASS,"Login done Successfully!!!");
//		extent.endTest(extentTest);
	}
//	
	@Test(groups= {"validLogin"},priority=12, enabled = true)
	public void superCoin() throws InterruptedException {

		String testCaseName1 = "whenUserClickSuperCoins";
		// Fetching all test data from excel file
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
		
		
//		extentTest.log(LogStatus.PASS,"Login done Successfully!!!");
//		extent.endTest(extentTest);
	}
	
	@Test(groups= {"validLogin"},priority=13, enabled = true)
	public void flipkartLogo() throws InterruptedException {

		String testCaseName1 = "whenUserClickFlipkartLogo";
		// Fetching all test data from excel file
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
		
		
//		extentTest.log(LogStatus.PASS,"Login done Successfully!!!");
//		extent.endTest(extentTest);
	}
	
	
	@Test(groups= {"validLogin"},priority=14, enabled = true)
	public void flipkartPlusZone() throws InterruptedException {

		String testCaseName1 = "whenUserClickFlipkartPlusZone";
		// Fetching all test data from excel file
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
		
		
//		extentTest.log(LogStatus.PASS,"Login done Successfully!!!");
//		extent.endTest(extentTest);
	}
	
	
	
	@Test(groups= {"validLogin"},priority=15, enabled = true)
	public void flipkartCoupons() throws InterruptedException {
		String testCaseName1 = "whenUserClickCoupons";
		// Fetching all test data from excel file
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
		
		
//		extentTest.log(LogStatus.PASS,"Login done Successfully!!!");
//		extent.endTest(extentTest);
	}
	
	@Test(groups= {"validLogin"},priority=16, enabled = true)
		public void flipkartNotifications() throws InterruptedException {

			String testCaseName1 = "whenUserClickNotifications";
			// Fetching all test data from excel file
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

	@Test(groups= {"validLogin"},priority=17, enabled = true)
	public void flipkartFilterType() throws InterruptedException {

		String testCaseName1 = "whenUserClicksNIKE";
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
	
	@Test(groups= {"validLogin"},priority=18, enabled = true)
	public void sortLowToHigh() throws InterruptedException {

		String testCaseName1 = "whenUserClicksNextButton";
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
