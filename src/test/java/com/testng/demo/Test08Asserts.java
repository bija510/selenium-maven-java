package com.testng.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.qa.utils.Base;

@Listeners(com.testng.demo.Test09listener.class)

public class Test08Asserts extends Base {

	@Test(priority = 3)
	public void testHardAssert() {
		System.out.println("Test started");

		Assert.assertEquals(4 , 4); // Passes
		System.out.println("After first hard assert");

		Assert.assertTrue(2 > 3, "Condition failed"); // Fails and stops execution
		System.out.println("After second hard assert"); // This will NOT execute
	}

	@Test(priority = 1)
	public void testSoftAssert() {
		SoftAssert softAssert = new SoftAssert();

		System.out.println("Test started");

		softAssert.assertEquals(4, 4); // Passes
		System.out.println("After first soft assert");

		softAssert.assertTrue(2 > 3, "Condition failed"); // Fails but continues
		System.out.println("After second soft assert");

		softAssert.assertEquals("Hello", "Hi", "Strings do not match"); // Fails but continues

		softAssert.assertAll(); // Reports all collected failures
	}

	@Test(priority = 2)
	public void test_hard_assertDemo() throws InterruptedException {
		// Hard Assert stops the execution immediately if the assertion fails.
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// Example:- 1
		WebElement option1TxtBx = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		Assert.assertFalse(option1TxtBx.isSelected());

		// Example:- 2
		WebElement showHideTxtBx = driver.findElement(By.xpath("//input[@id='displayed-text']"));
		Assert.assertTrue(showHideTxtBx.isDisplayed());

		// Example:- 3
		String actTitle = "Practice Page";
		Assert.assertEquals(actTitle, driver.getTitle());

		// Example:- 4
		String aFor = "apple";
		String bFor = "ball";
		Assert.assertNotEquals(aFor, bFor);

//		Assert.fail();
//		Assert.fail("==========Not found or any message this will fail testcase============");

		System.out.println("All Example 1, 2, 3 & 4 Passes Successfully");

	}

}
