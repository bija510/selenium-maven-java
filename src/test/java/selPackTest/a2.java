package selPackTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class a2 {
 
	WebDriver driver = null;
	@BeforeMethod
	public void openMethod1 () {
		
	WebDriverManager.firefoxdriver().setup();
	driver= new FirefoxDriver();
	driver.manage().window().maximize();
	
	}

    @Test
	public void openMethod2 () {

    	driver.get("http://demo.automationtesting.in/Register.html");
    	WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
    	firstName.sendKeys("david");
    	
    	WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
    	lastName.sendKeys("corgan");	
    	
    	WebElement femaleRadioButton = driver.findElement(By.xpath("//label[2]//input[1]"));
    	femaleRadioButton.click();	
    	}
    	
    	
 
    @AfterMethod
	 public void openMethod3 () throws InterruptedException {

    	Thread.sleep(3000);
		driver.quit();
		driver = null;
    	
	}


	
	
	
	
}
