package selPackTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAutomation extends Base {
	
	@Test
	public void method4() {
	driver.get("https://www.facebook.com/");
	WebElement userNameField = driver.findElement(By.xpath("//input[@id='email']"));
	userNameField.sendKeys("abc123");
	
	WebElement passwordField = driver.findElement(By.xpath("//input[@id='pass']"));
	passwordField.sendKeys("12345");	
	
//	WebElement loginButton = driver.findElement(By.xpath("//button[@id='u_0_b']"));
//	loginButton.click();	
	}
	
	@Test
	public void method5() {
	driver.get("https://www.facebook.com/");
	WebElement userNameField = driver.findElement(By.xpath("//input[@id='email']"));
	userNameField.sendKeys("abc123");
	
	WebElement passwordField = driver.findElement(By.xpath("//input[@id='pass']"));
	passwordField.sendKeys("12345");	
	
//	WebElement loginButton = driver.findElement(By.xpath("//button[@id='u_0_b']"));
//	loginButton.click();	
	}
	
	
}
