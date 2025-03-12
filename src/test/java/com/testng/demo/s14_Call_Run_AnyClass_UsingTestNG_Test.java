package com.testng.demo;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class s14_Call_Run_AnyClass_UsingTestNG_Test {

	@Test
	public void call_and_run_any_testng_class() throws Exception {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { 
				s02_BeforeAndAfterTest_Test.class ,
				s07_priorityTest.class
				});
		
		testng.addListener(tla);
		testng.run();

		
	}
}
