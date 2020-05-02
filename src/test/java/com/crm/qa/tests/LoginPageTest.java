package com.crm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crmqa.base.TestBase;

import junit.framework.Assert;

public class LoginPageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage; 
	public LoginPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
		
		}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.LoginPageValidation();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
