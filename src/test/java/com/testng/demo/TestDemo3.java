package com.testng.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestDemo3 {
	private WebDriver driver;
	@Test
	public void test_autoCompleteDemo() throws InterruptedException {
		driver =  new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		WebElement autoComplete = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		autoComplete.sendKeys("Chin");	
	}
	
	@AfterMethod
	public void cleanUp() {
		System.out.println("Class TestDemo3 Executed....");
		if(driver!= null) {
			driver.quit();
		}
	}
}
