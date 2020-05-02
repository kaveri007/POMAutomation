package com.crm.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.pages.WhiteBoxLoginPage;

import junit.framework.Assert;

public class WhiteBoxLoginTest extends WhiteBoxLoginPage  {
 
	public WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
			 driver=new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://www.whiteboxqa.com/");
	}
	
	@Test
	public void verifyPageUrlTest()
	{
		String url=driver.getCurrentUrl();
	     Assert.assertEquals(url,"http://www.whiteboxqa.com/" );
	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
