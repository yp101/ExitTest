package com.ExitTest.pages;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Set;



public class CartTest {
	
	WebDriver driver;
	public CartTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		}

	@FindBy(how=How.XPATH,using="//a[@title=\"Court Legacy Canvas Men's Shoes Sneakers For Men\"]")
	public WebElement product;
	
	@FindBy(how=How.XPATH,using="//a[normalize-space()='10']")
	public WebElement shoeSize;
	
	@FindBy(how=How.XPATH,using="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	public WebElement addtocart;
	
	@FindBy(how=How.XPATH,using="//div[normalize-space()='Remove']")
	public WebElement Remove;
	@FindBy(how=How.XPATH,using="//div[@class='_3dsJAO _24d-qY FhkMJZ']")
	public WebElement confirmRemove;
	
	@FindBy(how=How.XPATH,using="//div[normalize-space()='Save for later']")
	public WebElement savelater;
	
	@FindBy(how=How.CLASS_NAME ,using="_1LCJ1U")
	public WebElement message;
	
	@FindBy(how=How.XPATH,using="//span[normalize-space()='Size Chart']")
	public WebElement sizechart;
	
	@FindBy(how=How.XPATH ,using="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
	public WebElement later;     
	
	@FindBy(how=How.XPATH ,using="//div[@class='row _34iF8V']")
	public WebElement size; 
	
	public void clickProduct() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		product.click();
		
		Thread.sleep(2000);
		SwitchWindow switchWindow = new SwitchWindow(driver);
		switchWindow.toTitle("NIKE Court Legacy Canvas Men's Shoes Sneakers For Men - Buy NIKE Court Legacy Canvas Men's Shoes Sneakers For Men Online at Best Price - Shop Online for Footwears in India | Flipkart.com");
		Thread.sleep(2000);
		shoeSize.click();
		Thread.sleep(2000);
		addtocart.click();
	}
	
	
	public void clickprod() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		product.click();
		
		Thread.sleep(2000);
		SwitchWindow switchWindow = new SwitchWindow(driver);
		switchWindow.toTitle("NIKE Court Legacy Canvas Men's Shoes Sneakers For Men - Buy NIKE Court Legacy Canvas Men's Shoes Sneakers For Men Online at Best Price - Shop Online for Footwears in India | Flipkart.com");
		Thread.sleep(2000);
	}
	public void removeProduct() {
		Remove.click();
		confirmRemove.click();
	}
	
	public void saveForLater() {
		savelater.click();
	}
	
	public void clickSizeChart() {
		sizechart.click();
	}
	
	}
	

