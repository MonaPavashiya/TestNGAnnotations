package com.annotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Annontations 
{
	WebDriver driver;
	
	@BeforeSuite  
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
				"C:/Users/mS/Documents/MonaQAjars/WebDrivers/chromedriver.exe");
	}
	@BeforeTest 
	public void launchBrowser() {
       driver = new ChromeDriver();
	}
	
	@BeforeClass 
	public void ready() {
		System.out.println("Ready to use");
	}
	
	@BeforeMethod
	public void enterURL() {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void login() {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}
	
	@AfterMethod 
	public void logOut() {
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
	}
	
	@AfterClass  
	public void deleteAllCookies() {
       driver.manage().deleteAllCookies();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void done() {
		System.out.println("Done with annotations");     
	}
}
