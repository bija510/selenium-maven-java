package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;


public class PropertiesFileDataDrivenTest extends Base{
/*************************************************
  This is called DataDriven from Properties file
**************************************************/	
	@Test
	public void registerPage() throws IOException, InterruptedException {
		/********************************************************************************************************
		Quest. DataDriving from Properties file Why????
		Ans. While data change we don't want to change in over 20 test case rather we do in One place properties file
		**********************************************************************************************************/
		Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream("../selenium-maven-java/Configurations/Config.properties");
	    prop.load(fis);
	    String URL = prop.getProperty("url");
	    String firstName =prop.getProperty("FirstName");
	    String lastName = prop.getProperty("LastName");
	   
	    driver.get(URL);	
	    
	    WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstNameTextBox.sendKeys(firstName);
		
		WebElement lastNameTextBox = driver.findElement(By.cssSelector("input[placeholder='Last Name'"));
		lastNameTextBox.sendKeys(lastName); 
		
		/**************************************************************************
		 * Writing String Key and Value to Properties File
		 **************************************************************************/
		prop.setProperty("Country", "USA");		
		FileOutputStream fos = new FileOutputStream("../Maven_Seleniums/Configurations/Config.properties");
		prop.store(fos, "Write data to Properties File TimeStamp");		
		fis.close();
		
		driver.close();
	    
	}
}
