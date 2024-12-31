package com.velocity.statements.update.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {
	private static final String Driver_Name="oracle.jdbc.driver.OracleDriver";
	private static final String Driver_URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String Driver_Username="system";
	private static final String Driver_Password="system";
	private static final String Update_Query="update Employee set emp_name='ajit' where emp_id=1";
	
	public static void main(String[]args) {
		
		
		try {
			
			//step1:Loading Driver class
			Class.forName(Driver_Name);
			
			//step2: Establish Connection
			Connection con=DriverManager.getConnection(Driver_URL,Driver_Username,Driver_Password);
			
			//step3: Create statement
			
			Statement stmt=con.createStatement();
			
			// Step-4- submit SQL statement to database
						stmt.executeUpdate(Update_Query);
						// Step-5- process result
						System.out.println("Data updated successfully....");
						// Step-6- close resources
						con.close();
						stmt.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
