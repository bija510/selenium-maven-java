package com.datadriven.demo;

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
	    String userName =prop.getProperty("UserName");
	    String password = prop.getProperty("Password");
	   
	    driver.get(URL);	
	    
	    WebElement userNameTextBox = driver.findElement(By.xpath("//input[@placeholder='Username']"));
	    userNameTextBox.sendKeys(userName);
	    
	    Thread.sleep(2000);
		
		WebElement passwordTextBox = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordTextBox.sendKeys(password); 
		
		/**************************************************************************
		 * Writing String Key and Value to Properties File
		 **************************************************************************/
		prop.setProperty("Country", "USA");		
		FileOutputStream fos = new FileOutputStream("../selenium-maven-java/Configurations/Config.properties");
		prop.store(fos, "Write data to Properties File TimeStamp");		
		fis.close();
		
		Thread.sleep(3000);
		driver.quit();
	    
	}
}
