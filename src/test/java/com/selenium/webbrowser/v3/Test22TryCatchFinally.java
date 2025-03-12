package com.selenium.webbrowser.v3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test22TryCatchFinally extends Base{

	@Test
	public void tryCatch() throws InterruptedException {

		try {
			driver.get("https://www.facebook.com/signup");
			WebElement firstName = driver.findElement(By.xpath("//input[@id='u_0_n']"));
			firstName.sendKeys("subi");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			Thread.sleep(3000);
			driver.close();
		}

	}
	
	@Test
	public void exceptionHandeling() {	
		//====================================================================
		try{		
			driver.get("https://the-internet.herokuapp.com/iframe");
			//driver.switchTo().frame("mce_0_ifr");
			driver.findElement(By.id("tinymce")).sendKeys("Hello");
			
		}catch(NotFoundException e) {
			System.out.println("======ELEMENT NOT FOUND=====");
			e.printStackTrace(); //This will print the details message if comment details MSG
		}
		//====================================================================
		try {
			driver.get("https://the-internet.herokuapp.com/javascript_alerts");
			//driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
			Alert alert= driver.switchTo().alert();
			alert.accept();
		}catch(NoAlertPresentException e) {
			System.out.println("=======NO ALERT=======");
			//e.printStackTrace(); // This is comment so no Details message will print
		}
		//====================================================================
	
	}	

}
