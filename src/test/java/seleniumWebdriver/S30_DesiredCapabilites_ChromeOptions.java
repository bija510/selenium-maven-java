package seleniumWebdriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S30_DesiredCapabilites_ChromeOptions{
	
	/********************************************************
	 * For the official documentation please visit this page.
	 * https://chromedriver.chromium.org/capabilities
	 *********************************************************/
	@Test
	public void Test_AcceptInsecureCerts() {   
		WebDriverManager.chromedriver().setup();
		
		//To accept the Insecure certificate when we try to open URL it pop up first we have to accept that.
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true); //make false to disable
		WebDriver driver = new ChromeDriver(cap);	
		
		driver.get("https://www.facecook.com");

	}
	
	@Test
	public void Test_MergeChromeOptions_with_desiredCapabilities() {   
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true);
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--start-maximized");
		//option.addArguments("start-fullscreen");
		option.merge(cap);
		
		WebDriver driver = new ChromeDriver(option);	
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}
	
	@Test
	public void browserMobileMode() {
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "iPhone X");//Nexus 5
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		//Injecting the Capabilities in the ChromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
	}
	
	
	@Test
	public void downloadFile_withoutPopUp() throws InterruptedException {
		
		FirefoxProfile fxProfile = new FirefoxProfile();
		fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/plain,application/pdf");
		fxProfile.setPreference("browser.download.manager.showWhenStarting",false);
		fxProfile.setPreference("pdfjs.disabled", true);
		
		FirefoxOptions option=  new FirefoxOptions();
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
	public void downloadFileToDesiredLocation() throws AWTException {
	/****************************************************************************
	 * HELP:-Stackoverflow :- how to change file download location in Webdriver while using chrome driver/firefox driver
	 * DesiredCapabilities class is ===merge into===ChromeOptions class
	 * Before this now just replace with ChromeOptions in DesiredCapabilities
	 ****************************************************************************/
		WebDriverManager.chromedriver().setup();
		String downloadFilepath = System.getProperty("user.dir")+  "\\Screenshot\\"; 
		
		Map<String, Object> preferences = new Hashtable<String, Object>();
		preferences.put("profile.default_content_settings.popups", 0);
		preferences.put("download.prompt_for_download", "false");
		preferences.put("download.default_directory", downloadFilepath);
		preferences.put("plugins.plugins_disabled", new String[]{"Adobe Flash Player", "Chrome PDF Viewer"});// disable flash and the PDF viewer
        
		// ====================Using ChromeOptions============================================
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(ChromeOptions.CAPABILITY, options);
		
		// ====================Injecting ChromeOptions options to WebDriver====================
		WebDriver driver = new ChromeDriver(options);
		
		// ====================Open Url & click on download file ==============================
		driver.get("http://admin:admin@the-internet.herokuapp.com//download_secure");
		driver.manage().window().maximize();
		WebElement massaMCNtxtFile =driver.findElement(By.xpath("//a[normalize-space()='massa MCN.txt']"));
		massaMCNtxtFile.click();
		
		// ====================Handeling open window using Robot class Not required=============
		/*******************************************************	
		Robot rb = new Robot();
		rb.setAutoDelay(2000); // Similar to thread.sleep
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.setAutoDelay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		*******************************************************/
		
	}

}

