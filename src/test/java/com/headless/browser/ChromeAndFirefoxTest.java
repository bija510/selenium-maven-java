package com.headless.browser;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qa.utils.CommonUtils;

public class ChromeAndFirefoxTest {
	/****************************************************************************
	 * Advantage >>-->Fast and usually good in CICD Jenkin it got performed
	 * Disadvantage >>--> hard to debug no UI, no user used App without UI,
	 * >>-->managing to take screenshot
	 ****************************************************************************/
	private WebDriver driver;
	
	@Test
	public void test_chrome_headless() throws IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		// option.setHeadless(true);
		driver = new ChromeDriver(option);

		driver.get("https://www.google.com/");
		System.out.println("Page Title : " + driver.getTitle());
	}

	@Test
	public void test_firefox_headless() throws IOException {
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("--headless");
		// option.setHeadless(true);
		driver = new FirefoxDriver(option);

		driver.get("https://www.google.com/");
		System.out.println("Page Title : "+driver.getTitle());

	}

	@AfterMethod
	public void cleanup() throws IOException {
		String getTimeStamp = CommonUtils.getTimeStamp();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("../selenium-maven-java/Screenshot/" +getTimeStamp+ "headlessSshot.png"));// result+result.getName()
		
		System.out.println("Closing the Browser");
		
		if(driver!= null) {
			driver.quit();
		}
		
	}

}
