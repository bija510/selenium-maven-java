package zTemp;


import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test01 {

	/*****************************************************
	 * Docs:- https://chromedriver.chromium.org/mobile-emulation
	 ******************************************************/
	    @Test
		public void ChromeMobileEmulator_withSize() {
	    	Map<String, Object> deviceMetrics = new HashMap<>();
	    	deviceMetrics.put("width", 360);
	    	deviceMetrics.put("height", 640);
	    	deviceMetrics.put("pixelRatio", 3.0);
	    	Map<String, Object> mobileEmulation = new HashMap<>();
	    	mobileEmulation.put("deviceMetrics", deviceMetrics);
	    	//mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
	    	
	    	mobileEmulation.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0 Mobile/15E148 Safari/604.1");
		    
	    	ChromeOptions chromeOptions = new ChromeOptions(); 
	    	chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	    	
	    	WebDriverManager.chromedriver().setup();
	    	WebDriver driver = new ChromeDriver(chromeOptions);
	    	
	    	//Verify desired device open in Browser
			String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); //navigator.appVersion
			System.out.println("==>" + uAgent);
			System.out.println("Executed Device Name:- "+uAgent.substring(13, 37));
			
	    	driver.get("https://www.facebook.com/");
	    }

}
