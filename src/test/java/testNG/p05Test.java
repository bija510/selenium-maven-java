package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class p05Test {

	WebDriver driver = null;
	@BeforeMethod
	public void start() {
		WebDriverManager.iedriver();
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
			
		}
	
	@Test
	public void test() {
		
		driver.get("https://www.youtube.com/");
	}
	
	@AfterMethod
	public void end() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
