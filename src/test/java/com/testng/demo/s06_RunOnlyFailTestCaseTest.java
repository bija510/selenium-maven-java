package com.testng.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

/******************************************************
* This auto Generated file will only run fail Test case
* test-output==> Run testng-failed.xml file 
* R-click==>Run as==> TestNG suite
*****************************************************
*Test Can fail due to various region when we run.
1. Server is down 
2. Network is slow. 
3. Application is slow
******************************************************/
public class s06_RunOnlyFailTestCaseTest extends aBase {

	@Test()
	public void methodA(){
		driver.get("https://www.facebook.com/");
	}
	
	@Test()
	public void methodB(){
		Assert.assertTrue(false);
		driver.get("https://www.walmart.com/");
	}
	
	/************************************************************
	 * How to retry the test just after failure Automatically.
	 * We have [class MyRetry] which help to retry
	 ************************************************************/
	@Test(retryAnalyzer = MyRetry.class)
	public void methodC(){
		Assert.assertEquals(10, 9);
		driver.get("https://www.amazon.com/");
	}
	
}
