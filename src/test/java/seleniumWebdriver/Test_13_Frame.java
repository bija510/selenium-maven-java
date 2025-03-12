package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test_13_Frame extends Base {

	@Test
	public void switchToFrame() throws InterruptedException {

		driver.get("https://letskodeit.teachable.com/pages/practice");

		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("window.scrollBy(0,1200)");

		// Switch inside the page inside page called frame
		driver.switchTo().frame("courses-iframe");
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("python");
		Thread.sleep(2000);

		// Switch back to default page
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		JS.executeScript("window.scrollBy(0,-1000)");
		driver.findElement(By.id("name")).sendKeys("Robert");
		
	}
}
