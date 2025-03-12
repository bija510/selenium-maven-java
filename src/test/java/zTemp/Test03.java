package zTemp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qa.utils.CommonUtils;

public class Test03 {
	
	WebDriver driver;
	
	@Test
	public void test_lunch() throws IOException {
		driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
}
	
	@AfterMethod
	public void closeLast(ITestResult result) throws IOException {
		String monthAndDate = CommonUtils.getMonthAndDate();
		String digit6TimeStamp = CommonUtils.get6DigitTimeStamp();
		
		String failScreenShotName = result.getMethod().getMethodName() + monthAndDate + "_Failed_"
				+ digit6TimeStamp;
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("../selenium-maven-java/Screenshot/" + failScreenShotName + ".png"));// result+result.getName()

	}
}
