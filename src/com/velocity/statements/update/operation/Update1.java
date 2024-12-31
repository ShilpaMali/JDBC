package com.velocity.statements.update.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update1 {
	private static final String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private static final String Driver_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String Driver_Username = "system";
	private static final String Driver_Password = "system";
	private static final String UpdateQuery="update Employee set emp_name='chetan',emp_city='Nagpur' where emp_id=2";
	public static void main(String[] args) {

		try {
			// Step-1. Loading driver class
			Class.forName(Driver_Name);
			// Step-2. Establish connection
			Connection con = DriverManager.getConnection(Driver_URL, Driver_Username, Driver_Password);
			// Step-3. create statement
			Statement stmt=con.createStatement();
			// Step-4- submit SQL statement to database
			stmt.executeUpdate(UpdateQuery);
			// Step-5- process result
			System.out.println("Data updated successfully....");
			// Step-6- close resources
			con.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
