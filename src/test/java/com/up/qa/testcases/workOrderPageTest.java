package com.up.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.up.qa.base.TestBase;
import com.up.qa.pages.LoginPage;
import com.up.qa.pages.SignUpPage;
import com.up.qa.pages.workOrderPage;

public class workOrderPageTest extends TestBase{

	LoginPage loginPage;
	SignUpPage signUpPage;
	workOrderPage workOrderPage;
	public workOrderPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
    
	@BeforeMethod
	public void setup() throws IOException {
		intiliazation();
	    loginPage = new LoginPage();
	    workOrderPage = loginPage.validateValidLogin("kajal.pal0194@gmail.com", "Newyear=05");	
	}
	
	@Test(priority = 1)
	public void clickOnAddWorkLink() throws InterruptedException, IOException {
		workOrderPage.clickOnAddWorkerOrder();
		workOrderPage.addWorkOrder("Coffee Machine Replacement", "Need to replace Coffee machine","5","Medium");
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
