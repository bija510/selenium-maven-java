package pom_fluent_chain_design_pattern;

import org.testng.annotations.Test;
import utilites_library.Base;

/**
 * https://www.vinsguru.com/selenium-webdriver-how-to-design-page-objects-in-fluent-style/
 *
 */
public class Test_RegisterTheForm extends Base{
	
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
