package com.velocity.statements.select.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {
	private static final String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private static final String Driver_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String Driver_Username = "system";
	private static final String Driver_Password = "system";
	private static final String SQL_Query = "select * from Employee";

	public static void main(String[] args) {

		try {
			// Step-1. Loading driver class
			Class.forName(Driver_Name);
			// Step-2. Establish connection
			Connection con = DriverManager.getConnection(Driver_URL, Driver_Username, Driver_Password);
			// Step-3. create statement
			Statement stmt = con.createStatement();
			// Step-4- create ResultSet
			ResultSet rs = stmt.executeQuery(SQL_Query);
			while (rs.next()) { // true or false
				// return true
				int empId = rs.getInt(1);
				System.out.println("Employee Id>>" + empId);
				String empName = rs.getString(2);
				System.out.println("Employee Name>>" + empName);
				String empCity = rs.getString(3);
				System.out.println("Employee Age>>" + empCity);
			}
			// Step-5- process result
			System.out.println("Data updated successfully....");
			// Step-6- close resources
			con.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
