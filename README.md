
# Flipkart-Automation
<i>Feburary 2022</i><br>
<p>An automation test framework for Flipkart.com, Written in Java, using Selenium WebDriver, TestNG and Maven based on the knowledge gained in trainning period as an automation engineer at Nagarro.</p>

</blockquote>

The directory structure:
<br />
<b>src/test/java</b><br />


## Features


- CLASS and XPath selectors to find HTML elements on a page

- Methods for automating links, buttons, textboxes, dropdowns and checkboxes

- Explicit waits

- Take screenshot on test failure

- TestNG DataProviders to create data-driven tests

- TestNG XML test suites

- Extent Report implementation

- Log4j Loggers


## File Details

- Resources file contans logs(from log4j) and config.properties file.

- Reports file contains the extent report which is generated after execution of test cases, to be opened in external browser.

- FailedScreenShots file contains screenshots from the failed test cases

- Drivers file contains chrome webdriver

- Utils file contains data.xlxs which contains all the external test to be supplies to the testcases. 


## Machine Set up details to execute tests on your local machine:

- Install JDK 

- Set up JAVA_HOME variable with proper path as system variable

- Load the troject on IDE

- Rebuild the project on your machine



