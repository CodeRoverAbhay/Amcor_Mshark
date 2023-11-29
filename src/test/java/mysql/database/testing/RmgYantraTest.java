package mysql.database.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RmgYantraTest {
	public static void main(String[] args) throws SQLException, InterruptedException {
		// Automation test script to add the project
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		String actualProjectName = "AMCOR_PROJECT_011";
		driver.findElement(By.name("projectName")).sendKeys(actualProjectName);
		driver.findElement(By.name("createdBy")).sendKeys("Abhay Gope");
		WebElement statusDropdown = driver.findElement(By.xpath("//label[text()='Project Status ']/..//select"));
		Select select = new Select(statusDropdown);
		select.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).submit();
		String toastMsg = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText();
		System.out.println(toastMsg);
		Thread.sleep(5000);
		// Backend validation
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		Connection conn = DriverManager.getConnection("Jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		boolean flag = false;
		Statement statement = conn.createStatement();
		String query = "select * from project;";
		ResultSet result = statement.executeQuery(query);
		while (result.next()) {
			String projectName = result.getString(4);
			if (projectName.equals(actualProjectName)) {
				System.out.println("Project got created successfully.");
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("Project creation was unsuccessful.");
		}
		conn.close();
		driver.manage().window().minimize();
		driver.quit();
	}
}