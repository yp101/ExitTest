package com.ExitTest.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ExitTest.pages.ScreenShots;
import com.ExitTest.utils.ReadDataFromExcel;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import org.apache.loging.log4j.LogManager;
//import org.apache.loging.log4j.loger;
import org.apache.log4j.Logger;



public class BaseTest {
	
	static WebDriver driver;
	static File file=new File("./Resources/config.properties");
	static FileInputStream fis=null;
	static Properties prop=new Properties();
	
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	

	public final static Logger log = Logger.getLogger(BaseTest.class);


	// Excel File Test Data Reader
	public static ReadDataFromExcel reader = null;
	
	
	static {
		try {
			fis=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	// Exception Handling for Excel File
	try {



	reader = new ReadDataFromExcel(prop.getProperty("testDataFileLocation"));
	}
	catch(Exception e)
	{



	//loger.error(e.getMessage());
	}
	}
	@BeforeTest(groups = {"LogIn","validLogin","report","sel"})
	public void setExtent() {
		extent = new ExtentReports("./Reports/ExtentReport.html");
		}

		@AfterTest(groups = {"validLogin","LogIn","report","sel"})
		public void endReport() throws InterruptedException {
		//extent.endTest(extentTest);
		extent.flush();
		extent.close();
		}
		
		@AfterMethod(groups = {"validLogin","LogIn","report","sel"})
		public void attachScreenshot(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
		String screenshotPath = ScreenShots.CaptureScreenshot(driver, result.getName());
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath) );
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
		extentTest.log(LogStatus.PASS, "Test Successful");
		}
		}



	@BeforeMethod(groups= {"validLogin"})
	public static void initializeWebDriver(){
		System.setProperty(prop.getProperty("chromeDriverProperty"),prop.getProperty("chromeDriverPath"));
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeMethod(groups= {"validLogin"})
	public static void openUrl() {
		
		driver.get(prop.getProperty("url"));
			
	}
	
	@AfterMethod(groups= {"validLogin"})
	public static void closeBrowser(ITestResult result) {
		
		//driver.close();
		// for fail test cases
		if(result.getStatus() == ITestResult.FAILURE) {

		extentTest.log(LogStatus.FAIL, "TEST FAILED "+result.getName());
		extentTest.log(LogStatus.FAIL, "TEST FAILED THROWABLE EXC "+result.getThrowable());

		// adding screenshot
		String screenshotPath = ScreenShots.CaptureScreenshot(driver, result.getName());
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		}

		else if(result.getStatus() == ITestResult.SKIP) {

		extentTest.log(LogStatus.SKIP, "TEST SKIPPED "+result.getName());
		}

		else if(result.getStatus() == ITestResult.SUCCESS) {

		extentTest.log(LogStatus.PASS, "TEST PASSED "+result.getName());
		}

		// end the testcase in the extent report
		extent.endTest(extentTest);

		// closing the driver
		driver.quit();
	}
	

}
