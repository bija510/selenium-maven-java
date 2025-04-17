package com.browser.mobile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qa.utils.MobileUtils;

public class SampleMobileDemoTest {

	@Test
	public void test_iphonex_mode() throws InterruptedException {
		WebDriver driver = new ChromeDriver(new MobileUtils().CapInjector("iPhone X"));
		driver.manage().window().maximize();

		String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); // navigator.appVersion
		System.out.println("Executed Device Name:- " + uAgent.substring(13, 37));

		driver.get("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//input[@type='text']")).click();
		
		Thread.sleep(2000);
		driver.quit();

	}

	@Test
	public void test_pixel7() throws InterruptedException {
		WebDriver driver = new ChromeDriver(new MobileUtils().CapInjector("Pixel 7"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Verify desired device open in Browser
		String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); // navigator.appVersion
		System.out.println("Executed Device Name:- " + uAgent.substring(13, 37));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);
		driver.close();
	}
}
