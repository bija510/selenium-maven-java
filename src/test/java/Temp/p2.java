package Temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import demoAuto.Base;

public class p2 extends Base{
	@Test
	public void openUrl() {
		//driver.get("http://demo.automationtesting.in/Register.html");
		driver.navigate().to("http://demo.automationtesting.in/Register.html");
	}
	@Test
	public void test_register() {
		openUrl();
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("ram");
		
		}
	@Test
     public void test_setName() {
    	 openUrl();
    	 WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
    	 lastName.sendKeys("sharma");
		}
	
	
     
     
}
