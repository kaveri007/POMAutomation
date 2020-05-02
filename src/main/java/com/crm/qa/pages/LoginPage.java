package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmqa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input")
	WebElement username;
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input")
	WebElement password;
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/div[3]/a")
	WebElement signup;

    

	
//initializing page objects
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
		
		
	}

	//actions
	public String LoginPageValidation()
	{
		return driver.getTitle();
		
	}
	
	public HomePage login(String uname,String pas)
	{
		username.sendKeys("uname");
		password.sendKeys("pas");
		loginbtn.click();
		return new HomePage();
	}
}
