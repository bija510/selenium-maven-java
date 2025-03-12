package com.selenium.webbrowser.v3;

import org.testng.annotations.Test;

public class Test31MethodChainingB {
/*************************************************************
 * ==================Fluent design pattern===================
 * disadvantage:- Hard for Debugging
 * Plus of course you get problems if the class is extended, 
 **************************************************************/
	@Test
	public void testMethod() {
		new Test31MethodChainingA()
		.openUrl()
		.enterUserName()
		.enterPassword()
		.clickLoginBtn();
	}
}
