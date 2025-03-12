package com.selenium.webbrowser.v3;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test11FluientWait {

	@Test
	public void fleuintWait() {
		/******************************************************************************************
		 * NOTE:- NO need to use this ===JUST USE EXPLICIT WAIT====
		 * Instead of this fluent wait we can use this method from Explicit wait
		 * Inside selenium use this code and giving us as one method like
		 * ExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocomplete")));
		 ******************************************************************************************/
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("[id='finish'] h4"));
				}else {
					return null;
				}
				
			}
		});
		
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
	}
}
