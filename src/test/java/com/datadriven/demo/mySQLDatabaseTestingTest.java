package com.datadriven.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class mySQLDatabaseTestingTest {
	
		private static String hostName = "localhost";
		private static String portNum = "3306";
		private static String dataBaseName = "/Qadbt";
		private static String userName = "root";
		private static String password = "admin123";
		
		
	@Test
	public void databaseTesting() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://" + hostName + ":" + portNum + dataBaseName,userName, password);
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from Employeeinfo where name='david'"); // adam, bin, cavin, david
	  //ResultSet rs =s.executeQuery("select * from Employeeinfo"); //give all

		while (rs.next()) {
			/*************************************************************
			 * System.out.println("Name:- " + rs.getString("name"));
			 * System.out.println("State:- " + rs.getString("location"));
			 * System.out.println("age:- " + rs.getString("age")); System.out.println("Id:-
			 * "+ rs.getString("id"));
			 ************************************************************/
			Assert.assertEquals(rs.getString("name"), "david");
			Assert.assertEquals(rs.getString("location"), "ohio");
			Assert.assertEquals(rs.getString("age"), "24");
			Assert.assertEquals(rs.getString("id"), "4");

			System.out.println(">>>>>>>--- > Record found in the SQL DataBase table || Test case passed");
		}
	}

}
