package com.hrm.genericutils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.hrm.objectRepo.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	// Instantiate utility specific class objects
	public static DatabaseUtils dbObj = new DatabaseUtils();
	public static ExcelUtils euObj = new ExcelUtils();
	public static JavaUtils juObj = new JavaUtils();
	public static PropertyFileUtils puObj = new PropertyFileUtils();
	public static WebDriverUtils wuObj = new WebDriverUtils();
	public WebDriver driver;
	public static WebDriver ssDriver;

	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws SQLException {
		// Connect to the Database
		dbObj.connectToDatabase();
		System.out.println("Successfully established the connection with the Database.");
	}
	
	@BeforeTest
	public void config_BT () {
		System.out.println("Executing Before Test configuration method.");
	}
	
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws IOException {
		String browser = puObj.readDataFromPropertiesFile("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();
			System.out.println("Successfully launched Chrome Browser.");
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Successfully launched Edge Browser.");
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Successfully launched Firefox Browser.");
		} else {
			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();
			System.err.println("Successfully launched default Chrome Browser.");
		}
		// Initializing the static ssDriver value which is of WebDriver type for screen shot
		ssDriver = driver;
		// Maximize the Browser screen
		wuObj.maximizeBrowser(driver);
		// Wait for all WebElements to get loaded
		wuObj.waitForAllElementsToLoad(driver);
	}
	
	// For Cross - browser suite
	/*
	 * @Parameters ("browser")
	 * 
	 * @BeforeClass(alwaysRun = true) public void config_BC(String browser) throws
	 * IOException { // Useful for compatability testing if
	 * (browser.equalsIgnoreCase("chrome")) {
	 * //WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); }
	 * else if (browser.equalsIgnoreCase("edge")) {
	 * //WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); } else if
	 * (browser.equalsIgnoreCase("firefox")) {
	 * //WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }
	 * else { System.err.println("Invalid Browser"); } // Initializing the static
	 * ssDriver value which is of WebDriver type for screen shot ssDriver = driver;
	 * // Maximize the Browser screen wuObj.maximizeBrowser(driver); // Wait for all
	 * WebElements to get loaded wuObj.waitForAllElementsToLoad(driver); }
	 */

	// In order to make BaseClass generic for all script, we are skipping Login Test
	/*
	 * @BeforeMethod(alwaysRun = true) public void config_BM() throws IOException {
	 * // Read common data from Properties file String url =
	 * puObj.readDataFromPropertiesFile("url"); String userEmail =
	 * puObj.readDataFromPropertiesFile("userEmail"); String password =
	 * puObj.readDataFromPropertiesFile("password"); // Trigger the URL
	 * driver.get(url); // Login to the Application LoginPage lp = new
	 * LoginPage(driver); lp.hrHeadLogin(userEmail, password); // Print the Alert
	 * pop message and Accept the Alert
	 * wuObj.printAlertMessageAndAcceptAlert(driver); HomePage hp = new
	 * HomePage(driver); hp.verifyUser(userEmail); }
	 */

	@AfterMethod(alwaysRun = true)
	public void config_AM() {
		// Logout from the Application
		HomePage hp = new HomePage(driver);
		hp.logOutFormApplication();
		// Print the Alert pop message and Accept the Alert
		wuObj.printAlertMessageAndAcceptAlert(driver);
	}

	@AfterClass(alwaysRun = true)
	public void config_AC() {
		// Minimize the Browser
		driver.manage().window().minimize();
		// Terminate the session
		driver.quit();
		System.out.println("Successfully terminated the Browser session.");
	}
	
	@AfterTest
	public void config_AT () {
		System.out.println("Executing After Test configuration method.");
	}

	@AfterSuite(alwaysRun = true)
	public void config_AS() throws SQLException {
		// Disconnect from Testing Environment Database
		dbObj.closeDatabaseConnection();
		System.out.println("Successfully disconnected the connection with the Database.");
	}
}