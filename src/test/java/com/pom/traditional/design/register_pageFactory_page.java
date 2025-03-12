package com.pom.traditional.design;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class register_pageFactory_page {
	WebDriver driver;

	public register_pageFactory_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='First Name']") 
	private WebElement firstNameTxBx;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']") 
	private WebElement lastNameTxBx;
	
	@FindBy(xpath = "//input[@type='email']") 
	private WebElement emailAddressTxBx;

	
	
	public WebElement setFirstName() {
		return firstNameTxBx;
	}

	public WebElement setLastName() {
		return lastNameTxBx;
	}

	public WebElement setEmailAddress() {
		return emailAddressTxBx;

	}

}
