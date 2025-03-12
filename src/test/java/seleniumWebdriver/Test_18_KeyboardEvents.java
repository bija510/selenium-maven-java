package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test_18_KeyboardEvents extends Base {

	@Test
	public void using1Keys(){
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement autoSuggestTextBox = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		autoSuggestTextBox.sendKeys("nep");
		autoSuggestTextBox.sendKeys(Keys.ARROW_DOWN);
		autoSuggestTextBox.sendKeys(Keys.ENTER);
		
	}
	
	@Test
	public void using2Keys() throws InterruptedException {
		driver.get("https://www.facebook.com/login/");
		
		WebElement userName =driver.findElement(By.xpath("//input[@id='email']"));
		userName.sendKeys(Keys.NUMPAD2);
		Thread.sleep(2000);
		userName.sendKeys(Keys.BACK_SPACE);
		
		WebElement signUpLinkText = driver.findElement(By.linkText("Sign Up"));	
		signUpLinkText.sendKeys(Keys.CONTROL, Keys.ENTER);
		
		System.exit(0);
	}
		
}
