package mysql.database.testing;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReadDataFromCmdTest {
	@Test
    // Go to project path 
	public void readData() {
		Reporter.log("Retrieve successfully");
		System.out.println("Retrieve successfully");
	}
	@Test
	public void writeData() {
		Reporter.log("Entered the data successfully");
		System.out.println("Mission successfully");
	}
	@Test
	public void updateData() {
		Reporter.log("Updated the data successfully");
		System.out.println("Updated the data successfully");
	}
}