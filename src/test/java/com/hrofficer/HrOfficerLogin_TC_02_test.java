package com.hrofficer;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrm.genericutils.ExcelUtils;
import com.hrm.genericutils.PropertyFileUtils;
import com.hrm.genericutils.WebDriverUtils;
import com.hrm.objectRepo.HomePage;
import com.hrm.objectRepo.LoginPage;

@Listeners(com.hrm.genericutils.ListenerImplementationClass.class)
// Smoke [ Login to Application as HR Officer ] --> TestScript dependent on TC_01
public class HrOfficerLogin_TC_02_test {
	public WebDriver driver;
	public static WebDriver ssDriver;
	
	@Parameters("browser")
	@Test (groups = "smoke")
	public void tc_02_test() throws IOException {
		// For cross browser
		//public void tc_02_test(String browser) throws IOException {
		
		// Instantiate utility specific class object
		ExcelUtils euObj = new ExcelUtils();
		PropertyFileUtils puObj = new PropertyFileUtils();
		WebDriverUtils wuObj = new WebDriverUtils();
		// Retrieve common data from Properties file or Excel for Login
		String url = puObj.readDataFromPropertiesFile("url");
		String hrOfficerUserEmail = euObj.readExcelData("TC_02", 2, 1);
		String hrOfficerPassword = euObj.readExcelData("TC_02", 3, 1);
		String browser = puObj.readDataFromPropertiesFile("browser");
		// Based on matched condition launch the Browser
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		ssDriver = driver;
		// Maximize the Browser screen
		wuObj.maximizeBrowser(driver);
		// Trigger the URL
		driver.get(url);
		Assert.fail();
		// Add implicit wait for WebElements
		wuObj.waitForAllElementsToLoad(driver);
		// Login to the Application as HR Officer (using existing HR Officer credentials)
		LoginPage lp = new LoginPage(driver);
		lp.hrOfficerLogin(hrOfficerUserEmail, hrOfficerPassword);
		// Verify the Alert message using Assert and Accept the Alert
		String expectedPopupMessage;
		expectedPopupMessage = euObj.readExcelData("TC_02", 2, 9);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Verify HR Officer is able to Login to the Application or not by validating Title of page
		String expPageTitle = euObj.readExcelData("TC_02", 2, 6);
		wuObj.verifyTitle(driver, expPageTitle);
		HomePage hp = new HomePage(driver);
		// verify the user
		hp.verifyUser(hrOfficerUserEmail);
		// Logout from the Application
		hp.logOutFormApplication();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_02", 3, 9);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Minimize the Browser screen
		wuObj.minimizeBrowser(driver);
		// Terminate the session
		driver.quit();
	}
}