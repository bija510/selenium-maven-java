package com.pom.traditional.design;

import org.testng.annotations.Test;

import com.qa.utils.Base;

public class register__pageFactory_Test extends Base {

	register_pageFactory_page registerPage;

	@Test(description = "I'm entering firstname, lastname and email")
	public void register() {
		driver.get("http://demo.automationtesting.in/Register.html");
		registerPage = new register_pageFactory_page(driver);// Object Creation
		registerPage.setFirstName().sendKeys("ram");
		registerPage.setLastName().sendKeys("sharma");
		registerPage.setEmailAddress().sendKeys("abc@gmail.com");
	}

}
