package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import demoAuto.Base;

public class PropertiesFileDataDriven extends Base{
/*************************************************
  This is called DataDriven from Properties file
**************************************************/	
	@Test
	public static void registerPage() throws IOException, InterruptedException {
		/********************************************************************************************************
		Quest. DataDriving from Properties file Why????
		Ans. While data change we don't want to change in over 20 test case rather we do in One place properties file
		**********************************************************************************************************/
		Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream("../Maven_Seleniums/Configurations/Config.properties");
	    prop.load(fis);
	    String URL = prop.getProperty("url");
	    String firstName =prop.getProperty("FirstName");
	    String lastName = prop.getProperty("LastName");
	   
	    driver.get(URL);	
	    
	    WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstNameTextBox.sendKeys(firstName);
		
		WebElement lastNameTextBox = driver.findElement(By.cssSelector("input[placeholder='Last Name'"));
		lastNameTextBox.sendKeys(lastName); 
		
		Thread.sleep(4000);
		driver.close();
	    
	}
}
