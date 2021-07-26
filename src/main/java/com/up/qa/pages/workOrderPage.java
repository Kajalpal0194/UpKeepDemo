package com.up.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.up.qa.base.TestBase;

public class workOrderPage extends TestBase{
	Actions a = new Actions(driver);
	public workOrderPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@class = 'styled__AutoHeightButton-sc-18kdwn2-16 erEbDM styled__Wrapper-sc-6m8pxr-0 dJSzjo']")
	WebElement workOrderLink;
	
	@FindBy(xpath= "//input[@placeholder='Title']")
	WebElement title;
	
	@FindBy(xpath= "//textarea[@placeholder='Description']")
	WebElement Desccription;
	
	@FindBy(xpath = "//div[@class = 'css-1hwfws3']")
    WebElement recurringSchedule;
	
	@FindBy(xpath = "//input[@placeholder = 'Hours']")
	WebElement estimatedDuration;
	
	@FindBy(xpath = "//label[@for = 'file-upload-input']")
	WebElement uploadImage;
	
	
	@FindBy(xpath = "//button[@aria-label = 'Select date']")
	static
	WebElement clickOnCalender;
	
	@FindBy(xpath = "//span[@class = 'rw-i rw-i-chevron-right']")
	static
	WebElement clickOnNextForwardButton;
	
	@FindBy(xpath = "//button[@id = 'rw_1_date_calendar_label']")
	static
	WebElement yearLablel;
	
	@FindBy(xpath = "//div[@value = 'MEDIUM']")
	WebElement priority;
	
	@FindBy(xpath = "//div[text()='Category']")
	WebElement category;
	
	@FindBy(xpath = "//div[text()= 'Assigned To']")
	WebElement worker;
	
	
	@FindBy(xpath = "//div[text()= 'Additional Workers']")
	WebElement additionalWork;
	
	@FindBy(xpath = "//div[text()= 'Team']")
	WebElement team;
	
	@FindBy(xpath = "//div[@class = 'css-1hwfws3 react-select__value-container react-select__value-container--has-value']")
	WebElement location;
	
	@FindBy(xpath = "//div[@class = 'css-dvua67-singleValue react-select__single-value']")
    WebElement asset;
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submitWorkOrder;
	
	public WorkOrderNewPage clickOnAddWorkerOrder() {
		workOrderLink.click();
		return new WorkOrderNewPage();
	}
	
	
	public workOrderPage addWorkOrder(String t, String d, String h,String priority) throws InterruptedException, IOException {
		title.sendKeys(t);

		Desccription.sendKeys(d);

		scheduleDate();
		
		a.sendKeys(Keys.TAB);
		a.moveToElement(recurringSchedule).sendKeys("Daily");
		a.moveToElement(recurringSchedule).sendKeys(Keys.ENTER).build().perform();	
		
		estimatedDuration.sendKeys(h);
		schedulePriority(priority);
		
		a.sendKeys(Keys.TAB);
		a.moveToElement(category).sendKeys("Insp").sendKeys(Keys.ENTER).build().perform();
		
		a.sendKeys(Keys.TAB);
		a.moveToElement(worker).sendKeys("Kajal").sendKeys(Keys.ENTER).build().perform();
		
		a.sendKeys(Keys.TAB);
		a.moveToElement(additionalWork).sendKeys("Kajal").sendKeys(Keys.ENTER).build().perform();
		
		a.sendKeys(Keys.TAB);
		a.moveToElement(team).sendKeys("Kajal").sendKeys(Keys.ENTER).build().perform();
		
		a.sendKeys(Keys.TAB);
		a.moveToElement(location).sendKeys("Floor").sendKeys(Keys.ENTER).build().perform();
		
		a.sendKeys(Keys.TAB);
		a.moveToElement(asset).sendKeys("Coffee").sendKeys(Keys.ENTER).build().perform();
		
		
		submitWorkOrder.click();
		
		return new workOrderPage();
		
	}
	
	public static void scheduleDate() {
		clickOnCalender.click();
		while(yearLablel.getText().contains("August 2022")) {
			clickOnNextForwardButton.click();
		}
		int count = driver.findElements(By.xpath("//td[@role = 'gridcell']")).size();
		for(int i=0;i<count;i++) {
			String date =   driver.findElements(By.xpath("//td[@role = 'gridcell']")).get(i).getText();
			if(date.equals("27")) {
				driver.findElements(By.xpath("//td[@role = 'gridcell']")).get(i).click();
			}
		}
	}
	
	
	public static void schedulePriority(String p) {
		int priorities = driver.findElements(By.xpath("//div[@name = 'priority']")).size();
		for(int i=0;i<priorities;i++) {
			String priorityText = driver.findElements(By.xpath("//div[@name = 'priority']")).get(i).getText();
			System.out.println(priorityText);
			if(priorityText.equals(p)) {
				driver.findElements(By.xpath("//div[@name = 'priority']")).get(i).click();
			}
		}
		
	}

}
