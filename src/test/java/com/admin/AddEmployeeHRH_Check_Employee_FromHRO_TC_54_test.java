package com.admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericutils.BaseClass;
import com.hrm.objectRepo.AddEmployeePage;
import com.hrm.objectRepo.EmployeePage;
import com.hrm.objectRepo.HomePage;
import com.hrm.objectRepo.LoginPage;

@Listeners(com.hrm.genericutils.ListenerImplementationClass.class)

//E2E [ Create employee as HR Head and check the existance of the same employee as HR Officer ]  --> TestScript dependent on TC_01

public class AddEmployeeHRH_Check_Employee_FromHRO_TC_54_test extends BaseClass {

	@Test(groups = "system", retryAnalyzer = com.hrm.genericutils.RetryImplementationClass.class)

	public void tc_54_test() throws IOException {
		// Read common data from Properties file
		String url = puObj.readDataFromPropertiesFile("url");
		String userEmail = puObj.readDataFromPropertiesFile("userEmail");
		String password = puObj.readDataFromPropertiesFile("password");
		// Trigger the URL
		driver.get(url);
		// Login to the Application
		LoginPage lp = new LoginPage(driver);
		lp.hrHeadLogin(userEmail, password);
		// Print the Alert pop message and Accept the Alert
		wuObj.printAlertMessageAndAcceptAlert(driver);
		HomePage hp = new HomePage(driver);
		hp.verifyUser(userEmail);
		// From Home page go to Employee page
		hp.navigateToAddEmployee();
		// Add New Employee to the Application
		EmployeePage ep = new EmployeePage(driver);
		ep.getAddEmployeeButton().click();
		AddEmployeePage aep = new AddEmployeePage(driver);
		String empCompanyId = euObj.readExcelData("TC_54", 2, 16);
		aep.getCompanyIdTextfield().sendKeys(empCompanyId);
		String empFirstName = euObj.readExcelData("TC_54", 3, 16);
		aep.getFirstNameTextfield().sendKeys(empFirstName);
		String empLastName = euObj.readExcelData("TC_54", 4, 16);
		aep.getLastNameTextfield().sendKeys(empLastName);
		String empMiddleName = euObj.readExcelData("TC_54", 5, 16);
		aep.getMiddleNameTextfield().sendKeys(empMiddleName);
		String empFromDate = euObj.readExcelData("TC_54", 6, 16);
		aep.getBrnchsDateFromTextfield().sendKeys(empFromDate);
		String empRecentDate = euObj.readExcelData("TC_54", 7, 16);
		aep.getBrnchsRecentDateTextfield().sendKeys(empRecentDate);
		String empDepartment = euObj.readExcelData("TC_54", 2, 4);
		aep.selectDepartment(empDepartment);
		String empBranch = euObj.readExcelData("TC_54", 2, 7);
		aep.selectBranch(empBranch);
		String empPosition = euObj.readExcelData("TC_54", 8, 16);
		aep.getPositionTextfield().sendKeys(empPosition);
		String empContactNo = euObj.readExcelData("TC_54", 9, 16);
		aep.getContactNoTextfield().sendKeys(empContactNo);
		String empSss = euObj.readExcelData("TC_54", 10, 16);
		aep.getSssTextfield().sendKeys(empSss);
		String empTin = euObj.readExcelData("TC_54", 11, 16);
		aep.getTinTextfield().sendKeys(empTin);
		String empHdmf = euObj.readExcelData("TC_54", 12, 16);
		aep.getHdmfTextfield().sendKeys(empHdmf);
		String empGsis = euObj.readExcelData("TC_54", 13, 16);
		aep.getGsisTextfield().sendKeys(empGsis);
		aep.uploadEmployeeFile("./src/test/resources/Test.docx");
		aep.uploadEmployeeProfilePicture("./src/test/resources/Test.jpeg");
		aep.getSaveButton().click();
		// Verify the Alert message using Assert and Accept the Alert
		String expectedPopupMessage;
		expectedPopupMessage = euObj.readExcelData("TC_54", 14, 19);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Logout from the Application
		hp.logOutFormApplication();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_54", 3, 19);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Login to Application as HR Officer using existing HR Officer credentials
		String hrOfficerUserEmail = euObj.readExcelData("TC_54", 7, 10);
		String hrOfficerPasswors = euObj.readExcelData("TC_54", 8, 10);
		lp.hrOfficerLogin(hrOfficerUserEmail, hrOfficerPasswors);
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_54", 2, 19);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// verify the user and Go to Employee page
		hp.verifyUser(hrOfficerUserEmail);
		hp.navigateToAddEmployee();
		// Search for Employee who has been previously added by HR Head & verify
		// Employee is visible to HR Officer or not
		String expEmployeeId = euObj.readExcelData("TC_54", 2, 16);
		ep.getSearchTextfield().sendKeys(expEmployeeId);
		String actEmployeeId = ep.getEmployeeIdValue();
		Assert.assertEquals(actEmployeeId, expEmployeeId, "FAILED : Employee added by HR Head is not displayed in HR Officer Employee list.");
	}
}