package com.parallel.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ParallelDemo {
	@Test
	public void google1() throws Exception {
		BrowserFactory browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver("chrome");
		browserFactory.getDriver().get("http://www.google.com");
		browserFactory.getDriver().findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(3000);
		Actions act = new Actions(browserFactory.getDriver());
		// browserFactory.getDriver().findElement(By.name("btnK")).click();
		act.sendKeys(browserFactory.getDriver().findElement(By.name("q")),Keys.TAB).build().perform();
		Thread.sleep(3000);
		browserFactory.getDriver().findElements(By.name("btnK")).get(1).click();
		// act.keyUp(Keys.ENTER);
		Thread.sleep(8000);
		browserFactory.getDriver().quit();
	}

}
