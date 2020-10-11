package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class s04ReporterLogTest extends aBase {
	/**************************************************************
	  Reporter class is used for test methods to log messages.
	  that will be included in the HTML reportsgenerated by TestNG. 
	 **************************************************************/
	@Test()
	public void method1() throws InterruptedException {	
		
		driver.get("https://www.amazon.com");
		Reporter.log("===amazon.com Lunched ===", true);
	}

}