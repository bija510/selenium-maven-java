package com.testng.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestDemo1 {

	private WebDriver driver;
	
	@Test
	public void test_getTitle() {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/signup");
		System.out.println("Title : "+ driver.getTitle());
		
	}
	
	@AfterMethod
	public void cleanUp() {
		System.out.println("Class TestDemo1 Executed....");
		if(driver!= null) {
			driver.quit();
		}
	}
}
