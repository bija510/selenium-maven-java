package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilites_library.Base;

public class Test_16_AlertTest extends Base{
	@Test
	public void acceptAlert() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement alertBtn = driver.findElement(By.xpath("//input[@id='alertbtn']"));
		alertBtn.click();
		Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
	      }
}
