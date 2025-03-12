package com.pom.traditional.design;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class RegisterPomTest extends Base{

    /*****************************************************************
     * 1. Write <==[ASSERTION]==> in Test class
     * 2. Never use driver APIs in Test class like --->
     * 3. driver.find.element(By.).click(),getTest()....in Test class
    ******************************************************************/
	@Test
	public void signUp() {
		
		driver.get("https://www.facebook.com/signup");
		
		RegisterPomPage fb = new RegisterPomPage(driver); //create object
		Assert.assertEquals(fb.PageTitle(), "Sign Up for Facebook | Facebook");;
		fb.setFirstName().sendKeys("Ram");
		fb.setLastName().sendKeys("Sharma");
		fb.setMobileNum().sendKeys("1234567890");
		fb.setNewPassword().sendKeys("Admin123");
		
			
	}

}
