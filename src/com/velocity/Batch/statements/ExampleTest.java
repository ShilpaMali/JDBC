package com.velocity.Batch.statements;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExampleTest {
	private void getJDBCBatch() {
		try {
			// Step-1-
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
			// Step-2
			PreparedStatement ps = con.prepareStatement(DBConnection.INSERT_QUERY);

			// Step-3- number of records is 5
			String[][] products = { { "10", "Computer", "Lenovo", "65000.00" }, { "11", "TV", "Sony", "85000.00" },
					{ "12", "AC", "videocon", "62000.00" }, { "13", "Refrigerator", "Godrej", "41000.00" },
					{ "14", "Laptop", "HP", "75000.00" }, };

			// Step-4- use for each loop
			for (String[] product : products) {
				ps.setString(1, product[0]);
				ps.setString(2, product[1]);
				ps.setString(3, product[2]);
				ps.setBigDecimal(4, new BigDecimal(product[3]));

				ps.addBatch(); //just to add data into ps 
			}

			// Step-5- execute batch
			int a[] = ps.executeBatch();

			System.out.println("Record inserted>>" + a.length);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExampleTest exampleTest = new ExampleTest();
		exampleTest.getJDBCBatch();
	}

}
