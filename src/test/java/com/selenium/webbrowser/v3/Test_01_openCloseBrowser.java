package com.selenium.webbrowser.v3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_01_openCloseBrowser {

	public static void main(String[] args) throws InterruptedException {	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.get("https://www.facebook.com/"); 	
		driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.linkText("Sign Up")).sendKeys(Keys.CONTROL, Keys.ENTER);
		
		Thread.sleep(4000);	
		//driver.close();	
		driver.quit();
	}
	
//	static void testing() throws InterruptedException {
//		main(null);
//	}

}
