package com.wallmonkey.test;

import org.testng.annotations.Test;

import com.wallmonkey.utility.Utility;

public class LoginTest extends Utility
{

	@Test(groups="Login", description="Test the login functionality with valid credentials")
	public void loginwithvalid()
	{
		
		login_page.login();
	}
}
