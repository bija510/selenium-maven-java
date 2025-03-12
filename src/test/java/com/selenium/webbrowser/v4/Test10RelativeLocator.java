package com.selenium.webbrowser.v4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.*;



public class Test10RelativeLocator {

	/*
	 * This are the 5 different locator supported in Selenium 4 this are called
	 * friendly locator below(), toLeftOf(), toRightOf(), above(), near()
	 */
	private static WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void test_toLeftOf_toRightOf() throws InterruptedException {
		driver.get("https://qaclickacademy.github.io/protocommerce/"); // 
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(1000);
		
		driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(By.xpath("//label[normalize-space()='Check me out if you Love IceCreams!']"))).click();
		Thread.sleep(1000);
		
		System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).toRightOf(By.cssSelector("#exampleCheck1"))).getText());
		Thread.sleep(1000);
		
				
	}
	
	public void test_above_below() throws InterruptedException {
		driver.get("https://qaclickacademy.github.io/protocommerce/"); // 
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(1000);
		
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.cssSelector("label[for='dateofBirth']"))).sendKeys("01/01/2021");
		driver.findElement(RelativeLocator.with(By.tagName("input")).straightBelow(By.cssSelector("label[for='dateofBirth']"))).sendKeys("01/01/2021");
		
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.xpath("//label[normalize-space()='Check me out if you Love IceCreams!']"))).click();
		driver.findElement(RelativeLocator.with(By.tagName("input")).straightAbove(By.xpath("//label[normalize-space()='Check me out if you Love IceCreams!']"))).click();

		Thread.sleep(1000);
	}
	
	public void test_near() throws InterruptedException {
		driver.get("https://qaclickacademy.github.io/protocommerce/"); // 
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(1000);
		
		driver.findElement(RelativeLocator.with(By.tagName("input")).near(By.xpath("//label[normalize-space()='Check me out if you Love IceCreams!']"))).click();

		Thread.sleep(1000);
	}
	
	
}
