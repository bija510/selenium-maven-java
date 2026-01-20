package com.selenium.webbrowser.v4;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test09Waits {

	@Test
	public void waitsDemo() {
		/**********************************************************************
		 * Please refer to this Official selenium Documentation
		 * https://www.selenium.dev/selenium/docs/api/java/deprecated-list.html
		 *********************************************************************/
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
//		WebDriverWait ExplicitWait = new WebDriverWait(driver,20); // Selenium 3 Depreciated
		WebDriverWait ExplicitWait = new WebDriverWait(driver,Duration.ofSeconds(20));// Selenium-4
		
//		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); // Selenium 3 Depreciated
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Selenium 3 Depreciated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement btn_start = driver.findElement(By.cssSelector("[id='start'] button"));
		btn_start.click();
		
		WebElement lbl_Hello = ExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='finish'] h4")));			
		System.out.println(lbl_Hello.getText());
	}
}
