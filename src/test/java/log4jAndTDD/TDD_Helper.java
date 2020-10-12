package log4jAndTDD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TDD_Helper {

	private WebDriver Driver;

	public TDD_Helper(WebDriver driver) {
		Driver = driver;
	}
	

	public void open_facebook() {
		Driver.get("https://www.facebook.com/");		
	}

	public void validate_facebook_title() {
		Assert.assertEquals(Driver.getTitle(), "Facebook - Log In or Sign Up");		
	}

	public void enter_EmailAddress(String email) {
		Driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);		
	}

	public void enter_Password(String password) {
		Driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);		
	}

	public void click_LoginButton() {
		Driver.findElement(By.xpath("//button[@id='u_0_b']")).click();		
	}

	public void Close_The_Browser() throws InterruptedException {
		Thread.sleep(3000);
		Driver.quit();
		
	}

}
