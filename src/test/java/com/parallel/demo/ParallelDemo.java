package com.parallel.demo;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ParallelDemo {
	@Test
	public void google1() throws Exception {
		BrowserFactory browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver("chrome");
		browserFactory.getDriver().get("https://www.letskodeit.com/practice");
		browserFactory.getDriver().findElement(By.xpath("//input[@id='bmwcheck']")).click();
		
		browserFactory.getDriver().quit();
	}

}
