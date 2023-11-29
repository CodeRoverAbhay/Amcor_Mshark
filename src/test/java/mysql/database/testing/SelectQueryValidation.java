package mysql.database.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryValidation {
	public static void main(String[] args) throws SQLException {
		// STEP 1 : Create Driver specific object (mysql.cj.jdbc package)
		Driver driverRef = new Driver();
		// STEP 2 : Register the driver
		DriverManager.registerDriver(driverRef);
		// STEP 3 : Get the connection. Here in URL after the port number we need to specify the database name that we want to switch to
		Connection connection = DriverManager.getConnection("Jdbc:mysql://localhost:3306/amcor", "root", "root");
		// STEP 4 : Create a statement
		Statement statement = connection.createStatement();
		// STEP 5 : Create a Query
		String query = "select * from hrm;";
		// STEP 6 : Execute Query for Select
		ResultSet resultSet = statement.executeQuery(query);
		// STEP 7 : Validation of Record. Here we can fetch the data from external resources like Excel file
		String expectedData = "James";
		// Initializing the boolean flag as false
		boolean flag = false;
		// Using while loop iterating the result set one by one using next ( ) method it will enter while only if the next () returns true
		while (resultSet.next()) {
			// Here we are validating the 2nd column record. As per the table structure Ename is stored in 2nd column.
			String actualData = resultSet.getString(2);
			// If actual and expected got matched it'll enter if block
			if (actualData.equalsIgnoreCase(expectedData)) {
				System.out.println("PASS : Passed record is present in the database.");
				// Printing all the data present in column 1 and 2 of matched record
				System.out.println(resultSet.getString(1) + " : " + resultSet.getString(2));
				// Once the match is found the flag value is re-assigned to the true
				flag = true;
				// After successful validation break will terminate the while loop and will come out of the loop
				break;
			}
		}
		// If none of the record got matched then condition !false becomes true and it'll enter if block
		if (!flag) {
			System.err.println("FAIL : Passed record is not present in the database.");
		}
		// STEP 8 : Close the connection
		connection.close();
	}
}