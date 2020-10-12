package POM_DesignPattern;

import org.testng.annotations.Test;

import utilites_library.Base;

public class register__pageFactory_Test extends Base {

	register_pageFactory_page momo;
	
	@Test(description = "I'm entering firstname, lastname and email")
	public void register() {
		driver.get("http://demo.automationtesting.in/Register.html");
	    momo = new register_pageFactory_page(driver);//Object Creation
		momo.setFirstName().sendKeys("ram");
		momo.setLastName().sendKeys("sharma");
		momo.setEmailAddress().sendKeys("abc@gmail.com");
	}

	}
	

