package com.velocity.Batch.statements;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	/*
	 * Design method which return connection con object to that methods
	 */
	private static final String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private static final String Driver_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String Driver_Username = "system";
	private static final String Driver_Password = "system";
	public static final String INSERT_QUERY = "insert into products(id,name,description,price)values(?,?,?,?)";

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
