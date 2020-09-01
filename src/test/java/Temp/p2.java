package Temp;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilites_library.Xls_Reader;

public class p2 {
	
		@Test
		public void PhantonJSBrowser() {
		WebDriverManager.phantomjs().setup();
		WebDriver driver = new PhantomJSDriver();
				
		driver.get("https://www.google.com/");
		WebElement googlePageLebel = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(googlePageLebel.getText());
		
			
			
			
		}
	
}
