package com.up.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.up.qa.base.TestBase;
import com.up.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		intiliazation();
	}
	
	@Test
	public void loginValidation() throws IOException {
		loginPage = new LoginPage();
		loginPage.validateLoginbutton(prop.getProperty("username"),prop.getProperty("password"));
		String errorText = loginPage.validateErrorMessage();
		Assert.assertEquals(errorText, "invalid username","Text is incorrect");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
