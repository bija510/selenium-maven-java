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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileTesting_UsingBrowserTest {

	@Test
	public void chrome_browser_mobile_emulation_mode() throws InterruptedException {
		
		/******************************************************************************************
		 https://chromedriver.chromium.org/mobile-emulation		
		 https://mashtips.com/get-system-os-browser-version-java-selenium-webdriver/
		 Disadvantage:- https://mobile1st.com/why-chrome-devtools-is-inaccurate-for-mobile-testing/
		 a. Chrome mobile emulator uses a different rendering engine than either Safari on iOS or the native Android browser.
		 b. The rendering engine is what takes some HTML and turns it into a web page that you can see and interact with on the screen.
		 c. Chrome mobile emulator uses a different JavaScript engine from Safari in particular.
		 d. Chrome uses V8 while Safari runs JavaScriptCore/Nitro.
		*******************************************************************************************/
		
		//Setting up device = iPhone X
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "Pixel 2");//Nexus 5, iPhone X
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	
		//Injecting the Capabilities in the ChromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();

		//Verify desired device open in Browser
		String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); //navigator.appVersion
		System.out.println("==>" + uAgent);
		System.out.println("Executed Device Name:- "+uAgent.substring(13, 37));
		
		driver.get("https://www.walmart.com");
		Assert.assertEquals(driver.getTitle(), "Walmart.com | Save Money. Live Better.");
		WebElement searchTxt =driver.findElement(By.xpath("//*[@id='global-search-input']"));
		searchTxt.sendKeys("microwave");
		searchTxt.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.quit();
	
	}


	@Test
	public void microsoft_edge_browser_mobile_emulation_mode() {
		WebDriver driver = null;
		try {
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "Pixel 2");// Nexus 5 , Pixel 2, iPhone X
			EdgeOptions options = new EdgeOptions();
			options.setExperimentalOption("mobileEmulation", mobileEmulation);
	
			// Injecting the Capabilities in the EdgeDriver
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);
			
			//Verify desired device open in Browser
			String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); //navigator.appVersion
			System.out.println("==>" + uAgent);
			System.out.println("Executed Device Name:- "+uAgent.substring(13, 37));
			
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com");
			
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}finally {
			driver.quit();
		}
	}
	

	/***********************************************************
	 * Doc:- https://chromedriver.chromium.org/mobile-emulation
	 ***********************************************************/
	    @Test
		public void ChromeMobileEmulator_withSize() {
	    	Map<String, Object> deviceMetrics = new HashMap<>();
	    	deviceMetrics.put("width", 360);
	    	deviceMetrics.put("height", 640);
	    	deviceMetrics.put("pixelRatio", 3.0);
	    	Map<String, Object> mobileEmulation = new HashMap<>();
	    	mobileEmulation.put("deviceMetrics", deviceMetrics);
	    	mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
	    	ChromeOptions chromeOptions = new ChromeOptions(); 
	    	chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	    	
	    	WebDriverManager.chromedriver().setup();
	    	WebDriver driver = new ChromeDriver(chromeOptions);
	    	
	    	//Verify desired device open in Browser
			String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); //navigator.appVersion
			System.out.println("Executed Device Name:- "+uAgent.substring(13, 37));
			
	    	driver.get("https://www.facebook.com/");
	    }
}
