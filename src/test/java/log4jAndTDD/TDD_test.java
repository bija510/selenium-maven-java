package log4jAndTDD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qa.utils.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TDD_test extends Base {
/**********************************************************************************************
 * TDD = Test Driven Development Style
 * Go to facebook.com--->Validate Title-->Input userName--->Input Password--->Click Login button
 * @throws InterruptedException 
 ***********************************************************************************************/
	@Test
	public void fb_loginPage() throws InterruptedException {
//		WebDriverManager.chromedriver().setup(); //because we have @before method Extends
//		WebDriver driver = new ChromeDriver();
		
		TDD_Helper faceBookLogin = new TDD_Helper(driver);
		
		faceBookLogin.open_facebook();
		
		faceBookLogin.validate_facebook_title();
		
		faceBookLogin.enter_EmailAddress("abc@gmail.com");
		
		faceBookLogin.enter_Password("abc123");
		
		faceBookLogin.click_LoginButton();
		
//		faceBookLogin.Close_The_Browser();
		
		
	}
}
