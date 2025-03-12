package com.selenium.webbrowser.v3;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test32ContinueOnAlreadyOpenBrowser {
	
	@Test
	public void continueOnBrowserOpenBy_AutomationScript_Part1() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Capabilities cap = driver.getCapabilities();
		Map<String, Object> asMap = cap.asMap();
		asMap.forEach((key,value)->{
			System.out.println("Key " + key + " Value "+ value);
		});
		
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("David");
		
	}

	@Test
	public void continueOnBrowserOpenBy_AutomationScript_part2() {
	/****************************************************************
	 Need to pass ==50564== port number after running the first test &
	 copy {debuggerAddress=localhost:50564} from===CONSOLE===
	****************************************************************/
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:50564" );
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options); //==>for 
		Capabilities cap = driver.getCapabilities();
		Map<String, Object> asMap = cap.asMap();
		asMap.forEach((key,value)->{
			System.out.println("Key " + key + " Value "+ value);
		});
		
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Johnson");

	}
	
	
	public void continueIn_ManuallyOpenBrowser() {
		
	}
}
