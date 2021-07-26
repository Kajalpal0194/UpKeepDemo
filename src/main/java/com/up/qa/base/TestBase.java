package com.up.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream ip;
	
	public TestBase() throws IOException
	{
	
		prop = new Properties();
		ip = new FileInputStream("C:\\Users\\Abhis\\eclipse-workspace\\UPKeep\\src\\main\\java\\com\\up\\qa\\config\\config.properties");
        prop.load(ip);		
	}

	
	public static void intiliazation() throws IOException {
		
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
//		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}
}
