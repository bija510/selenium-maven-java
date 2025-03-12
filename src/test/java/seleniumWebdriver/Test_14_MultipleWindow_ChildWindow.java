package seleniumWebdriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test_14_MultipleWindow_ChildWindow extends Base{

	@Test
	public void switchWndow() throws InterruptedException {		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement openWindowButton = driver.findElement(By.cssSelector("button[id='openwindow']"));
		openWindowButton.click();
		
		Set<String> ids =driver.getWindowHandles(); //5555444888b, 0, 11112222z
		Iterator<String> it =ids.iterator(); // {  0 ,11112222z, 5555444888b }
				
		String parentWindow = it.next(); //"11112222z"
		String childWindow = it.next(); // "5555444888b"
 		
		Thread.sleep(1000);
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul/li[2]/a")).click();
		Thread.sleep(4000);
		
		driver.switchTo().window(parentWindow);
		WebElement enterYourNameTxtBox = driver.findElement(By.xpath("//input[@id='name']"));
		enterYourNameTxtBox.sendKeys("ram");
				
			}
	@Test
	public void openNewTab() {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//a[@id='opentab']")).click();
		
		Set<String> ids =driver.getWindowHandles();
		Iterator<String> it =ids.iterator();
		
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);		
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'World class')]")).getText());
	}


}


