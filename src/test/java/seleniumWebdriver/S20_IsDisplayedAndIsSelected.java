package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilites_library.Base;

public class S20_IsDisplayedAndIsSelected extends Base{

	public void SelAndDesMethod() {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//Example:- 1
		WebElement option1TxtBx = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));	
		Assert.assertFalse(option1TxtBx.isSelected());

		//Example:- 2
		WebElement showHideTxtBx = driver.findElement(By.xpath("//input[@id='displayed-text']"));	
		Assert.assertTrue(showHideTxtBx.isDisplayed());
		
	}
	
	@Test
	public void isEnabled() {
		driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
		WebElement saveBtn = driver.findElement(By.xpath("//button[@id='demo']"));
		System.out.println("is Btn Enabled?:- " + saveBtn.isEnabled());
	}
}
