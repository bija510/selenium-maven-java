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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.utils.CommonUtils;

public class Test01BeforeAndAfterMethod {
	/*********************************************************************************
	 * NOTE:- Always add Test at beginning or end of class name 
	 * This is not right approach of opening browser Multiple time. for the same page
	 * This will be good if we are using Module concept but this is Page concept
	 *********************************************************************************/
	private WebDriver driver;
	
	@BeforeMethod()
	public void setUp(){
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
	
	@AfterMethod()
	public void tearDown(ITestResult result) throws IOException{
		String monthAndDate = CommonUtils.getMonthAndDate();
		String getTimeStamp = CommonUtils.getTimeStamp();
			
		if(ITestResult.FAILURE == result.getStatus()) {
			String failScreenShotName = result.getMethod().getMethodName() + monthAndDate + "_Failed_" + getTimeStamp;
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("../Maven_Seleniums/Screenshot/"+ failScreenShotName +".png"));//result+result.getName()		
		}
		driver.quit();
		driver =null;
	}
	
	
}
