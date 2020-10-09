package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class s06_RunOnlyFailTestCaseTest extends aBase {
	/******************************************************
	 * This auto Generated file will only run fail Test case
	 * test-output==> Run testng-failed.xml file 
	 * R-click==>Run as==> TestNG suite
	 *****************************************************/
	@Test()
	public void methodA(){
		driver.get("https://www.facebook.com/");
	}
	
	@Test()
	public void methodB(){
		Assert.assertTrue(false);
		driver.get("https://www.walmart.com/");
	}
	
	@Test()
	public void methodC(){
		Assert.assertEquals(10, 9);
		driver.get("https://www.amazon.com/");
	}
	
}
