package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class mySQLDatabaseTestingTest {

	@Test
	public void databaseTesting() throws SQLException {
		String hostName, portNum, dataBaseName, userName, password;
		hostName = "localhost";
		portNum = "3306";
		dataBaseName = "/Qadbt";
		userName = "root";
		password = "admin123";

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

			System.out.println("Everything Match OK.............");
		}
	}

}
