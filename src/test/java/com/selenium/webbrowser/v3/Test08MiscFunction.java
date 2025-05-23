package com.selenium.webbrowser.v3;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test08MiscFunction extends Base{

	@Test
	public void miscFunct() throws InterruptedException {
		/**********************************************************************
		 * From here no more Writing ChromeDriver setUp instead extends to Base 
		 **********************************************************************/
			
		driver.get("https://www.facebook.com/login/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		System.out.println( "Current Url:- " + driver.getCurrentUrl() );
		System.out.println( "Current page title:- " + driver.getTitle() );
		System.out.println( "Current window Number(handles):- " + driver.getWindowHandle() );
		
		driver.findElement(By.xpath("//button[@id='loginbutton']")).submit(); //To submit the Just for form & Enter
	
	}
	
	@Test
	public void GetTotalLinksAndName() {
		driver.get("https://www.facebook.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("==>"+links.size());
		int a = 1;
		for(WebElement link : links) {
			if(link.getText().length()>0) {
				System.out.println(a++ + " "+ link.getText()+ "==>"+link.getDomAttribute("href"));
			}
		}
		
	}
}
