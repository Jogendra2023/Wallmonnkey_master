package com.wallmonkey.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.wallmonkey.utility.Utility;

public class LoginPage extends Utility
{

//Login button at landing screen**************************************
	@FindBy(how = How.XPATH, using="//a[@class='site-header__account']")
	WebElement login;
	
//Email filed at login screen*****************************************
	@FindBy(how=How.ID, using="CustomerEmail")
	WebElement email;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login()
	{
		System.out.println("Inside the Login Page class");
		driver.get(getproperties("baseurl"));
		fluent_wait_by_visibility_of_element(login);
		login.click();
		fluent_wait_by_visibility_of_element(email);
	}
}
