package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilites_library.Base;

public class S11_ExplicitWait extends Base{

	@Test
	public void ExpliWaitMethod() {
		
		WebDriverWait ExplicitWait = new WebDriverWait(driver,10);		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		WebElement firstName = ExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocomplete")));			
		firstName.sendKeys("india");
	
	}

}
