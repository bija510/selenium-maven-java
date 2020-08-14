package demoAuto;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	WebDriver driver = null;
	@BeforeTest
	public void open() {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
    driver.manage().window().maximize();
	}
	
	
	@AfterTest
	public void close( ) throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver = null;
	}
	
	@AfterMethod
    public void closeLast(ITestResult result) throws IOException {
		
		String pattern = "yyyy-MMdd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		String monthAndDate = date.substring(5);
		
		
		String pattern2 = "HHmmss";	
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);	
		String digit6TimeStamp = simpleDateFormat2.format(new Date());
		
		
		
		if(ITestResult.FAILURE == result.getStatus()) {
			String failScreenShotName = result.getMethod().getMethodName() + monthAndDate + "_Failed_" + digit6TimeStamp;
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Bijaya Chhetri\\eclipse-workspace\\Maven_Seleniums\\Screenshot\\"+ failScreenShotName +".png"));//result+result.getName()
		}
	}
	
}










