package demoAuto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven_Registerpage extends Base{
/*************************************************
  This is called DataDriven from Properties file
**************************************************/	
	@Test
	public static void registerPage() throws IOException, InterruptedException {
		/********************************************************************************************************
		Quest. DataDriving from Properties file Why????
		Ans. Because in future in data change we don't want to change in test case rather we do in properties file
		**********************************************************************************************************/
		Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream("../Maven_Seleniums/Data/Config.properties");
	    prop.load(fis);
	    String URL = prop.getProperty("url");
	    String firstName =prop.getProperty("FirstName");
	    String lastName = prop.getProperty("LastName");
	     
//	    WebDriverManager.chromedriver().setup();
//	    WebDriver driver = new ChromeDriver();
//	    driver.manage().window().maximize();
	   
	    driver.get(URL);	
	    
	    WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstNameTextBox.sendKeys(firstName);
		
		WebElement lastNameTextBox = driver.findElement(By.cssSelector("input[placeholder='Last Name'"));
		lastNameTextBox.sendKeys(lastName); 
		
		Thread.sleep(4000);
		driver.close();
	    
	}
}
