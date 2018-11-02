package com.wallmonkey.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.wallmonkey.page.Add2Cartpage;
import com.wallmonkey.page.LoginPage;
import com.wallmonkey.page.Registrationpage;


public class Utility 
{
	
	public WebDriver driver;
	public LoginPage login_page;
	public Add2Cartpage Add2Cart_page;
	public Registrationpage Registrationpage_page;
	
	
	@BeforeMethod
	public void driversetup()
	{
		
		
		//creating Object of the classes.
				login_page = new LoginPage(driver);
				Add2Cart_page = new Add2Cartpage(driver);
				Registrationpage_page= new Registrationpage(driver);
	}
	
	@Parameters("browser")
	@BeforeTest
	public void launchbrowser(String browser)
	{	
		if(browser.equalsIgnoreCase("firefox"))
		{
		//Setup the browser 
		System.setProperty("webdriver.gecko.driver", "C:\\GitRepository\\wallmonkey\\Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		}	
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\GitRepository\\wallmonkey\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
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
	
//****************************Reading data from Excel sheet***************************************
	public String readfromexcel(String path,String sheet, String rowkey, String colkey)
	{
		String result = null;
		try
		{
			
			File fi = new File(path);
			FileInputStream fis = new FileInputStream(fi);
			 XSSFWorkbook wb = new XSSFWorkbook(fis);
			 XSSFSheet sh = wb.getSheet(sheet);
			 int rowcount = sh.getPhysicalNumberOfRows();
			 Row rw = sh.getRow(0);
			 int colcount = rw.getPhysicalNumberOfCells();
			 
			 	for(int i=0; i<rowcount; i++)
			 	{
			 		Row rw1 = sh.getRow(i);
			 		Cell cl1 = rw1.getCell(0);
			 		if(cl1.toString().equalsIgnoreCase(rowkey))
			 		{
			 			for(int j=0; j<colcount;j++)
			 			{
			 				Cell cl2 = rw.getCell(j);
			 				if(cl2.toString().equalsIgnoreCase(colkey))
			 				{
			 					result= sh.getRow(i).getCell(j).toString();
			 				}
			 			}
			 		}
			 	}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found" +e);
			e.printStackTrace();
		}
		catch(IOException e)
		{
			System.out.println("Input Output Exception" +e);
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	//************Mouse hover on the webelement*********
	public void mousehover(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
//*************************Fluent wait **************************************
	public void fluent_wait_by_visibility_of_element(WebElement element)
	{
		
		Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(300)).pollingEvery(Duration.ofSeconds(5)).
						ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
		}
}
