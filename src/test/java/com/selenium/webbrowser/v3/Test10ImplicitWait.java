package com.selenium.webbrowser.v3;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.qa.utils.Base;

public class Test10ImplicitWait extends Base{

	@Test
	public void implicitWait() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //used only if needed-->soft wait	
		driver.get("http://demo.automationtesting.in/Register.html");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Thread.sleep(2000); //always wait upto --->hard wait
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("subi");

	}

}
