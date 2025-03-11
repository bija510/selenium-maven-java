package seleniumWebdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilites_library.Base;

public class Test_28_Exceptions extends Base {

	@Test
	public void Test_NoSuchElementException() throws Exception {
		// ====================================================================
		try {
			driver.get("https://the-internet.herokuapp.com/iframe");
			// driver.switchTo().frame("mce_0_ifr");
			driver.findElement(By.id("tinymce")).sendKeys("Hello");

		} catch (NotFoundException e) {
			//System.out.println("=========NOT FOUND=UnCOMMENT E=====");
			//e.printStackTrace(); // This will print the details message if comment details MSG
			Assert.fail("===Not Found===");
		}
	}

	public void Test_NoAlertPresentException() {
		try {
			driver.get("https://the-internet.herokuapp.com/javascript_alerts");
			// driver.findElement(By.xpath("//button[normalize-space()='Click for JS
			// Alert']")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("==========NO ALERT==========");
			// e.printStackTrace(); // This is comment so no Details message will print
		}
	}

	@Test
	public void Test_NoSuchFrameException()  {
		try {
			driver.get("https://the-internet.herokuapp.com/iframe");
			driver.switchTo().frame("frame_11");
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test_NoSuchWindowException() { //comes under NotFoundException class.
		try {
			driver.get("https://the-internet.herokuapp.com/iframe");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.switchTo().window("fdfdafjl");
		}catch (NotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void Test_InvalidSelectorException() { //comes under NoSuchElementException
		try {
			driver.get("https://the-internet.herokuapp.com/iframe");
			driver.findElement(By.id("tinymce")).sendKeys("Hello");
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		}	
	}
}
