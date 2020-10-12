package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class S03_CrossBrowserTest {
	/**************************************
	 * This is called Cross-Browser Testing
	 * like Firefox, chrome, & IE
	 ***************************************/
	public static void main(String[] args) throws InterruptedException {
		
//	System.setProperty("webdriver.chrome.driver", "C:\Users\Bijaya Chhetri\eclipse-workspace\subi\Driver\chromedriver.exe");
//	WebDriver driver = new ChromeDriver();
	
//	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bijaya Chhetri\\eclipse-workspace\\subi\\Driver\\geckodriver.exe");
//  WebDriver driver = new FirefoxDriver();
	
    System.setProperty("webdriver.IE.driver", "C:\\Users\\Bijaya Chhetri\\eclipse-workspace\\subi\\Driver\\IEDriverServer.exe");
	WebDriver driver = new InternetExplorerDriver();
		
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	
	Thread.sleep(3000);
	
	driver.close();	
		
		
		
		
		
		
		
		
	}

}
