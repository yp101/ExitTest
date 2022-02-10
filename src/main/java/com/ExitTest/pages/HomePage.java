package com.ExitTest.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	//productsearchxpaths
	@FindBy(how=How.XPATH,using="//input[@placeholder='Search for products, brands and more']")
	public WebElement searchBox;
	@FindBy(how=How.XPATH,using="//button[@type='submit']//*[name()='svg']")
	public WebElement searchIcon;
	
	//add to wish list xpaths
	@FindBy(how=How.XPATH,using="//div[@class='_1YokD2 _3Mn1Gg']//div[2]//div[1]//div[3]//div[1]//a[1]//div[3]//div[1]//*[name()='svg']//*[name()='path' and contains(@class,'eX72wL')]")
	public WebElement heartIcon;
	@FindBy(how=How.XPATH,using="//div[@class='exehdJ'][normalize-space()='Yash']")
	public WebElement profileButton;
	@FindBy(how=How.XPATH,using="//div[normalize-space()='Wishlist']")
	public WebElement wishlist;
	@FindBy(how=How.XPATH,using="//span[normalize-space()='My Wishlist (1)']")
	public WebElement message;
	
	//remove from wishlist xpaths
	
	@FindBy(how=How.XPATH,using="//img[@class='_2Nq6Qc']")
	public WebElement delete;
	@FindBy(how=How.XPATH,using="//button[@class='_2KpZ6l _3S58wp']")
	public WebElement confirmDelete;
	@FindBy(how=How.CLASS_NAME ,using="_3Juh7R")
	public WebElement wishlistMessage;
	
	//orders
	@FindBy(how=How.XPATH,using="//div[normalize-space()='Orders']")
	public WebElement orders;
	
	//productfilterType
	@FindBy(how=How.XPATH,using="//div[@title='NIKE']//div[@class='_24_Dny']")
	public WebElement producttype;
	@FindBy(how=How.CLASS_NAME,using="_3sckoD")
	public WebElement filtermessage;
	@FindBy(how=How.CLASS_NAME,using="_10Ermr")
	public WebElement nextpagemsg;
	
	//Flipkart
	@FindBy(how=How.XPATH,using="//img[@title='Flipkart']")
	public WebElement flipkart;
	//Pluszone
	@FindBy(how=How.XPATH,using="//div[normalize-space()='Flipkart Plus Zone']")
	public WebElement pluszone;
	//coupons
	@FindBy(how=How.XPATH,using="//div[normalize-space()='Coupons']")
	public WebElement coupons;
	@FindBy(how=How.XPATH,using="//div[@class='HrTrMw']")
	public WebElement cuponcheck;
	
	//supercoin
	@FindBy(how=How.XPATH,using="//a[@href='/supercoin']")
	public WebElement coins;
		
	//notifications
	@FindBy(how=How.XPATH,using="//div[normalize-space()='Notifications']")
	public WebElement notification;
	@FindBy(how=How.XPATH,using="//div[@class='TQWXTH']")
	public WebElement caughtup;
		
	//nextpage
	@FindBy(how=How.XPATH,using="//span[normalize-space()='Next']")
	public WebElement nextpage;
	
	
	

	
	public void searchProduct(String name) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		searchBox.sendKeys(name);
		searchIcon.click();

	}
	
	public void addToWishlist() throws InterruptedException {
		heartIcon.click();
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(8000);
		wishlist.click();
		
	}
	
	public void removeFromWishlist() {
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		wishlist.click();
		delete.click();
		confirmDelete.click();
	}
	
	public void yourOrders() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();

		Thread.sleep(8000);
		orders.click();
	}
	
	public void superCoin() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(10000);
		coins.click();
	}
	
	public void flipkartLogo() {
		flipkart.click();
	}
	public void flipkartPlusZone() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(5000);
		pluszone.click();
		
	}
	public void getCoupons() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(8000);
		coupons.click();
		//viewCoupons.click();
	}
	public void flipkartNotifications() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(8000);
		notification.click();
		
	}
	public void productFilterType() throws InterruptedException {
		producttype.click();
		
	}
	
	public void nextpage() throws InterruptedException {
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(nextpage).perform();
		Thread.sleep(8000);
		nextpage.click();
		
	}
 
}
