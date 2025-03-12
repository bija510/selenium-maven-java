package com.testng.demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test11DataProvider {

	/*******************************************************************************************************
	* if we have to run 5o test in 2 or 3 different set of type of users how we do it by using @Dataprovider
	******************************************************************************************************/
	@Test(dataProvider="myData1") //instead of myData1 this u can write any name like "abc"
	public void testcase1(String uname,String pwd)
	{
	      System.out.println("Testcase 1 should now run for 4 set of users");
	      System.out.println(uname);
          System.out.println(pwd);		
	}
	
	@DataProvider(name="myData1")
	public Object[][] myDataProvider1()
	{
		Object [][]obj =new Object[4][2]; //4 diffn types of user and defiig 2 parameter(Username and Pwd)
		obj[0][0]= "user1";
		obj[0][1]= "pwd1";
		obj[1][0]= "user2";
		obj[1][1]= "pwd2";
		obj[2][0]= "user3";
		obj[2][1]= "pwd3";
		obj[3][0]= "user4";
		obj[3][1]= "pwd4";
		return obj;			
	}
}
