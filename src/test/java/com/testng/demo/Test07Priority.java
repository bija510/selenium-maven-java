package com.testng.demo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(com.testng.demo.Test09listener.class)

public class Test07Priority extends Base {
	
	@BeforeMethod()
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(priority=1)
	public void methodA() {
		driver.get("https://www.facebook.com/");
		System.out.println("["+driver.getCurrentUrl()+"]");
	}

	@Test(priority = 3)
	public void methodB() {
		driver.get("https://www.walmart.com/");
		System.out.println("["+driver.getCurrentUrl()+"]");
	}

	@Test(priority = 2)
	public void methodC() {
		driver.get("https://www.amazon.com/");
		System.out.println("["+driver.getCurrentUrl()+"]");
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
