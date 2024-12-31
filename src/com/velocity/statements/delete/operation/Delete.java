package com.velocity.statements.delete.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//Program for delete data using statement from oracle database

public class Delete {
	private static final String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private static final String Driver_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String Driver_Username = "system";
	private static final String Driver_Password = "system";
	private static final String DeleteQuery="delete from Employee where emp_id=1";
	public static void main(String[] args) {

		try {
			// Step-1. Loading driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Step-2. Establish connection
			Connection con = DriverManager.getConnection(Driver_URL, Driver_Username, Driver_Password);
			// Step-3. create statement
			Statement stmt=con.createStatement();
			// Step-4- submit SQL statement to database
			stmt.executeUpdate(DeleteQuery);
			// Step-5- process result
			System.out.println("Data deleted successfully....");
			// Step-6- close resources
			con.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
