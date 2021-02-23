package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class s12_Parameterization_fromXmlFileTest {
   /********************************************************************************************
    NOTE:- Run the Test Suites/parameter.xml file and please DON'T Run this class this will Fail
	Passing the parameter from xml file
	We going to send URL ,Database password and database userName from this parameter.xml
   ************************************************************************************************/
	
	@Parameters({ "URL", "Username", "Password" })
	@Test()
	public void tc1(String URL, String Username, String pwd) {
		System.out.println("my url name is " + URL);
		System.out.println("My database username is " + Username);
		System.out.println("My database pwd " + pwd);
	}
}
