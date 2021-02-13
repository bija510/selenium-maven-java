package seleniumWebdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S28_Exceptions {
	WebDriver driver;
	@Test
	public void ElementNotInteractableException_Test() {

		WebDriverManager.chromedriver().setup();
		//====================================================================
		try{
			driver= new ChromeDriver();
			driver.get("https://the-internet.herokuapp.com/iframe");
			//driver.switchTo().frame("mce_0_ifr");
			driver.findElement(By.id("tinymce")).sendKeys("Hello");
			
		}catch(NotFoundException e) {
			System.out.println("=========NOT FOUND=UnCOMMENT E=====");
			e.printStackTrace(); //This will print the details message if comment details MSG
		}
		//====================================================================
		try {
			driver.get("https://the-internet.herokuapp.com/javascript_alerts");
			//driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
			Alert alert= driver.switchTo().alert();
			alert.accept();
		}catch(NoAlertPresentException e) {
			System.out.println("==========NO ALERT==========");
			//e.printStackTrace(); // This is comment so no Details message will print
		}
		//====================================================================
	driver.quit();
	}	
	
}