package com.selenium.webbrowser.v3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.utils.CommonUtils;

@Listeners(com.testng.demo.Test09listener.class)

public class Test07CheckBxRadioBtn {
	WebDriver driver;

	@Test
	public void verifyCheckBxAndRadioBtn() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://demo.automationtesting.in/Register.html");

		CommonUtils.vScroll(driver, 300);
		
		WebElement movieChkBx = driver.findElement(By.xpath("//input[@id='checkbox1']"));
		if (!movieChkBx.isSelected()) {
			movieChkBx.click();
		}

		WebElement maleRadBtn = driver.findElement(By.xpath("//input[@value='Male']"));
		maleRadBtn.click();

		Thread.sleep(3000);
		driver.quit();

	}
}
