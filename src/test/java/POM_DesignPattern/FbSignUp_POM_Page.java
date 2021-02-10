package POM_DesignPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FbSignUp_POM_Page {

	 /********************************************************************************************************************
    1. Encapsulation Object oriented program here [private By variable] will be accessed by all this [public method]
    2. Do not write assertion in page class
    3. Write All the <==[DRIVER APIs]==>.findElement.....click, getText,... only in this Page class
    ====================POM Design technique is called Lazy initialization technique====================================
    *******************************************************************************************************************/
	
	WebDriver driver;
	/*============This is initialization of driver===========*/
	public FbSignUp_POM_Page(WebDriver driver) { //Constructor
		this.driver = driver;
	}
	
	/*============This is deceleration===========*/
	private By firstNameTxt_xpath = By.xpath("//input[@id='u_0_n']");
	private By lastNameTxt_xpath = By.xpath("//input[@id='u_0_p']");		
	private By mobileNumTxt_xpath = By.xpath("//input[@id='u_0_s']");
	private By newPassword_xpath = By.xpath("//input[@id='password_step_input']");
	
	
	/*============This is Utilization===========*/
	public String PageTitle() {
		return driver.getTitle();
	}
	
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
