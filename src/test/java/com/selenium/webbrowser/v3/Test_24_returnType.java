package com.selenium.webbrowser.v3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_24_returnType {

	public WebDriver driverForChrome() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		return driver;	
	}
	public String dataFName() {
		String fName= "Ram";
		return fName;
	}
	
	public WebElement setFirstName(WebDriver driver) {
		WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		return firstNameTextBox;
	}
	
	@Test
	public void pagetab() {
		WebDriver driver = driverForChrome();
		driver.get("http://demo.automationtesting.in/Register.html");
		
		// setFirstName(driver) = sending driver & receiving WebElement
		setFirstName(driver).sendKeys( dataFName() );

		WebElement lastNameTextBox = driver.findElement(By.cssSelector("input[placeholder='Last Name'"));
		lastNameTextBox.sendKeys("sharma");
		driver.quit();
		
	}
}
