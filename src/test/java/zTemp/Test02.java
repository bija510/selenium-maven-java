package zTemp;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Test02 {

	public static void main(String[] args) throws Exception {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { Test01.class });
		testng.addListener(tla);
		testng.run();

		
	}
}
