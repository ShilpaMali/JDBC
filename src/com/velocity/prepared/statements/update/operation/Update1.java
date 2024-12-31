package com.velocity.prepared.statements.update.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//for multiple value
//Program for update data using prepared statement into oracle database

public class Update1 {
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
			// Step-3. use preparedStatement //name is first query parameter, age is second
			// query parameter
			// id is third query parameter
			PreparedStatement ps = con.prepareStatement("update Employee set emp_name=?,emp_city=? where emp_id=?");
			ps.setString(1, "amruta"); // amruta is name
			ps.setString(2, "Baramati"); //   is city
			ps.setInt(3, 2); // 5 is id
			// update employee set name='amruta',age=22 where id=5
			// Step-4- submit SQL statement to database
			int a = ps.executeUpdate();
			// Step-5- process result
			System.out.println("Data updated successfully...." + a);
			// Step-6- close resources
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
