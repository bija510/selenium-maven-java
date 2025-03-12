package com.testng.demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.utils.CommonUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test02BeforeAndAfterTest {
WebDriver driver = null;
	/*************************************************************************************
	 * NOTE:- This is the framework Standard <==== 1 class should only have 1 page Method=====>
	 * Browser will open only one time and all Method in that page will completed
	 * opening browser for Each method is not recommended. since it slow the execution process
	 ************************************************************************************/
	@BeforeTest()
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/signup");
	}
	
	@Test()
	public void enterFirstName(){
		driver.findElement(By.xpath("//input[@id='u_0_n_Uu']")).sendKeys("David");
	}
	
	@Test()
	public void enterPhoneNumber() throws Exception{
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("111-222-3333");
		throw new Exception("====fail====");
	}
	
	@AfterTest()
	public void tearDown(){
		driver.close();
		driver =null;
	}
	
	@AfterMethod
    public void closeLast(ITestResult result) throws IOException, InterruptedException {
		String monthAndDate = CommonUtils.getMonthAndDate();
		String digit6TimeStamp = CommonUtils.get6DigitTimeStamp();
			
		if(ITestResult.FAILURE == result.getStatus()) {
			String failScreenShotName = result.getMethod().getMethodName() + monthAndDate + "_Failed_" + digit6TimeStamp;
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("../Maven_Seleniums/Screenshot/"+ failScreenShotName +".png"));//result+result.getName()		
		}
	}
}
