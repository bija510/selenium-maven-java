package com.selenium.webbrowser.v3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test31MethodChainingA {

	WebDriver driver;
	
	public Test31MethodChainingA openUrl() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		return this;
	}
	
	public Test31MethodChainingA enterUserName() {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		return this;
	}
	
	public Test31MethodChainingA enterPassword() {
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		return this;
		
	}
	
	public Test31MethodChainingA clickLoginBtn() {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		return this;
	}
	
}


