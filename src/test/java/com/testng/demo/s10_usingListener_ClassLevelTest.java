package com.testng.demo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.testng.demo.s09_listener.class)
public class s10_usingListener_ClassLevelTest extends aBase{
/*********************************************************************************
 For Listener we have Two type 
 	1. classLevel & Another=======> [s10_usingListener_ClassLevelTest]
 	2. SuiteLevel for xml file ===> [Test Suites/MyListener.xml]
 ********************************************************************************/
	@Test
	public void methodB(){
		driver.get("https://www.walmart.com/");
	}
	
	public void methodC(){
		System.out.println(driver.getTitle());
	}
}
