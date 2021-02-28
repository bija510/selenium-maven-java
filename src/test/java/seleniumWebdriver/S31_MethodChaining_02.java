package seleniumWebdriver;

import org.testng.annotations.Test;

public class S31_MethodChaining_02 {
/*************************************************************
 * ==================Fluent design pattern===================
 * disadvantage:- Hard for Debugging
 * Plus of course you get problems if the class is extended, 
 **************************************************************/
	@Test
	public void testMethod() {
		new S31_MethodChaining_01()
		.openUrl()
		.enterUserName()
		.enterPassword()
		.clickLoginBtn();
	}
}
