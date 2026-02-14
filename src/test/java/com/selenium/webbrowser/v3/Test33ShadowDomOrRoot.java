package com.selenium.webbrowser.v3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

/**
 * Example class demonstrating how to interact with Shadow DOM elements using Selenium.
 *
 * <p>Shadow DOM provides encapsulation for web components and requires accessing
 * the shadow root before locating internal elements. XPath does not directly
 * support Shadow DOM traversal.</p>
 */


public class Test33ShadowDomOrRoot {

	@Test
	public void InteractWithShadowDomUsing_nativeSeleniumApi() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/");
		
		WebElement host = driver.findElement(By.xpath("//book-app[@apptitle='BOOKS']"));
		SearchContext shadowRoot = host.getShadowRoot();
		shadowRoot.findElement(By.cssSelector("#input")).sendKeys("Selenium Shadow DOM");
	}
	
	@Test
	public void InteractWithShadowDomUsing_javascript() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement input = (WebElement) (js.executeScript(
				"return document.querySelector('body > book-app')"
				+ ".shadowRoot"
				+ ".querySelector('#input')")
		);
		
		input.sendKeys("Victor automation");
			
	}
}
