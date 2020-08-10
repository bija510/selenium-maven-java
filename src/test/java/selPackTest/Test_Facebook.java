package selPackTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import PageObjects.PO_facebook;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Facebook {

	@Test
	public void fb_signup() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		PO_facebook fbpo = new PO_facebook(driver);
		fbpo.firstname().sendKeys("david");
		fbpo.lastname().sendKeys("Lee");
		fbpo.phonenum().sendKeys("123456");
		
	}
	@AfterMethod
	public void aftermethod(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			System.out.println("===>"+ITestResult.FAILURE);
			System.out.println("===>"+result.getStatus());
		}
		
		
		
	}
	
	
	
	
	
	
	
}
