package com.ExitTest.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		}
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Yash')]")
	public WebElement profileButton;
	
//	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[10]/a[1]")
//	public WebElement logout;
	
	@FindBy(how=How.XPATH, using="//div[contains(text(),'Logout')]")
	public WebElement logout;
	
	public void clickProfile() {
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		
	}
	public void clickLogout() {
		logout.click();
	}

}
