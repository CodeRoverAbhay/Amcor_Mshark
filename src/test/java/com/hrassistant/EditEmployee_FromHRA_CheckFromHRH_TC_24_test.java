package com.hrassistant;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrm.genericutils.ExcelUtils;
import com.hrm.genericutils.PropertyFileUtils;
import com.hrm.genericutils.WebDriverUtils;
import com.hrm.objectRepo.EditEmployeePage;
import com.hrm.objectRepo.EmployeePage;
import com.hrm.objectRepo.HomePage;
import com.hrm.objectRepo.LoginPage;
// Integration [ Edit employee with HR Assintant and check the edited Employee details is reflecting in HR Head Employee list ] --> TestScript dependent on TC_01 and TC_54
public class EditEmployee_FromHRA_CheckFromHRH_TC_24_test {
	public static WebDriver driver;
	
	@Parameters("browser")
	@Test(groups = "integration")
	public void tc_24_test() throws IOException {
		// For cross browser
		//public void tc_24_test(String browser) throws IOException {
		
		// Instantiate utility specific class object
		ExcelUtils euObj = new ExcelUtils();
		PropertyFileUtils puObj = new PropertyFileUtils();
		WebDriverUtils wuObj = new WebDriverUtils();
		// Retrieve common data from the Properties file
		String url = puObj.readDataFromPropertiesFile("url");
		String browser = puObj.readDataFromPropertiesFile("browser");
		// Based on matched condition launch the Browser
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		// Maximize the Browser screen
		wuObj.maximizeBrowser(driver);
		// Trigger the URL
		driver.get(url);
		// Add implicit wait for WebElements
		wuObj.waitForAllElementsToLoad(driver);
		// Login to the Application as HR Assistant (using existing HR Assistant credentials)
		String hrAssistantUserEmail = euObj.readExcelData("TC_24", 3, 1);
		String hrAssistantPassword = euObj.readExcelData("TC_24", 4, 1);
		LoginPage lp = new LoginPage(driver);
		lp.hrAssistantLogin(hrAssistantUserEmail, hrAssistantPassword);
		// Verify the Alert message using Assert and Accept the Alert
		String expectedPopupMessage;
		expectedPopupMessage = euObj.readExcelData("TC_24", 2, 10);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		HomePage hp = new HomePage(driver);
		// verify the user
		hp.verifyUser(hrAssistantUserEmail);
		// From Home page Go to Employee page
		hp.navigateToAddEmployee();
		// Search for existing Employee and Edit the First Name of the Employee
		EmployeePage ep = new EmployeePage(driver);
		String employeeFirstName = euObj.readExcelData("TC_24", 3, 4);
		String employeeId = euObj.readExcelData("TC_24", 2, 4);
		ep.getSearchTextfield().sendKeys(employeeId);
		ep.clickOnEditEmployeeIcon(driver, employeeFirstName, employeeId);
		String employeeNameToModify = euObj.readExcelData("TC_24", 2, 7);
		EditEmployeePage eep = new EditEmployeePage(driver);
		eep.getFirstNameTextfield().clear();
		eep.getFirstNameTextfield().sendKeys(employeeNameToModify);
		eep.uploadEmployeeFile("./src/test/resources/Test.docx");
		eep.uploadEmployeeProfilePicture("./src/test/resources/Test54.jpeg");
		eep.getUpdateButton().click();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_24", 16, 10);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Logout from the Application
		hp.logOutFormApplication();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_24", 3, 10);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Login to Application as HR Head
		String hrUserEmail = puObj.readDataFromPropertiesFile("userEmail");
		String hrPassword = puObj.readDataFromPropertiesFile("password");
		lp.hrHeadLogin(hrUserEmail, hrPassword);
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_24", 2, 10);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// verify the user
		hp.verifyUser(hrUserEmail);
		// Go to Employee page
		hp.navigateToAddEmployee();
		// Search for Employee whose details has been updated & verify for updated Employee's First Name
		ep.getSearchTextfield().sendKeys(employeeId);
		String actualEmployeeFirstName = ep.getFirstEmployeeFirstNameFromList(driver, employeeId);
		Assert.assertEquals(actualEmployeeFirstName, employeeNameToModify, "Fail : Employee Name Updation got failed and is verified.");
		// Logout from the Application
		hp.logOutFormApplication();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_24", 3, 10);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Minimize the Browser screen
		wuObj.minimizeBrowser(driver);
		// Terminate the session
		driver.quit();
	}
}