package com.parallel.demo;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	private static BrowserFactory instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	private BrowserFactory() {

	}

	public static BrowserFactory getInstance() {
		if (instance == null) {
			instance = new BrowserFactory();
		}
		return instance;
	}

	public final void setDriver(String browser) throws Exception {

		DesiredCapabilities caps = null;

		if(browser.equalsIgnoreCase("chrome")) {
			
			ChromeOptions chOptions = new ChromeOptions();
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("credentials_enable_service", false);
			chOptions.setExperimentalOption("prefs", chromePrefs);
			chOptions.addArguments("--disable-plugins", "--disable-extensions", "--disable-popup-blocking");
			chOptions.setCapability("applicationCacheEnabled", false);
			//System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			webDriver.set(new ChromeDriver());
		}
	}

	public WebDriver getDriver() {
		return webDriver.get();
	}
}
