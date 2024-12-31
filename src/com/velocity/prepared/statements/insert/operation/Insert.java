package com.velocity.prepared.statements.insert.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//Program for insert data using prepared statement into oracle database


public class Insert {
	private static final String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private static final String Driver_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String Driver_Username = "system";
	private static final String Driver_Password = "system";
	//private static final String InsertQuery="insert into employee(id,name,age)values(5,'ashwini',26)";
	public static void main(String[] args) {

		try {
			// Step-1. Loading driver class
			Class.forName(Driver_Name);
			// Step-2. Establish connection
			Connection con = DriverManager.getConnection(Driver_URL, Driver_Username, Driver_Password);
			// Step-3. use preparedStatement
			PreparedStatement ps=con.prepareStatement("insert into Employee(emp_id,emp_name,emp_city)values(?,?,?)");
			ps.setInt(1,6);
			ps.setString(2,"yogesh");
			ps.setString(3,"Karnataka");
			//insert into employee(id,name,age)values(6,'yogesh',25)
			// Step-4- submit SQL statement to database
			int a=ps.executeUpdate();
			// Step-5- process result
			System.out.println("Data insert successfully...."+a);
			// Step-6- close resources
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
