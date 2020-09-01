package demoAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessPhantomJsBrowser {


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
