package testNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilites_library.BrowserUtility;

public class zTemp extends BrowserUtility {
	@Test
	public void initialize() throws IOException 
	{
		driver = initalizeDriver(); 
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
}
