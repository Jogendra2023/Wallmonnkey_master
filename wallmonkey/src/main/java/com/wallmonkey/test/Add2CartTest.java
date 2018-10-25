package com.wallmonkey.test;

import org.testng.annotations.Test;

import com.wallmonkey.utility.Utility;

public class Add2CartTest extends Utility
{

	@Test(groups="cart", description="Adding Item to Cart")
	public void additemtocart() throws Exception
	{
		driver.get(getproperties("baseurl"));
		Add2Cart_page.additemtocart();
	}
}
