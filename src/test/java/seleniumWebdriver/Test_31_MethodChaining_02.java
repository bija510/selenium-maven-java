package seleniumWebdriver;

import org.testng.annotations.Test;

public class Test_31_MethodChaining_02 {
/*************************************************************
 * ==================Fluent design pattern===================
 * disadvantage:- Hard for Debugging
 * Plus of course you get problems if the class is extended, 
 **************************************************************/
	@Test
	public void testMethod() {
		new Test_31_MethodChaining_01()
		.openUrl()
		.enterUserName()
		.enterPassword()
		.clickLoginBtn();
	}
}
