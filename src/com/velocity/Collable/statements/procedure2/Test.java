package com.velocity.Collable.statements.procedure2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

public class Test {
	private void getUserData(int id) { // 1
		try {
			ConnectionExample connectionExample = new ConnectionExample();
			Connection con = connectionExample.getConnection();
			// Step-3. use collablestatement
			CallableStatement cs = con.prepareCall("{call getEmployee(?,?,?,?)}");
			cs.setInt(1, id); // {call getEmployee(?,?,?,?)}
			// register OUT parameter
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.registerOutParameter(4, java.sql.Types.VARCHAR);

			// Step-4- submit SQL statement to database
			boolean b = cs.execute();
			// Step-5- process result
			// read OUT Parameter
			String name = cs.getString(2);
			String role = cs.getString(3);
			String city = cs.getString(4);

			// printing data
			System.out.println("Employee Name>>" + name);
			System.out.println("Employee Role>>" + role);
			System.out.println("Employee City>>" + city);
			// Step-6- close resources
			con.close();
			cs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getEmployeeInfo() {
		// ID, NAME, ROLE, CITY
		System.out.println("Enter employee ID>>"); // 1
		Scanner scanner = new Scanner(System.in);
		int empId = scanner.nextInt();
		getUserData(empId); // method calling
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.getEmployeeInfo();
	}

}
