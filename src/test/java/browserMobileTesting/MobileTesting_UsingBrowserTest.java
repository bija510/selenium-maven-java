package browserMobileTesting;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileTesting_UsingBrowserTest {

	@Test
	public void mobileTesting() throws InterruptedException {
		
		/**************************************************************************
		 https://chromedriver.chromium.org/mobile-emulation		
		 https://mashtips.com/get-system-os-browser-version-java-selenium-webdriver/
		***************************************************************************/
		
		//Setting up device = iPhone X
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "iPhone X");//Nexus 5
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	
		//Injecting the Capabilities in the ChromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();

		//Verify desired device open in Browser
		String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); //navigator.appVersion
		System.out.println("Executed Device Name:- "+uAgent.substring(13, 37));
		
		driver.get("https://www.walmart.com");
		Assert.assertEquals(driver.getTitle(), "Walmart.com | Save Money. Live Better.");
		WebElement searchTxt =driver.findElement(By.xpath("//*[@id='global-search-input']"));
		searchTxt.sendKeys("microwave");
		searchTxt.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.quit();
			
		
		
	}
}
