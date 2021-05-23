package pom_traditional_design_pattern;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilites_library.Base;

public class FbSignUp_POM_Test extends Base{

    /*****************************************************************
     * 1. Write <==[ASSERTION]==> in Test class
     * 2. Never use driver APIs in Test class like --->
     * 3. driver.find.element(By.).click(),getTest()....in Test class
    ******************************************************************/
	@Test
	public void signUp() {
		
		driver.get("https://www.facebook.com/signup");
		
		FbSignUp_POM_Page fb = new FbSignUp_POM_Page(driver); //create object
		Assert.assertEquals(fb.PageTitle(), "Sign Up for Facebook | Facebook");;
		fb.setFirstName().sendKeys("Ram");
		fb.setLastName().sendKeys("Sharma");
		fb.setMobileNum().sendKeys("1234567890");
		fb.setNewPassword().sendKeys("Admin123");
		
			
	}

}
