package com.test.webAutomationInterview;

import java.io.*;
import java.sql.*;


public class Database {

	public static void main(String[] args) throws Exception {


		String url
		= "jdbc:mysql://localhost:3306/customerdb"; // table details
		String username = "root"; // MySQL credentials
		String password = "Think@111#";
		String query
		= "select *from company"; // query to be run
		Class.forName(
				"com.mysql.cj.jdbc.Driver"); // Driver name
		Connection con = DriverManager.getConnection(
				url, username, password);
		System.out.println(
				"Connection Established successfully");
		Statement st = con.createStatement();
		ResultSet rs
		= st.executeQuery(query); // Execute query
		rs.next();
		String name 
		= rs.getString("FirstName"); // Retrieve name from db

		System.out.println(name); // Print result on console
		st.close(); // close statement
		con.close(); // close connection
		System.out.println("Connection Closed....");
		
		
// reference  : https://www.geeksforgeeks.org/establishing-jdbc-connection-in-java/		
	}
}


