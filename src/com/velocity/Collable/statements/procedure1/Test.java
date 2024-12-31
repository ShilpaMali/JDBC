package com.velocity.Collable.statements.procedure1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

public class Test {

	private void getUserData(int id, String name, String role, String city) {
		try {
			ConnectionExample connectionExample = new ConnectionExample();
			Connection con = connectionExample.getConnection();
			// Step-3. use collablestatement
			CallableStatement cs = con.prepareCall("{call insertEmployee(?,?,?,?,?)}");
			cs.setInt(1, id);
			cs.setString(2, name);
			cs.setString(3, role);
			cs.setString(4, city);
			//register OUT parameter 
			cs.registerOutParameter(5,java.sql.Types.VARCHAR);
			// Step-4- submit SQL statement to database
			int a = cs.executeUpdate();
			// Step-5- process result
			//read OUT Parameter
			String result=cs.getString(5);
			System.out.println("Result>>"+result);
			System.out.println("Data insert successfully...." + a);
			// Step-6- close resources
			con.close();
			cs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getEmployeeInfo() {
		// ID, NAME, ROLE, CITY
		System.out.println("Enter employee ID>>");
		Scanner scanner = new Scanner(System.in);
		int empId = scanner.nextInt();
		System.out.println("Enter employee Name>>");
		String empName = scanner.next();
		System.out.println("Enter employee Role>>");
		String role = scanner.next();
		System.out.println("Enter employee city>>");
		String city = scanner.next();
		getUserData(empId, empName, role, city); // method calling
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.getEmployeeInfo();
	}

}
