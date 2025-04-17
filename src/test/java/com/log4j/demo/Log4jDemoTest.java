package com.log4j.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Log4jDemoTest{
	
	private static Logger logger = LogManager.getLogger(Log4jDemoTest.class);
	static WebDriver driver = null;
	
	@BeforeClass
	public static void setUp() {
		logger.info("We are trying to open Firefox driver");	
		driver = new ChromeDriver();
		
		logger.info("Firefox browser open successfully");
		
		driver.manage().window().maximize();
		logger.info("Window just got Maximize");
		
	}
	@Test
	public static void testOpenUrl() {
		driver.get("https://www.amazon.com/");
        logger.info("Amazon.com website got open");
	}

	@AfterClass
	public  static void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
        logger.info("--Passed Successfully--");
	}

}
