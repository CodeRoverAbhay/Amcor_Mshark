package com.hrm.genericutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * @author Code_Rover_Abhay
 */
public class DatabaseUtils {
	Connection connection;

	/**
	 * This method is used to Register the Driver and Establish the connection with Database
	 * 
	 * @throws SQLException
	 */
	public void connectToDatabase() throws SQLException {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		connection = DriverManager.getConnection(IPathConstants.databaseUrl, IPathConstants.databaseUsername, IPathConstants.databasePassword);
	}

	/**
	 * This method is used to execute the select query and to retrieve the data from the database
	 * 
	 * @param columnData
	 * @param expectedData
	 * @param query
	 * @return data
	 * @throws SQLException
	 */
	public String executeAndGetData(String columnData, String expectedData, String query) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		boolean flag = false;
		while (resultSet.next()) {
			String actualData = resultSet.getString(columnData);
			if (actualData.equalsIgnoreCase(expectedData)) {
				System.out.println("Pass : Data is matching and is verified.");
				System.out.println("Actual Data is : " + actualData + ", and Expected Data is : " + expectedData);
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("PASS : Data is verified.");
			return expectedData;
		} else {
			System.err.println("FAIL : Actual Data and Expected Data are not matching.");
			return "";
		}
	}

	/**
	 * This method is used to execute the non-select query and to validate the same
	 * 
	 * @param columnData
	 * @param expectedData
	 * @param query
	 * @throws SQLException
	 */
	public void executeAndUpdateData(String columnData, String expectedData, String query) throws SQLException {
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(query);
		if (result >= 1) {
			System.out.println("Pass : Data is Inserted successfully and is verified.");
		} else {
			System.err.println("Fail : Data is not Inserted and is verified.");
		}
	}

	/**
	 * This method is to close the connection with the Database
	 * 
	 * @throws SQLException
	 */
	public void closeDatabaseConnection() throws SQLException {
		connection.close();
	}
}