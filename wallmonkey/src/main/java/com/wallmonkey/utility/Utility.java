package com.wallmonkey.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.wallmonkey.page.Add2Cart;
import com.wallmonkey.page.LoginPage;


public class Utility 
{
	
	public WebDriver driver;
	public LoginPage login_page;
	public Add2Cart Add2Cart_page;
	
	@BeforeTest
	public void driversetup()
	{
		launchrowser();
		
		//creating Object of the classes.
				login_page = new LoginPage(driver);
				Add2Cart_page = new Add2Cart(driver);
	}
	public void launchrowser()
	{	
		//Setup the browser 
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\workspace\\wallmonkey\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
						
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	
	
//*******************load properties file.********************************
	public String getproperties(String key)
	{
		Properties getprop = new Properties();
		try
		{
			
			
			File fp = new File("resources/config.properties");
			FileInputStream fis = new FileInputStream(fp);
			getprop.load(fis);
			fis.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getStackTrace());
		}
		return getprop.getProperty(key);
	}
//*************************Fluent wait **************************************
	public void fluent_wait_by_visibility_of_element(WebElement element)
	{
		
		Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(180)).pollingEvery(Duration.ofSeconds(5)).
						ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
		}
}
