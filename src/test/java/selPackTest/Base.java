package selPackTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	WebDriver driver = null;
	
	@BeforeTest
	public void method_a() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	}
	
	@AfterTest
	public void method_z() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		driver = null;
		
	}
}
