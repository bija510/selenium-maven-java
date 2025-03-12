package com.testng.demo;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class Test14CallRunAnyClassUsingTestNG {

	@Test
	public void call_and_run_any_testng_class() throws Exception {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { 
				Test02BeforeAndAfterTest.class ,
				Test07Priority.class
				});
		
		testng.addListener(tla);
		testng.run();

		
	}
}
