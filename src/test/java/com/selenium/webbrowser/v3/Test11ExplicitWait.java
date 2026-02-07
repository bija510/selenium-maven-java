package com.selenium.webbrowser.v3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test11ExplicitWait extends Base{
	
	@Test
	public void dynamicLoadingExample() {

	    driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement startButton = driver.findElement(By.cssSelector("#start button"));
	    startButton.click();

	    WebElement helloText = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4"))
	    );

	    System.out.println(helloText.getText());
	}

	@Test
	public void loaderModalExample() {

	    driver.get("https://demo.automationtesting.in/Loader.html");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement runButton = driver.findElement(By.xpath("//button[normalize-space()='Run']"));
	    runButton.click();

	    WebElement closeButton = wait.until(
	            ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-default"))
	    );

	    closeButton.click();
	}

	
}
