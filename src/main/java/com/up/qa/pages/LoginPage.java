package com.up.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.up.qa.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath = "//a[@ui-sref = 'login.signup']")
//	WebElement clickonSignUpLink;
//	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement loginButton;
	
	
	@FindBy(xpath = "//div[contains(text(),'invalid username')]")
	WebElement invalidUsername;
	
	@FindBy(xpath = "//a[contains(text(),'Sign up for free.')]")
	WebElement clickonSignupLink;
	
	public String validateErrorMessage() {
		return invalidUsername.getText();
	}

	public void validateLoginbutton(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();	
	}
	
	public workOrderPage validateValidLogin(String u, String p) throws IOException {
		username.sendKeys(u);
		password.sendKeys(p);
		loginButton.click();	
		return new workOrderPage();
	}
	
	
	public SignUpPage clickOnSignUpLinks() throws IOException {
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@ui-sref = 'login.signup']")));

		return new SignUpPage();
	}
	
	
}
