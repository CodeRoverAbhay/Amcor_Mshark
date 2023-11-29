package mysql.database.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryValidation {
	public static void main(String[] args) throws SQLException {
		// Declaring a global variable query of type String
		String query;
		// STEP 1 : Create Driver specific object (mysql.jc.jdbc)
		Driver driverRef = new Driver();
		// STEP 2 : Register the driver
		DriverManager.registerDriver(driverRef);
		// STEP 3 : Get the connection
		Connection connection = DriverManager.getConnection("Jdbc:mysql://localhost:3306/amcor", "root", "root");
		// STEP 4 : Create a statement
		Statement statement = connection.createStatement();
		// STEP 5 : Initialize the Query
		query = "insert into hrm values ('A05', 'Fallon'),('A06', 'Xenia');";
		// STEP 6 : Execute Query for Non-Select
		int result = statement.executeUpdate(query);
		// STEP 7 : Validation of Not-select query that we have performed
		if (result >= 1) {
			System.out.println("Record inserted successfull.");
		} else {
			System.err.println("Error encountered while inserting the record.");
		}
		// STEP 8 : Validation of Record using select query that we have inserted into the Database
		query = "select * from hrm;";
		ResultSet resultSet = statement.executeQuery(query);
		// Here we can fetch the data from external resources like Excel file
		String expectedData = "Fallon";
		// Initializing the boolean flag as false
		boolean flag = false;
		// Using while loop iterating the result set one by one using next ( ) method it will enter while only if the next () returns true
		while (resultSet.next()) {
			// Here we are validating the 2nd column record. As per the table structure Ename is stored in 2nd column.
			String actualData = resultSet.getString(2);
			// If actual and expected got matched it'll enter if block
			if (actualData.equalsIgnoreCase(expectedData)) {
				System.out.println("Record inserted successfully.");
				// Once the match is found the flag value is re-assigned to the true
				flag = true;
				// After successful validation break will terminate the while loop and will come out of the loop
				break;
			}
		}
		// If none of the record got matched then condition !false becomes true and it'll enter if block 
		if (!flag) {
			System.err.println("Failure : Record not inserted.");
		}
		// STEP 9 : Close the connection
		connection.close();
	}
}