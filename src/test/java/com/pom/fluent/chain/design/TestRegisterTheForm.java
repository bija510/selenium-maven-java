package com.pom.fluent.chain.design;

import org.testng.annotations.Test;

import com.qa.utils.Base;

/**
 * https://www.vinsguru.com/selenium-webdriver-how-to-design-page-objects-in-fluent-style/
 *
 */
public class TestRegisterTheForm extends Base{
	
	@Test
	public void loginToApp() {
		LoginPage.using(driver)
				 .launch()
		         .setUsername("Admin")
		         .setPassword("admin123")
		         .login();
	}
	
	@Test
	public void registration() {
		RegistrationPage.using(driver)
				        .launch()
				        .setFirstName("david")
				        .setLastName("Johnson")
				        .enterEmail("abcd@gmail.com")
				        .enterPhone("1112224444")
				        .clickFemaleRadioBtn()
				        .submit();
	}	
}
