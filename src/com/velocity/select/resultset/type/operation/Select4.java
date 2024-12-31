package com.velocity.select.resultset.type.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Program for select operation using statement into oracle database
public class Select4 {
	private static final String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private static final String Driver_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String Driver_Username = "system";
	private static final String Driver_Password = "system";
	private static final String SQL_Query = "select ID,NAME,AGE from employee";

	public static void main(String[] args) {

		try {
			// Step-1. Loading driver class
			Class.forName(Driver_Name);
			// Step-2. Establish connection
			Connection con = DriverManager.getConnection(Driver_URL, Driver_Username, Driver_Password);
			// Step-3. create statement
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// Step-4- create ResultSet
			ResultSet rs = stmt.executeQuery(SQL_Query);
			rs.absolute(2);
			rs.updateInt("AGE",24);
			rs.updateRow();
			/*
			 * Moves the cursor to the given row number in this ResultSet object.
			 */
			int empId = rs.getInt(1);
			System.out.println("Employee Id>>" + empId);
			String empName = rs.getString(2);
			System.out.println("Employee Name>>" + empName);
			int empAge = rs.getInt(3);
			System.out.println("Employee Age>>" + empAge);

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
