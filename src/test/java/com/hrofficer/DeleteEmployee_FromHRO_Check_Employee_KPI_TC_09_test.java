package com.hrofficer;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericutils.BaseClass;
import com.hrm.objectRepo.DeleteEmployeePage;
import com.hrm.objectRepo.EmployeePage;
import com.hrm.objectRepo.HomePage;
import com.hrm.objectRepo.LoginPage;

@Listeners(com.hrm.genericutils.ListenerImplementationClass.class)

// Integration [ Delete Employee by HR Officier and check the HR Officier dashboard Employee count ] --> TestScript dependent on TC_01 and TC_54

public class DeleteEmployee_FromHRO_Check_Employee_KPI_TC_09_test extends BaseClass{
	
	@Test (groups = "integration", retryAnalyzer = com.hrm.genericutils.RetryImplementationClass.class)
	public void tc_09_test() throws EncryptedDocumentException, IOException {
		// Retrieve common data from Properties file
		String url = puObj.readDataFromPropertiesFile("url");
		// Trigger the URL
		driver.get(url);
		// Login to the Application as HR Officer (using existing HR Officer credentials)
		String hrOfficerUserEmail = euObj.readExcelData("TC_09", 3, 1);
		String hrOfficerPasswors = euObj.readExcelData("TC_09", 4, 1);
		LoginPage lp = new LoginPage(driver);
		lp.hrOfficerLogin(hrOfficerUserEmail, hrOfficerPasswors);
		// Verify the Alert message using Assert and Accept the Alert
		String expectedPopupMessage;
		expectedPopupMessage = euObj.readExcelData("TC_09", 2, 7);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		HomePage hp = new HomePage(driver);
		// verify the user
		hp.verifyUser(hrOfficerUserEmail);
		// From Home page get the Initial count of Employees registered in the Application
		int initialEmployeeCount = hp.getDashBoardEmployeeCount();
		System.out.println("Total count of employees before deletion is : " + initialEmployeeCount);
		// Go to Employee page
		hp.navigateToAddEmployee();
		// Search for existing Employee and delete the searched Employee
		EmployeePage ep = new EmployeePage(driver);
		String employeeId = euObj.readExcelData("TC_09", 2, 4);
		String employeeName = euObj.readExcelData("TC_09", 3, 4);
		ep.getSearchTextfield().sendKeys(employeeId);
		ep.clickOnDeleteEmployeeIcon(driver, employeeName, employeeId);
		DeleteEmployeePage dep = new DeleteEmployeePage(driver);
		dep.getDeleteButton().click();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_09", 15, 7);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Go to Dasboard page and get the total count of Employees registered in the Application
		hp.naviagateToDashboardKpiTracker();
		// Verify that upon deletion of Employee, Current count of Employee is decreasing or not
		hp.verifyUpdatedDashboardEmployeeCountAfterDelete(initialEmployeeCount);
	}
}