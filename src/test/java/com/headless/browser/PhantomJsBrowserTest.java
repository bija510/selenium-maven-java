package com.headless.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PhantomJsBrowserTest {


	@Test
	public void PhantonJSBrowser() {
   /********************************************************************************************
    * NOTE I TRY THIS DEPENDENCY IN POM.XML CAUSE PROBLEM NOT ABLE TO RUN ANY TEST CASE NEITHER TESTNG.XML FILE
    * java.lang.NoClassDefFoundError: org/w3c/dom/ElementTraversal
    * And all skip in testng.xml file
    * import org.openqa.selenium.phantomjs.PhantomJSDriver;
    
	<!-- https://mvnrepository.com/artifact/com.codeborne/phantomjsdriver -->
	<dependency>
	    <groupId>com.codeborne</groupId>
	    <artifactId>phantomjsdriver</artifactId>
	    <version>1.4.4</version>
	</dependency>
   **********************************************************************************************
	WebDriverManager.phantomjs().setup();
	WebDriver driver = new PhantomJSDriver();
			
	driver.get("https://www.google.com/");
	WebElement googlePageLebel = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	System.out.println(googlePageLebel.getText());
	**********************************************************************************************/	
		
	}
}
