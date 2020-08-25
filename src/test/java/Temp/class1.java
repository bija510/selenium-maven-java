package Temp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class class1 {

	WebDriver driver = null;
	@BeforeTest //TestNG Annoatation 
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();// M W M
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Test //TestNG Annoatation 
	public void test1() {
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("ram");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lastName.sendKeys("chhetri");
		
		WebElement femaleButton = driver.findElement(By.xpath("//label[2]//input[1]"));
		femaleButton.click();
		
		Select skillsDDL = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
		skillsDDL.selectByVisibleText("C++");
		
	}



	@AfterTest // TestNG Annoatation 
	public void close() throws InterruptedException {
     Thread.sleep(3000);   
     driver.quit();
     driver = null;
    		 
	}


	
	
	
	
	
	
	
	
	
	
	
	
}
