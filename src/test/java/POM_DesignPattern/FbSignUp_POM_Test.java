package POM_DesignPattern;

import org.testng.annotations.Test;

import demoAuto.Base;

public class FbSignUp_POM_Test extends Base{

	@Test
	public void signUp() {
		
		driver.get("https://www.facebook.com/signup");
		
		FbSignUp_POM_Page fb = new FbSignUp_POM_Page(driver); //create object
		
		fb.setFirstName().sendKeys("Ram");
		fb.setLastName().sendKeys("Sharma");
		fb.setMobileNum().sendKeys("1234567890");
		fb.setNewPassword().sendKeys("Admin123");
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
