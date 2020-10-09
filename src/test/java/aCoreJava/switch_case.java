package aCoreJava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class switch_case {

	public static void main(String[] args) {
	
		String x = "IEhh";
		
		switch(x) {
		
		case "chrome" :
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bijaya Chhetri\\eclipse-workspace\\subi\\Driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com/");
			break;
			
		case "firefox" :

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bijaya Chhetri\\eclipse-workspace\\subi\\Driver\\geckodriver.exe");
		    WebDriver driver2 = new FirefoxDriver();
		    driver2.manage().window().maximize();
			driver2.get("https://www.walmart.com/");
			break;
			
		case "IE" :

		    System.setProperty("webdriver.IE.driver", "C:\\Users\\Bijaya Chhetri\\eclipse-workspace\\subi\\Driver\\IEDriverServer.exe");
			WebDriver driver3 = new InternetExplorerDriver();
			driver3.manage().window().maximize();
			driver3.get("https://www.amazon.com/");
			break;
			
		default :
			System.out.println("==========nothing match================");
		
		}
	
	}

}
