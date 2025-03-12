package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtils {
	
	public static WebDriver driver;
	public Properties prop ;
	
	public WebDriver OpenDesiredBrowserAndInitalizeDriver() throws IOException 
	{
		//Reading data_properties file from Data Folder
		prop =new Properties();         
		FileInputStream fis = new FileInputStream("../Maven_Seleniums/Configurations/Config.properties");
	    prop.load(fis);
		String browserName = prop.getProperty("browser"); //CHROME
		
		if(browserName.equalsIgnoreCase("CHROME")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}else if(browserName.equalsIgnoreCase("FIREFOX")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		}else if(browserName.equalsIgnoreCase("IE")) {
	
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		}
		return driver;


	}
	

}

