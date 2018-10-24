package com.wallmonkey.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.sun.org.apache.xml.internal.security.Init;
import com.wallmonkey.utility.Utility;

public class Add2Cart extends Utility
{

	public Add2Cart(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void additemtocart()
	{
		System.out.println("We are in add Item to cart method");
	}
}
