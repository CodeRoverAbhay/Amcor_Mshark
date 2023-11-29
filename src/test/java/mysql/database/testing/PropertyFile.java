package mysql.database.testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertyFile {
	public static void main(String[] args) throws IOException, InterruptedException {
		// Steps to write the data into a properties file

		// Step 1 :Create an object of Java Properties class
		Properties pobj = new Properties();

		// Step 2 : Call setProperty method to write the data into file
		pobj.setProperty("browser", "edge");
		pobj.setProperty("url", "http://rmgtestingserver/domain/HRM_System/");
		pobj.setProperty("email", "hrhead@gmail.com");
		pobj.setProperty("password", "hrhead@123");

		// Step 3 : Create an object of output stream to write the data into specified file
		FileOutputStream fos = new FileOutputStream(".//src/test/resources/CommonData.properties");

		// Step 4 : Save the file
		pobj.store(fos, "Stored successfully");

		// Steps to Read the data into a properties file

		// Step 1 : Create an object of File input stream
		FileInputStream fis = new FileInputStream(".//src/test/resources/CommonData.properties");

		// Step 2 : Load the properties file
		pobj.load(fis);

		// Step 3 : Retrieve the data from theproperties file and store it in a variable
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("email");
		String password = pobj.getProperty("password");

		// Step 4 : Use the data into your script
		System.out.println("Browser is : " + browser);
		System.out.println("URL is : " + url);
		System.out.println("Email is : " + username);
		System.out.println("Password is : " + password);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.findElement(By.name("hr_email")).sendKeys(username);
		driver.findElement(By.name("hr_password")).sendKeys(password);
		Select select = new Select(driver.findElement(By.id("hr_type")));
		select.selectByVisibleText("→ HR Head");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		System.out.println(wait.until(ExpectedConditions.alertIsPresent()).getText());
		driver.switchTo().alert().accept();
		driver.manage().window().minimize();
		driver.quit();
	}
}