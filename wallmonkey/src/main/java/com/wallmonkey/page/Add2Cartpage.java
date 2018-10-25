package com.wallmonkey.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sun.org.apache.xml.internal.security.Init;
import com.wallmonkey.utility.Utility;

public class Add2Cartpage extends Utility
{

	public Add2Cartpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//Search text box at the home screen
	@FindBy(how = How.XPATH, using="(//input[@type='search'])[5]")
	WebElement Search;


	public void additemtocart() throws Exception
	{
		System.out.println("We are in add Item to cart method");
		
		Search.sendKeys(getproperties("Search1"));
		Thread.sleep(5000);
		Search.sendKeys(getproperties("Search2"));
		Thread.sleep(5000);
		 
		
	//Suggestsion text after enter the character at search
		List<WebElement> suggestion = driver.findElements(By.xpath("//li[@style='cursor: pointer;']"));
		System.out.println("Number of option in suggestion: " +suggestion.size());
		for(WebElement x: suggestion)
		{
			System.out.println("Option: " +x.getText());
			if(x.getText().equals(getproperties("selectedsuggestion")))
			{
				x.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		
	}
}
