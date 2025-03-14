package com.testng.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.utils.Base;

@Listeners(com.testng.demo.Test09listener.class)

public class Test08Asserts extends Base{

	@Test
	public void assertDemo() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//Example:- 1
		WebElement option1TxtBx = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));	
		Assert.assertFalse(option1TxtBx.isSelected());

		//Example:- 2
		WebElement showHideTxtBx = driver.findElement(By.xpath("//input[@id='displayed-text']"));	
		Assert.assertTrue(showHideTxtBx.isDisplayed());
		
		//Example:- 3
		String actTitle = "Practice Page";
		Assert.assertEquals(actTitle, driver.getTitle());
		
		//Example:- 4
		String aFor = "apple";
		String bFor = "ball";
		Assert.assertNotEquals(aFor,  bFor);
		
//		Assert.fail();
		Assert.fail("==========Not found or any message this will fail testcase============");
		
		System.out.println("All Example 1, 2, 3 & 4 Passes Successfully");
		
		
	}
}
