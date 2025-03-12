package com.testng.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test05SkipAndDepends extends Base{
	
	@Test()
	public void methodA(){
		driver.get("https://www.facebook.com/");
	}
	
	@Test(enabled = false)
	public void methodB(){
		driver.get("https://www.walmart.com/");
	}
	
	@Test()
	public void methodC(){
		Assert.assertTrue(false);
		driver.get("https://www.amazon.com/");
	}
	
	@Test(dependsOnMethods = "methodC" )
	public void methodD(){
		driver.get("https://www.ebay.com/");
	}
	
}
