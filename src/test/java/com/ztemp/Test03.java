package com.ztemp;

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
import org.testng.annotations.Test;

import com.qa.utils.CommonUtils;

public class Test03 {
	
	WebDriver driver;
	
	@Test
	public void test_lunch() throws IOException {
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh-mm-ss-SSSS");
		String digit6TimeStamp = simpleDateFormat2.format(new Date());
		System.out.println(digit6TimeStamp);
}
	
}
