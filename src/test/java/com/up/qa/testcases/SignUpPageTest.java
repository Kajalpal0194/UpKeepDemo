package com.up.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.up.qa.base.TestBase;
import com.up.qa.pages.LoginPage;
import com.up.qa.pages.SignUpPage;
import com.up.qa.pages.workOrderPage;
import com.up.qa.util.TestUtil;

public class SignUpPageTest extends TestBase {
	LoginPage loginPage;
	SignUpPage signUpPage;
	workOrderPage workOrderPage;
	
    String sheetName = "SignUpPage";
	
    public SignUpPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		intiliazation();
	    loginPage = new LoginPage();
	    signUpPage = loginPage.clickOnSignUpLinks();
		
	}
	
	@DataProvider
	public Object[][] getRegisterTestData() throws EncryptedDocumentException, IOException {
		Object [][] data = TestUtil.getTestData(sheetName);
		return data; 
	}
	
	@Test(dataProvider = "getRegisterTestData")
	public void registerNewuser(String email, String password, String fName, String lName, String mobileNumber, String comapnayName, String title) throws IOException {
		signUpPage.registerNewUser(email, password, fName, lName, mobileNumber,comapnayName,title);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
