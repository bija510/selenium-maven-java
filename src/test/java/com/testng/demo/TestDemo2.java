package com.testng.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestDemo2 {
	
	private WebDriver driver;

	@Test
	public void test_dropdownDemo() throws InterruptedException {
		driver =  new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement DDL = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select selectDDL = new Select(DDL);
		selectDDL.selectByIndex(2);	
	}
	
	@AfterMethod
	public void cleanUp() {
		System.out.println("Class TestDemo2 Executed....");
		if(driver!= null) {
			driver.quit();
		}
	}
}
