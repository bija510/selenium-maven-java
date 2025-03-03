package seleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilites_library.Base;

public class Test_11_ExplicitWait extends Base{
	
	/*******************************************************************
	 *SELENIUM:-3 WebDriverWait​(WebDriver driver, long timeoutInSeconds) Deprecated.
     *SELENIUM:-4 WebDriverWait(WebDriver, Duration).
	 ******************************************************************/
	@Test
	public void TestMethod01() {
		
//		WebDriverWait ExplicitWait = new WebDriverWait(driver,20); //This is in selenium 3 which is Depreciated
		WebDriverWait ExplicitWait = new WebDriverWait(driver,Duration.ofSeconds(20));// Selenium-4
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		WebElement btn_start = driver.findElement(By.cssSelector("[id='start'] button"));
		btn_start.click();
		
		WebElement lbl_Hello = ExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='finish'] h4")));			
		System.out.println(lbl_Hello.getText());
	}

	@Test
	public void TestMethod02() {
//		WebDriverWait ExplicitWait1 = new WebDriverWait(driver,20);	// Selenium-3 Depreciated
		WebDriverWait ExplicitWait1 = new WebDriverWait(driver,Duration.ofSeconds(20));	
		driver.get("http://demo.automationtesting.in/Loader.html");
		WebElement btn_run= driver.findElement(By.xpath("//button[normalize-space()='Run']"));
		btn_run.click();
		
		//ExplicitWait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-default']")));
		ExplicitWait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-default']")));
		WebElement btn_closeAlert = driver.findElement(By.cssSelector("button[class='btn btn-default']"));
		btn_closeAlert.click();
		
	}
	
	
}
