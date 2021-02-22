package TestNG;

import org.testng.annotations.Test;

public class s07_priorityTest extends aBase{
	
	@Test(priority = 3)
	public void methodA(){
		driver.get("https://www.facebook.com/");
	}
	
	@Test(priority = 2)
	public void methodB(){
		driver.get("https://www.walmart.com/");
	}
	
	@Test(priority = 1)
	public void methodC(){
		driver.get("https://www.amazon.com/");
	}
	
}
