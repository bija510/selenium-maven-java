package com.selenium.webbrowser.v3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test17AutoComplete extends Base {
	@Test
	public void test_autoSuggest() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement autoSuggestTextBox = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		autoSuggestTextBox.sendKeys("nep");
		Thread.sleep(2000); //This needed otherwise this TC Fail
		autoSuggestTextBox.sendKeys(Keys.ARROW_DOWN);
		autoSuggestTextBox.sendKeys(Keys.ENTER);
					
	}
}
