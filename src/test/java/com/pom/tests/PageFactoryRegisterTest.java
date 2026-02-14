package com.pom.tests;

import org.testng.annotations.Test;

import com.pom.pages.PageFactoryRegisterPage;
import com.qa.utils.Base;

public class PageFactoryRegisterTest extends Base {

	PageFactoryRegisterPage registerPage;

	@Test(description = "I'm entering firstname, lastname and email")
	public void register() {
		driver.get("http://demo.automationtesting.in/Register.html");
		registerPage = new PageFactoryRegisterPage(driver);// Object Creation
		registerPage.setFirstName().sendKeys("ram");
		registerPage.setLastName().sendKeys("sharma");
		registerPage.setEmailAddress().sendKeys("abc@gmail.com");
	}

}
