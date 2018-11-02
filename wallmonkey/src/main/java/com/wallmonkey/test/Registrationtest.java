package com.wallmonkey.test;

import org.testng.annotations.Test;

import com.wallmonkey.utility.Utility;

public class Registrationtest extends Utility
{

	@Test(groups="Create Customer", description="Createcustomer")
	public void testcreateaccount()
	{
		driver.get(getproperties("baseurl"));
		Registrationpage_page.createcustomer();
	}
}
