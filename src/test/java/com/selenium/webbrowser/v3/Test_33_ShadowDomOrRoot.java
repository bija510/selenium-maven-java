package com.selenium.webbrowser.v3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

/*****************************************************************************************************
 1 Docs:- https://github.com/sukgu/shadow-automation-selenium
 2 Shadow DOM is a web standard that offers component style and markup encapsulation. 
 3 It is a critically important piece of the Web Components story as it ensures that a component will work in any environment,
 4 even if other CSS or JavaScript is at play on the page.
 5 Custom HTML tags can't be directly identified with selenium tools. Using this plugin you can handle any custom HTML tags.
 6 xpath doesn't support
 7 shadow-root mode Either open or close, & always attached to some element.
 8.Avail for Python as well. and
 9. explicit and implicit wait can be use .....JUST FOR FOR THE DOCUMENTATION FOR MORE DETAILS
 ******************************************************************************************************/
/**************************************************************	
*=================This all don't work======================= 
driver.findElement(By.cssSelector("#input")).sendKeys("apple");
WebElement ele = driver.findElement(By.cssSelector("#input"));
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].value='apple';", ele);
***************************************************************/	
public class Test_33_ShadowDomOrRoot {

	@Test
	public void test_interact_element_insideShodowDom_root() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/");
		
	
		Shadow shadow = new Shadow(driver);
		shadow.findElement("#input").sendKeys("apple");	
	}
	
	@Test
	public void test_insideShodowDom_() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement input = (WebElement) (js.executeScript(
				"return document.querySelector(\"body > book-app\")"
				+ ".shadowRoot"
				+ ".querySelector(\"#input\")"));
		input.sendKeys("Victor automation");;
			
	}
}
