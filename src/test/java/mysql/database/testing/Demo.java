package mysql.database.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Demo {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection connection;
		Statement statement;
		String query;
		System.out.println("Enter the name to Insert in the Database : ");
		String nameToInsert = sc.nextLine();
		nameToInsert = nameToInsert.toUpperCase();
		sc.close();
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		connection = DriverManager.getConnection("Jdbc:mysql://localhost:3306/amcor", "root", "root");
		statement = connection.createStatement();
		query = "select * from employee;";
		ResultSet resultSet = statement.executeQuery(query);
		boolean flag = false;
		while (resultSet.next()) {
			String oldRecord = resultSet.getString(1);
			if (oldRecord.equals(nameToInsert)) {
				System.out.println("Name is already present in the Database.");
				flag = true;
				break;
			}
		} if (!flag) {
			Random random = new Random();
			int randomAge = random.nextInt(99);
			query = "insert into employee values ('"+nameToInsert+"',"+randomAge+");";
			int result = statement.executeUpdate(query);
			if (result>=1) {
				query = "select * from employee;";
				ResultSet resultSetValidation = statement.executeQuery(query);
				flag = false;
				while (resultSetValidation.next()) {
					String nameOfEmployee = resultSetValidation.getString(1);
					int ageOfEmployee = resultSetValidation.getInt(2);
					if (nameOfEmployee.equals(nameToInsert)) {
						System.out.println("Name of Employee : " + nameOfEmployee + ", Age of Employee : " + ageOfEmployee);
						System.out.println("PASS : Record of Employee inserted successfully and is verified.");
						flag = true;
						break;
					}
				} if (!flag) {
					System.err.println("FAIL : Record of Employee is not inserted.");
				}
				
			}
		}
		connection.close();
	}
}