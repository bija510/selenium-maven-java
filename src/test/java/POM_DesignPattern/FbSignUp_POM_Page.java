package POM_DesignPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FbSignUp_POM_Page {

	WebDriver driver;
	
	public FbSignUp_POM_Page(WebDriver driver) { //Constructor
		this.driver = driver;
	}
	
	By firstNameTxt_xpath = By.xpath("//input[@id='u_0_n']");
	By lastNameTxt_xpath = By.xpath("//input[@id='u_0_p']");		
	By mobileNumTxt_xpath = By.xpath("//input[@id='u_0_s']");
	By newPassword_xpath = By.xpath("//input[@id='password_step_input']");
	
	
	public WebElement setFirstName() {
		return driver.findElement(firstNameTxt_xpath);
	}
	
	public WebElement setLastName() {
		return driver.findElement(lastNameTxt_xpath);
	}

	public WebElement setMobileNum() {
		return driver.findElement(mobileNumTxt_xpath);		
	}

	public WebElement setNewPassword() {
		return driver.findElement(newPassword_xpath);
		
	}
	
	
	
	
	
	
	
	
}
