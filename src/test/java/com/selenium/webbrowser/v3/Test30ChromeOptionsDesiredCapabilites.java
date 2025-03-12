package com.selenium.webbrowser.v3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test30ChromeOptionsDesiredCapabilites {

	/********************************************************
	 * For the official documentation please visit this page.
	 * https://chromedriver.chromium.org/capabilities DesiredCapabilites is
	 * depreciated & merged with ChromeOptions class
	 *********************************************************/

	@Test
	public void open_chrome_in_headless_mode() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
		System.out.println("Page Title>>>>" + driver.getTitle());
	}

	@Test
	public void open_chrome_maximized_and_in_incognito_mode() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-incognito");
		options.addArguments("--start-maximized");
		options.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
	}

	/*******************************************************************************
	 * What is an SSL certificate? 
	 * SSL(Secure Sockets Layer) is a standard security
	 * protocol that establishes a secure connection between the server and the
	 * client(browser). The information sent using an SSL certificate is encrypted
	 * and ensures that it delivers to the right server. It is a validator to the
	 * website�s identity and helps to keep hackers at bay.
	 ********************************************************************************/
	@Test
	public void Test_accept_insecure_certs() {
		WebDriverManager.chromedriver().setup();

		// To accept the Insecure certificate when we try to open URL it pop up first we
		// have to accept that.
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true); // make false to disable

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.facecook.com");

	}

	@Test
	public void Test_MergeChromeOptions_with_desiredCapabilities() {
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true);
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		// option.addArguments("start-fullscreen");
		option.merge(cap);

		WebDriver driver = new ChromeDriver(option);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}

	@Test
	public void chrome_browser_mobile_emulation_mode() {
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "iPhone X");// Nexus 5
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		// Injecting the Capabilities in the ChromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
	}

	@Test
	public void microsoft_edge_browser_mobile_emulation_mode() {
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "iPhone X");// Nexus 5
		EdgeOptions options = new EdgeOptions();
		options.setExperimentalOption("mobileEmulation", mobileEmulation);

		// Injecting the Capabilities in the EdgeDriver
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
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
	    
	@Test
	public void downloadFile_withoutPopUp() throws InterruptedException {

		FirefoxProfile fxProfile = new FirefoxProfile();
		fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");
		fxProfile.setPreference("browser.download.manager.showWhenStarting", false);
		fxProfile.setPreference("pdfjs.disabled", true);

		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(fxProfile);

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(option);
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.findElement(By.xpath("//*[@id='textbox']")).sendKeys("TestData For .txt");
		driver.findElement(By.xpath("//*[@id='createTxt']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='link-to-download']")).click();
	}

	@Test
	public void download_file_to_desired_location() throws AWTException {
		/****************************************************************************
		 * HELP:-Stackoverflow :- how to change file download location in Webdriver
		 * while using chrome driver/firefox driver DesiredCapabilities class is
		 * ===merge into===ChromeOptions class Before this now just replace with
		 * ChromeOptions in DesiredCapabilities
		 ****************************************************************************/
		WebDriverManager.chromedriver().setup();
		String downloadFilepath = System.getProperty("user.dir") + "\\Screenshot\\";

		Map<String, Object> preferences = new Hashtable<String, Object>();
		preferences.put("profile.default_content_settings.popups", 0);
		preferences.put("download.prompt_for_download", "false");
		preferences.put("download.default_directory", downloadFilepath);
		preferences.put("plugins.plugins_disabled", new String[] { "Adobe Flash Player", "Chrome PDF Viewer" });
		
		// disable flash and the PDF viewer Using ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(ChromeOptions.CAPABILITY, options);

		//Injecting ChromeOptions options to WebDriver
		WebDriver driver = new ChromeDriver(options);

		// Open Url & click on download file
		driver.get("http://admin:admin@the-internet.herokuapp.com//download_secure");
		driver.manage().window().maximize();
		WebElement massaMCNtxtFile = driver.findElement(By.xpath("//a[normalize-space()='massa MCN.txt']"));
		massaMCNtxtFile.click();

		//Handeling open window using Robot class Not required
		/*******************************************************
		 * Robot rb = new Robot(); rb.setAutoDelay(2000); // Similar to thread.sleep
		 * rb.keyPress(KeyEvent.VK_CONTROL); rb.keyPress(KeyEvent.VK_V);
		 * rb.keyRelease(KeyEvent.VK_CONTROL); rb.keyRelease(KeyEvent.VK_V);
		 * rb.setAutoDelay(2000); rb.keyPress(KeyEvent.VK_ENTER);
		 * rb.keyRelease(KeyEvent.VK_ENTER);
		 *******************************************************/

	}

	/**
	 * options.addArguments("load-extension=C:\\Users\\Bijaya
	 * Chhetri\\git\\katalon-java-groovy-selenium\\Include\\SelectorHub\\3.0.7_0");
	 * 
	 */
	@Test
	public void test_install_CRX_extension_or_disable_at_runtime() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		String extensionPath = System.getProperty("user.dir") + "/Include/SelectorsHub.crx";
		options.addExtensions(new File(extensionPath));
		// options.addArguments("--disable-extensions");

		options.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
	}

	@Test
	public void test_install_extension_using_local_folder_path() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		options.addArguments(
				"load-extension=C:\\Users\\Bijaya Chhetri\\git\\katalon-java-groovy-selenium\\Include\\SelectorHub\\3.0.7_0");
		options.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
	}

	@Test(description = "Default is NORMAL. Wait for the entire page is loaded or waits until the load event fire is returned.")
	public void pageLoadStrategy_normal() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://google.com");

	}
	
	@Test(description = "wait until the initial HTML document has been completely loaded and parsed, & discards loading of stylesheets, images and subframes.")
	public void pageLoadStrategy_eager() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://google.com");

	}
	
	@Test(description = "When set to none Selenium WebDriver only waits until the initial page is downloaded.")
	public void pageLoadStrategy_none() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://google.com");

	}
}
