package com.testng.demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.utils.CommonUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
 WebDriver driver;
	/***********************************************************************************
	 * FRAMEWORK STANDARD:- 1 WebPage====>1 pageClass & 1 testClass
	 * ClassName always start or end with Test so we can run from maven ==CMD== mvn test
	 * <======@BeforeTest don't work throw nullPointer Exception specially in group Run=======>
	 * @BeforeMethod & @AfteeMethod also work but it open browser everyTime so TimeConsuming.NRec
	 * So Prefer @BeforeClass And @AfterClass so this will open & close browser Once in Every class
	 * We Need alwaysRun=true OtherWise it throw nullPointer Exception
	 ***********************************************************************************/
	@BeforeClass(alwaysRun=true)
	public void setUp(){
		if(driver==null) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		}	
	}
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown(){
		driver.quit();
		driver =null;
	}

	@AfterMethod(alwaysRun=true)
    public void closeLast(ITestResult result) throws IOException, InterruptedException {
		String monthAndDate = CommonUtils.getMonthAndDate();
		String getTimeStamp = CommonUtils.getTimeStamp();
			
		if(ITestResult.FAILURE == result.getStatus()) {
			String failScreenShotName = result.getMethod().getMethodName() + monthAndDate + "_Failed_" + getTimeStamp;
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("../Maven_Seleniums/Screenshot/"+ failScreenShotName +".png"));//result+result.getName()		
		}
		
	}
}
