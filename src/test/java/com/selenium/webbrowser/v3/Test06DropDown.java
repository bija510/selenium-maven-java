package com.selenium.webbrowser.v3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test06DropDown extends Base {
	/**********************************************************************************
	 * We have 2 types of dropDown 1. static dropDown :- Regular Html dropDown with
	 * fixed value 2. dynamic dropDown or paper-dropdown-input:- not fixed DDL order
	 * or name eg: show different on basis of user input
	 **********************************************************************************/

	@Test
	public void test_staticDDL() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement DDL = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select selectDDL = new Select(DDL);
		// selectDDL.selectByVisibleText("Option2");
		selectDDL.selectByIndex(2);
		Thread.sleep(2000);

		// selectDDL.selectByVisibleText("Option1");
		selectDDL.selectByIndex(1);
		Thread.sleep(2000);

		// selectDDL.selectByVisibleText("Option3");
		selectDDL.selectByIndex(3);
		Thread.sleep(2000);

	}

	@Test
	public void test_dynamicDDL() throws InterruptedException {
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");

		List<WebElement> allLabels = driver.findElements(By.cssSelector(".ui-menu-item div"));

		for (WebElement ddlLabel : allLabels) {
			//NOTE:- == operator don't work so we need [equalsIgnoreCase] else will not work
			if (ddlLabel.getText().equalsIgnoreCase("India")) {
				ddlLabel.click();
				break;
			}

		}

	}

}
