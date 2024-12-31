package com.velocity.Collable.statements.procedure2;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionExample {
	private static final String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private static final String Driver_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String Driver_Username = "system";
	private static final String Driver_Password = "system";

	// Design method which return connection object to that method
	public Connection getConnection() {
		// Step-1. Loading driver class
		Connection con = null;
		try {
			Class.forName(Driver_Name);
			// Step-2. Establish connection
			con = DriverManager.getConnection(Driver_URL, Driver_Username, Driver_Password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
