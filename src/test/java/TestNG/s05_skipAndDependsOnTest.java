package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class s05_skipAndDependsOnTest extends aBase{
	
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
