package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class p04Test{

	WebDriver driver = null;
  
	@BeforeMethod
	public void start() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void test() {
		driver.get("https://www.amazon.com/");
	}

	@AfterMethod
	public void end() throws InterruptedException {
		Thread.sleep(3000);
		//driver.quit();
	}

















}
