package com.velocity.prepared.statements.select.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Program for select operation using statement into oracle database
public class Select1 {
	
	private static final String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private static final String Driver_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String Driver_Username = "system";
	private static final String Driver_Password = "system";
	private static final String SQL_Query = "select * from employee";

	public static void main(String[] args) {

		try {
			// Step-1. Loading driver class
			Class.forName(Driver_Name);
			// Step-2. Establish connection
			Connection con = DriverManager.getConnection(Driver_URL, Driver_Username, Driver_Password);
			// Step-3. use preparedstatement
			PreparedStatement ps=con.prepareStatement(SQL_Query);
			// Step-4- create ResultSet
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // true or false
				// return true if present
				// return false if not present
				int empId = rs.getInt(1);
				System.out.println("Employee Id>>" + empId);
				String empName = rs.getString(2);
				System.out.println("Employee Name>>" + empName);
				int empAge = rs.getInt(3);
				System.out.println("Employee Age>>" + empAge);
			}
			// Step-5- process result
			System.out.println("Data updated successfully....");
			// Step-6- close resources
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

