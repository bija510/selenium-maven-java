package com.selenium.webbrowser.v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test38RemoveChromeAutomationMessage {

	@Test
	public void remove_Chrome_controlled_by_automated_test_software_message() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//Way1
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
//		//Way2
//		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
//		
//		//Way3
//		options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
//		
//		//Way4
//		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//		
//		//Way5
//		List<String> eSwitches = new ArrayList<>();
//		eSwitches.add("enable-automation");	
//		options.setExperimentalOption("excludeSwitches", eSwitches);
		
		//Use any of the one way from above 5ways and comment/remove the remaining 4ways
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");		
		
	}
}
