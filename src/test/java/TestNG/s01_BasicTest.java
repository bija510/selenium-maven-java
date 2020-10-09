package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class s01_BasicTest {
	/*************************************************************
	 * NOTE:- Always add Test at beginning or end of class name 
	 *************************************************************/
	WebDriver driver = null;
	
	@BeforeMethod()
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test()
	public void methodOne(){
		driver.get("https://www.facebook.com/");
	}
	
	@Test()
	public void methodTwo(){
		driver.get("https://www.walmart.com/");
	}
	
	@AfterMethod()
	public void tearDown(){
		driver.close();
		driver =null;
	}
	
	
}
