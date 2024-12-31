package com.velocity.prepared.statements.delete.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//Program for delete data using prepared statement into oracle database

public class Delete {
	private static final String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private static final String Driver_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String Driver_Username = "system";
	private static final String Driver_Password = "system";
	public static void main(String[] args) {

		try {
			// Step-1. Loading driver class
			Class.forName(Driver_Name);
			// Step-2. Establish connection
			Connection con = DriverManager.getConnection(Driver_URL, Driver_Username, Driver_Password);
			// Step-3. use preparedStatement   //id is first query parameter,
			PreparedStatement ps=con.prepareStatement("delete from Employee where emp_id=?");
			ps.setInt(1,2); //2 is id
			//delete from employee where id=2
			// Step-4- submit SQL statement to database
			int a=ps.executeUpdate();
			// Step-5- process result
			System.out.println("Data Deleted successfully...."+a);
			// Step-6- close resources
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
