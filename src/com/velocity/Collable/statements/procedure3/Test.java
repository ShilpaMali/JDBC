package com.velocity.Collable.statements.procedure3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Test {
	private void getUserData(String role) { //developer
		try {
			ConnectionExample connectionExample = new ConnectionExample();
			Connection con = connectionExample.getConnection();
			// Step-3. use collablestatement
			CallableStatement cs = con.prepareCall("{call getEmployeeByRole(?,?)}");
			cs.setString(1, role); //
			// register OUT parameter
			cs.registerOutParameter(2,OracleTypes.CURSOR);

			// Step-4- submit SQL statement to database
			boolean b = cs.execute();
			// Step-5- process result
			// read OUT Parameter
			ResultSet rs=(ResultSet)cs.getObject(2);

			while(rs.next()) {
				System.out.println("ID>>"+rs.getInt("EMPID"));
				System.out.println("NAME>>"+rs.getString("NAME"));
				System.out.println("CITY>>"+rs.getString("CITY"));
				
			}
			// Step-6- close resources
			con.close();
			cs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getEmployeeInfo() {
		// Role
		System.out.println("Enter employee Role>>"); // 1
		Scanner scanner = new Scanner(System.in); //developer
		String role = scanner.next();
		getUserData(role); // method calling
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.getEmployeeInfo();
	}
}
