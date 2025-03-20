package com.parallel.demo;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ParallelDemo2 {

	@Test
	public void google2() throws Exception {
		BrowserFactory browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver("chrome");
		browserFactory.getDriver().get("https://demo.automationtesting.in/Register.html");
		browserFactory.getDriver().findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("David");
		browserFactory.getDriver().quit();
	}

}
