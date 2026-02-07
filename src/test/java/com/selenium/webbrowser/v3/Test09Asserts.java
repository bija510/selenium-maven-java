package com.selenium.webbrowser.v3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.utils.Base;

@Listeners(com.testng.demo.Test09listener.class)

public class Test09Asserts extends Base {

	@Test
	public void verifyPracticePageAssertions() throws InterruptedException {
		/**********************************************************************
		 * Assertions Demo using TestNG
		 * ChromeDriver setup is handled in Base Class
		 **********************************************************************/

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// Example 1: Verify checkbox is NOT selected
		WebElement option1ChkBx = driver.findElement(By.id("checkBoxOption1"));
		Assert.assertFalse(option1ChkBx.isSelected(), "Checkbox Option1 should NOT be selected");

		// Example 2: Verify textbox is displayed
		WebElement showHideTxtBx = driver.findElement(By.id("displayed-text"));
		Assert.assertTrue(showHideTxtBx.isDisplayed(), "Textbox should be visible");

		// Example 3: Verify page title
		String expectedTitle = "Practice";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");

		// Example 4: Verify two strings are not equal
		String aFor = "apple";
		String bFor = "ball";
		Assert.assertNotEquals(aFor, bFor, "Strings should not be equal");

		// Uncomment below line ONLY if you want to force test failure
		// Assert.fail("Forced failure for testing purposes");

		System.out.println("All Examples 1, 2, 3 & 4 Passed Successfully");

	}
	
	
}
