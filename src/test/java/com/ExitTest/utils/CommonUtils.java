package com.ExitTest.utils;

import java.util.HashMap;

import org.testng.SkipException;

import com.ExitTest.tests.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class CommonUtils extends BaseTest{
	public static void logTestData(String worksheetName, String testCaseName) {


		   HashMap<String, String> testData = new HashMap<String, String>();
		   testData = reader.getRowTestData(worksheetName, testCaseName);

		   // Print all data
		   extentTest.log(LogStatus.INFO, "--------------------------- Test Data -------------------------------");

		   log.info("Test Data For Worksheet Name "+worksheetName+" And For Test Case "+testCaseName);
		   extentTest.log(LogStatus.INFO, "Test Data For Worksheet Name "+worksheetName+" And For Test Case "+testCaseName);

		   for (HashMap.Entry<String, String> entry : testData.entrySet()) {

		      if(entry.getKey() != "" && entry.getValue() != "") {
		         log.info(entry.getKey() + " : " + entry.getValue().toString());
		         extentTest.log(LogStatus.INFO, entry.getKey() + " : " + entry.getValue().toString());

		      }
		   }

		   log.info("----------------------------------------------------------------------");
		   extentTest.log(LogStatus.INFO, "----------------------------------------------------------------------");

		}

		// function toCheckExecutionRequired
		public static void toCheckExecutionRequired(String executionRequired) {
		   
		   // if execution required field is no
		   if(executionRequired.equals("no")) {
		      
		      extentTest.log(LogStatus.WARNING, "Execution Required : "+executionRequired.toUpperCase());
		      log.info("Execution required is no , skipping the test");
		      throw new SkipException("Skipping this exception");
		   }
		   
		   // if execution required field is empty
		   if(executionRequired.equals("")) {
		      
		      extentTest.log(LogStatus.WARNING, "Execution Required : "+executionRequired.toUpperCase());
		      log.info("Execution required is empty , skipping the test");
		      throw new SkipException("Skipping this exception");
		   }
		}

}
