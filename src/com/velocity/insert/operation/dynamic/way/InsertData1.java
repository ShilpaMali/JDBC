package com.velocity.insert.operation.dynamic.way;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertData1 {
	private void getUserData(int id, String name, String city) {
		try {
			ConnectionExample connectionExample = new ConnectionExample();
			Connection con = connectionExample.getConnection();
			
			// Step-3. use preparedStatement
			PreparedStatement ps = con.prepareStatement("insert into Employee(emp_id,emp_name,emp_city)values(?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, city);
			
			// insert into Employee(emp_id,emp_name,emp_city)values(6,'Ram',Pune)
			// Step-4- submit SQL statement to database
			int a = ps.executeUpdate();
			
			// Step-5- process result
			System.out.println("Data insert successfully...." + a);
			
			// Step-6- close resources
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getEmployeeInfo() {
		// ID, NAME, AGE- input from user
		System.out.println("Enter employee ID>>");
		Scanner scanner = new Scanner(System.in);
		int empId = scanner.nextInt();
		System.out.println("Enter employee Name>>");
		String empName = scanner.next();
		System.out.println("Enter employee city>>");
		String empCity = scanner.next();
		getUserData(empId, empName, empCity); // method calling
		
	}

	public static void main(String[] args) {
		InsertData1 insertData = new InsertData1();
		for (int i = 1; i <= 2; i++) {
			insertData.getEmployeeInfo();
		}

	}
}
