package com.wallmonkey.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.wallmonkey.utility.Utility;

public class Registrationpage extends Utility
{
	
	String filepath ="C:\\GitRepository\\wallmonkey\\resources\\TestData.xlsx";
	//Login button at home page.
	@FindBy(how = How.XPATH, using="//a[@class='site-header__account']")
	WebElement login;
	
	//Create Account link at Login screen
	@FindBy(how = How.ID, using="customer_register_link")
	WebElement createaccount;
	
	//Create Account First Name.
	@FindBy(how = How.ID, using="FirstName")
	WebElement firstname;
	
	//Create Account Last name
	@FindBy(how = How.ID, using="LastName")
	WebElement lastname;
	
	public Registrationpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void createcustomer()
	{
		try
		{
		System.out.println("Inside the CreateCustomer");
		fluent_wait_by_visibility_of_element(login);
		login.click();
		fluent_wait_by_visibility_of_element(createaccount);
		createaccount.click();
		firstname.sendKeys(readfromexcel(filepath, "Data", "user3", "FirstName"));
		lastname.sendKeys(readfromexcel(filepath, "Data", "user3", "Email"));
		
		
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			System.out.println("In Side Create Customer Catch block");
			e.printStackTrace();
		}
		
	}

}
