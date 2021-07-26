package com.up.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.up.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
	public SignUpPage() throws IOException {
		PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//a[contains(text(),'Sign up for free.')]")
WebElement clickonSignupLink;

@FindBy(xpath = "//input[@id='signup_username']")
WebElement emailId;

@FindBy(xpath = "//input[@id='signup_password']")
WebElement password;

@FindBy(xpath = "//input[@id='signup_firstname']")
WebElement fName;

@FindBy(xpath = "//input[@id='signup_lastname']")
WebElement lName;

@FindBy(xpath = "//input[@id='signup_companyPhone']")
WebElement phoneNumber;

@FindBy(xpath= "//input[@placeholder = 'Choose your business type']")
WebElement businessType;

@FindBy(xpath = "//input[@id='signup_companyname']")
WebElement comapnayName;

@FindBy(xpath = "//input[@id='signup_jobTitleLabel']")
WebElement title;

@FindBy(xpath = "//button[contains(text(),'Start using UpKeep')]")
WebElement clickOnstartUsingUpKeep;

public workOrderPage registerNewUser(String uname, String pass, String fN, String lN, String pNumber, String CName, String t) throws IOException {
	
	emailId.sendKeys(uname);
	password.sendKeys(pass);
	fName.sendKeys(fN);
	lName.sendKeys(lN);
	phoneNumber.sendKeys(pNumber);
	
//	Select s = new Select(driver.findElement(By.xpath("//div[@class = \"selectize-control ng-pristine ng-untouched ng-valid ng-isolate-scope single\"]")));
//	s.selectByIndex(2);
	businessType.sendKeys("Property Management");
	comapnayName.sendKeys(CName);
	title.sendKeys(t);
	return new workOrderPage();
}

}
