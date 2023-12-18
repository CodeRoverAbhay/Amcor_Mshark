package com.practice.sillySillyMam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JdbcQueryPractice {
	@Test
	public void jdbcSelectQueryTest() throws SQLException {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection connection = DriverManager.getConnection("Jdbc:mysql://localhost:3306/amcor", "root", "root");
		Statement statement = connection.createStatement();
		String query = "select * from hrm;";
		ResultSet resultSet = statement.executeQuery(query);
		String expectedRecord = "James";
		boolean flag = false;
		while (resultSet.next()) {
			String actualRecord = resultSet.getString(2);
			if (actualRecord.equalsIgnoreCase(expectedRecord)) {
				System.out.println(actualRecord + "'s record is present in the Database.");
				flag = true;
				break;
			}
		} if (!flag) {
			System.err.println(expectedRecord + "'s record is not present in the Database.");
		}
		connection.close();
	}
	
	@Test
	public void jdbcNonSelectQuery () throws SQLException {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection connection = DriverManager.getConnection("Jdbc:mysql://localhost:3306/amcor", "root", "root");
		Statement statement = connection.createStatement();
		String expectedRecord = "Shaby";
		String query = "insert into hrm values ('A12', '" + expectedRecord + "');";
		int result = statement.executeUpdate(query);
		if (result==1) {
			System.out.println("Record inserted successfully into the Database.");
			query = "select * from hrm;";
			ResultSet resultSet = statement.executeQuery(query);
			boolean flag = false;
			while (resultSet.next()) {
				String actualRecord = resultSet.getString(2);
				if (actualRecord.equalsIgnoreCase(expectedRecord)) {
					System.out.println("Record insertion is validated successfully.");
					System.out.println("Name of Employee is : " + resultSet.getString(2) + ", and EID is : " + resultSet.getString(1));
					flag = true;
					break;
				}
			} if (!flag) {
				System.err.println("Post insertion," + expectedRecord + "'s record is not been saved into the Database and is varified.");
			}
		} else {
			System.err.println("Record not inserted in the Database.");
		}
		connection.close();
	}
}