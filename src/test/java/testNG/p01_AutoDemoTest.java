package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class p01_AutoDemoTest {

	WebDriver driver = null;
	
	@BeforeMethod
	public void test1() { //method name = test1
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bijaya Chhetri\\eclipse-workspace\\subi\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get("http://demo.automationtesting.in/Register.html");
		
	}
	
	@Test
	public void test2() { //method name = test2
		
		
	WebElement firstName = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input"));
	firstName.sendKeys("subi");
	
	WebElement lastName = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
	lastName.sendKeys("chhe");	
	
	WebElement femaleRadioButton = driver.findElement(By.xpath("//label[2]//input[1]"));
	femaleRadioButton.click();
	
	WebElement movieCheckBox = driver.findElement(By.id("checkbox2"));
	movieCheckBox.click();
	
	Select skillsDDL = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
	skillsDDL.selectByVisibleText("Adobe Photoshop");	
	  
	Select countryDDL = new Select(driver.findElement(By.xpath("//select[@id='countries']")));
	countryDDL.selectByIndex(3);		
		
		
	}
	
	@AfterMethod
	public void test3() throws InterruptedException { //method name = test3
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
