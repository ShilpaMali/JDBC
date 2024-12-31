package com.velocity.statements.insert.operation;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Insert {
	private static final String Driver_Name="oracle.jdbc.driver.OracleDriver";
	private static final String Driver_URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String Driver_Username="system";
	private static final String Driver_Password="system";
	private static final String Insert_Query="insert into Employee(emp_id,emp_name,emp_city,emp_salary)values(5,'Ram','Kolhapur',45000)";
	
	public static void main(String[]args) {
		
		Connection con=null;
		Statement stmt=null;
		try {
			// Step-1. Loading driver class
			Class.forName(Driver_Name);
			
			// Step-2. Establish connection
			 con = DriverManager.getConnection(Driver_URL, Driver_Username, Driver_Password);
			
			// Step-3. create statement
		     stmt=con.createStatement();
		    
			// Step-4- submit SQL statement to database
			stmt.executeUpdate(Insert_Query);
			
			// Step-5- process result
			System.out.println("Data insert successfully....");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
