package com.selenium.webbrowser.v3;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test12CalendarDatepicker extends Base {

	// Current Date
	Format f = new SimpleDateFormat("MM/dd/yyyy");
	String currentDate = f.format(new Date());

	// Current Time
    Format time=new SimpleDateFormat("hh:mm:ss aa");
	String currentTime = time.format(new Date());

	@Test
	public void EnableDatePicker1() {
		System.out.println(currentDate);
		System.out.println(currentTime);
		
		driver.get("http://demo.automationtesting.in/Datepicker.html"); // strDate.substring(3, 5)
		driver.findElement(By.xpath("//input[@id='datepicker2']")).click();
		List<WebElement> days = driver.findElements(By.tagName("td"));
		for (int i = 0; i < days.size(); i++) {
			if (days.get(i).getText().equalsIgnoreCase(currentDate.substring(3, 5))) {
				System.out.println(days.get(i).getText());
				days.get(i).click();
				break;
			}
		}
	}

	@Test
	public void EnableDatePickee2() {
		driver.get("http://demo.automationtesting.in/Datepicker.html");
		driver.findElement(By.xpath("//input[@id='datepicker2']")).sendKeys(currentDate);
	}
	
	@Test
	public void disabledDatePicker() {
		driver.get("http://demo.automationtesting.in/Datepicker.html");
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 WebElement disabledDateTxtBx = driver.findElement(By.xpath("//input[@id='datepicker1']"));
         js.executeScript("arguments[0].value='"+currentDate+"';", disabledDateTxtBx);
			
	}
}
