package com.crmqa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	
	public  WebDriver driver;
	public static Properties prop;
	public TestBase()
	{
		
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\kakum\\eclipse-workspace\\POMAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		    prop.load(ip);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public  void initialization()
	{
	  String browsername=prop.getProperty("browser");
	  if(browsername.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\kakum\\eclipse-workspace\\POMAutomation\\Driver\\chromedriver.exe");
     	  driver= new ChromeDriver();
	  }
	  
	  else if(browsername.equals("Firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver","C:\\Users\\kakum\\OneDrive\\Desktop\\newchrome\\geckodriver.exe\\");
     	  driver= new FirefoxDriver();
	  }
	  
	  driver.manage().window().maximize();
	  driver.manage().getCookies();
	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	  
	  
	  driver.get(prop.getProperty("url"));
	  
	}
}




