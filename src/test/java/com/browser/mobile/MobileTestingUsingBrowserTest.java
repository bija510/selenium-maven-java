package com.browser.mobile;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTestingUsingBrowserTest {

	@Test
	public void test_chrome_browser_mobile_emulation_mode() throws InterruptedException {

		/******************************************************************************************
		 * https://chromedriver.chromium.org/mobile-emulation
		 * https://mashtips.com/get-system-os-browser-version-java-selenium-webdriver/
		 * Disadvantage:-
		 * https://mobile1st.com/why-chrome-devtools-is-inaccurate-for-mobile-testing/
		 * a. Chrome mobile emulator uses a different rendering engine than either
		 * Safari on iOS or the native Android browser. b. The rendering engine is what
		 * takes some HTML and turns it into a web page that you can see and interact
		 * with on the screen. c. Chrome mobile emulator uses a different JavaScript
		 * engine from Safari in particular. d. Chrome uses V8 while Safari runs
		 * JavaScriptCore/Nitro.
		 *******************************************************************************************/

		// Setting up device = iPhone X
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "Pixel 2");// Nexus 5, iPhone X
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		// Injecting the Capabilities in the ChromeDriver
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();

		// Verify desired device open in Browser
		String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); // navigator.appVersion
		System.out.println("==>" + uAgent);
		System.out.println("Executed Device Name:- " + uAgent.substring(13, 37));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		Thread.sleep(3000);
		WebElement searchTxt = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		searchTxt.sendKeys("Admin");

		Thread.sleep(2000);
		driver.quit();

	}

	@Test
	public void test_edge_browser_mobile_emulation_mode() {
		WebDriver driver = null;
		try {
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "Pixel 2");// Nexus 5 , Pixel 2, iPhone X
			EdgeOptions options = new EdgeOptions();
			options.setExperimentalOption("mobileEmulation", mobileEmulation);

			// Injecting the Capabilities in the EdgeDriver
			driver = new EdgeDriver(options);

			// Verify desired device open in Browser
			String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); // navigator.appVersion
			System.out.println("==>" + uAgent);
			System.out.println("Executed Device Name:- " + uAgent.substring(13, 37));

			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.findElement(By.xpath("//input[@placeholder='Username']")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			driver.quit();
		}
	}

	/***********************************************************
	 * Doc:- https://chromedriver.chromium.org/mobile-emulation
	 * @throws InterruptedException 
	 ***********************************************************/
	@Test
	public void test_chromeMobileEmulator_withSize() throws InterruptedException {
		Map<String, Object> deviceMetrics = new HashMap<>();
		deviceMetrics.put("width", 360);
		deviceMetrics.put("height", 640);
		deviceMetrics.put("pixelRatio", 3.0);
		Map<String, Object> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceMetrics", deviceMetrics);
		mobileEmulation.put("userAgent",
				"Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		WebDriver driver = new ChromeDriver(chromeOptions);

		// Verify desired device open in Browser
		String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); // navigator.appVersion
		System.out.println("Executed Device Name:- " + uAgent.substring(13, 37));

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.quit();

	}
	
	
}
