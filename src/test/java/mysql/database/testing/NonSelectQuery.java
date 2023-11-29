package mysql.database.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {
	public static void main(String[] args) throws SQLException {
		// 1st STEP : Register the driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		// 2nd STEP : Get connection of database
		Connection conn = DriverManager.getConnection("Jdbc:mysql://localhost:3306/amcor", "root", "root");
		// 3rd STEP : Create statement
		Statement statement = conn.createStatement();
		String query = "insert into hrm values ('A04', 'James')";
		// 4th STEP : Execute Update query
		int result = statement.executeUpdate(query);
		// 5th STEP : Validate through the result
		if (result==1) {
			System.out.println("Record inserted successfully.");
		} else {
			System.err.println("Error encountered while inserting the record.");
		}
		// 5th STEP : Close database
		conn.close();
	}
}