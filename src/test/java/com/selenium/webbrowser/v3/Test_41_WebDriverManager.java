package com.selenium.webbrowser.v3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_41_WebDriverManager {

	/**
	 * GITHUB:- https://github.com/bonigarcia/webdrivermanager
	 * NEW DOCS :- https://bonigarcia.dev/webdrivermanager/
	 */
	private WebDriver driver;
	
	@Test(description = "This is before version 5.0")
	public void demo1() {
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
				
	}
	
	@Test(description = "This is after version 5.0")
	public void demo2() {	
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
				
	}
	
	@Test(description = "Injecting capabilities")
	
	public void demo3() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless=new");
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
				
	}
}
