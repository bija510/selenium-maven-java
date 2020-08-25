package demoAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class p03_AssertTest { //Assert = verify Actual vs Expected
	
	WebDriver driver = null;
		
	@BeforeMethod
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://www.facebook.com/");
	
	}
	@Test
	public void test() {
		String actualFacebookTitle = "Facebook - Log In or Sign Up";
		String expectedFacebookTitle = driver.getTitle();
		Assert.assertEquals(actualFacebookTitle , expectedFacebookTitle);
		
		}
	@Test
	public void test2() {
		String actualGender = "Female";
	    WebElement femaleRadText = driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
		String expectedGender = femaleRadText.getText();
		Assert.assertEquals(actualGender, expectedGender);
	
	}
	@Test
	public void test3() {
		
         String actValuetitle = driver.getTitle();
         String extValue = "ball";
         Assert.assertNotEquals(actValuetitle, extValue);
		
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
