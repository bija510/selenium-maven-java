package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_facebook {

	public WebDriver driver;
	
	public PO_facebook(WebDriver driver) {
		this.driver = driver;
	}
	
	By firstName = By.xpath("//input[@id='u_0_m']");
	By lastName = By.xpath("//input[@id='u_0_o']");
	By phoneNum = By.xpath("//input[@id='u_0_r']");
	
	public WebElement firstname() {
		return driver.findElement(firstName);
	}
	
	public WebElement lastname() {
		return driver.findElement(lastName);
		
	}
	
	public WebElement phonenum() {
		return driver.findElement(phoneNum);
	}
	
	
	
	
	
	
	
	
	
	
	
}
