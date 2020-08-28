package demoAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessBrowser {
 
	@Test
	public void headlessBrowserExecution() {
	WebDriverManager.chromedriver().setup();
	
	ChromeOptions option = new ChromeOptions();
	option.addArguments("headless");
	
	WebDriver driver = new ChromeDriver(option);
	driver.get("https://www.google.com/");
	WebElement googlePageLebel = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
	
	System.out.println(googlePageLebel.getText());
	
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
