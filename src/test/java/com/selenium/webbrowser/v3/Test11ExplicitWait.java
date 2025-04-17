package com.selenium.webbrowser.v3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test11ExplicitWait extends Base{
	
	@Test
	public void TestMethod01() {	
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		WebElement btn_start = driver.findElement(By.cssSelector("[id='start'] button"));
		btn_start.click();
		
		WebDriverWait ExplicitWait = new WebDriverWait(driver,Duration.ofSeconds(20));// Selenium-4
		WebElement lbl_Hello = ExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='finish'] h4")));	
		
		System.out.println(lbl_Hello.getText());
	}

	@Test
	public void TestMethod02() {
		driver.get("http://demo.automationtesting.in/Loader.html");
		WebElement btn_run= driver.findElement(By.xpath("//button[normalize-space()='Run']"));
		btn_run.click();
		
		WebDriverWait ExplicitWait1 = new WebDriverWait(driver,Duration.ofSeconds(20));	
		//ExplicitWait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-default']")));
		ExplicitWait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-default']")));
		WebElement btn_closeAlert = driver.findElement(By.cssSelector("button[class='btn btn-default']"));
		
		btn_closeAlert.click();
		
	}
	
	
}
