package com.admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericutils.BaseClass;
import com.hrm.objectRepo.AddAdminPage;
import com.hrm.objectRepo.AddEmployeePage;
import com.hrm.objectRepo.AdminPage;
import com.hrm.objectRepo.EditEmployeePage;
import com.hrm.objectRepo.EmployeePage;
import com.hrm.objectRepo.HomePage;
import com.hrm.objectRepo.LoginPage;
@Listeners(com.hrm.genericutils.ListenerImplementationClass.class)
//E2E [ Create HR Head and login it, then create an employee and logout from HR Head again try to login as HR Officer and update created employee ] --> TestScript dependent on TC_01
public class CreateHRHead_DowngradeTo_HROfficer_AddEmployee_TC_31 extends BaseClass {
	@Test(groups = "system")
	public void tc_31_test() throws IOException {
		// From Home page Go to Admin page
		HomePage hp = new HomePage(driver);
		hp.navigateToAddAdmin();
		// Add New Admin to the Application with position HR Head
		AdminPage ap = new AdminPage(driver);
		ap.getAddAdminButton().click();
		AddAdminPage aap = new AddAdminPage(driver);
		String companyId = euObj.readExcelData("TC_31", 2, 1);
		aap.getCompanyIdTextfield().sendKeys(companyId);
		String adminFirstName = euObj.readExcelData("TC_31", 3, 1);
		aap.getFirstNameTextfield().sendKeys(adminFirstName);
		String adminLastName = euObj.readExcelData("TC_31", 4, 1);
		aap.getLastNameTextfield().sendKeys(adminLastName);
		String adminMiddleName = euObj.readExcelData("TC_31", 5, 1);
		aap.getMiddleNameTextfield().sendKeys(adminMiddleName);
		String adminContactNo = euObj.readExcelData("TC_31", 6, 1);
		aap.getContactNoTextfield().sendKeys(adminContactNo);
		String hrPositionType = euObj.readExcelData("TC_31", 2, 4);
		aap.selectHrPositionByValue(driver, hrPositionType);
		String adminEmailAddress = euObj.readExcelData("TC_31", 7, 1);
		aap.getEmailAddressTextfield().sendKeys(adminEmailAddress);
		String adminPassword = euObj.readExcelData("TC_31", 8, 1);
		aap.getPasswordTextfield().sendKeys(adminPassword);
		aap.getSaveButton().click();
		// Verify the Alert message using Assert and Accept the Alert
		String expectedPopupMessage;
		expectedPopupMessage = euObj.readExcelData("TC_31", 11, 17);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Logout from the Application
		hp.logOutFormApplication();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_31", 3, 17);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Login to the Application as HR Head (using previously created HR Head Admin credentials)
		String HRHUsername = euObj.readExcelData("TC_31", 7, 1);
		String HRHPassword = euObj.readExcelData("TC_31", 8, 1);
		LoginPage lp = new LoginPage(driver);
		lp.hrHeadLogin(HRHUsername, HRHPassword);
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_31", 2, 17);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// verify the user
		hp.verifyUser(HRHUsername);
		// Go to Employee page
		hp.navigateToAddEmployee();
		// Add New Employee to the Application
		EmployeePage ep = new EmployeePage(driver);
		ep.getAddEmployeeButton().click();
		AddEmployeePage aep = new AddEmployeePage(driver);
		String empCompanyId = euObj.readExcelData("TC_31", 2, 7);
		aep.getCompanyIdTextfield().sendKeys(empCompanyId);
		String empFirstName = euObj.readExcelData("TC_31", 3, 7);
		aep.getFirstNameTextfield().sendKeys(empFirstName);
		String empLastName = euObj.readExcelData("TC_31", 4, 7);
		aep.getLastNameTextfield().sendKeys(empLastName);
		String empMiddleName = euObj.readExcelData("TC_31", 5, 7);
		aep.getMiddleNameTextfield().sendKeys(empMiddleName);
		String empFromDate = euObj.readExcelData("TC_31", 12, 7);
		aep.getBrnchsDateFromTextfield().sendKeys(empFromDate);
		String empRecentDate = euObj.readExcelData("TC_31", 13, 7);
		aep.getBrnchsRecentDateTextfield().sendKeys(empRecentDate);
		String empDepartment = euObj.readExcelData("TC_31", 2, 9);
		aep.selectDepartment(empDepartment);
		String empBranch = euObj.readExcelData("TC_31", 2, 11);
		aep.selectBranch(empBranch);
		String empPosition = euObj.readExcelData("TC_31", 6, 7);
		aep.getPositionTextfield().sendKeys(empPosition);
		String empContactNo = euObj.readExcelData("TC_31", 7, 7);
		aep.getContactNoTextfield().sendKeys(empContactNo);
		String empSss = euObj.readExcelData("TC_31", 8, 7);
		aep.getSssTextfield().sendKeys(empSss);
		String empTin = euObj.readExcelData("TC_31", 9, 7);
		aep.getTinTextfield().sendKeys(empTin);
		String empHdmf = euObj.readExcelData("TC_31", 10, 7);
		aep.getHdmfTextfield().sendKeys(empHdmf);
		String empGsis = euObj.readExcelData("TC_31", 11, 7);
		aep.getGsisTextfield().sendKeys(empGsis);
		aep.uploadEmployeeFile("./src/test/resources/Test.docx");
		aep.uploadEmployeeProfilePicture("./src/test/resources/Test.jpeg");
		aep.getSaveButton().click();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_31", 14, 17);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Logout from the Application
		hp.logOutFormApplication();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_31", 3, 17);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Login to the Application as existing HR Officer Admin credentials
		String OfficerUsername = euObj.readExcelData("TC_31", 2, 14);
		String OfficerPassword = euObj.readExcelData("TC_31", 3, 14);
		lp.hrOfficerLogin(OfficerUsername, OfficerPassword);
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_31", 2, 17);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// verify the user
		hp.verifyUser(OfficerUsername);
		// Go to Employee page
		hp.navigateToAddEmployee();
		// Search for the Employee which was created previously by Newly Added HR Head
		String employeeId = euObj.readExcelData("TC_31", 2, 7);
		ep.getSearchTextfield().sendKeys(employeeId);
		String employeeFirstName = euObj.readExcelData("TC_31", 3, 7);
		// Edit the searched Employee contact number
		ep.clickOnEditEmployeeIcon(driver, employeeFirstName, employeeId);
		EditEmployeePage eep = new EditEmployeePage(driver);
		String expectedContactNo = euObj.readExcelData("TC_31", 10, 1);
		eep.getContactNoTextfield().clear();
		eep.getContactNoTextfield().sendKeys(expectedContactNo);
		eep.uploadEmployeeFile("./src/test/resources/Test.docx");
		eep.uploadEmployeeProfilePicture("./src/test/resources/Test54.jpeg");
		eep.getUpdateButton().click();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_31", 16, 17);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Search for Edited employee and verify that contact no of Employee is updated or not
		ep.getSearchTextfield().sendKeys(employeeId);
		ep.clickOnEditEmployeeIcon(driver, employeeFirstName, employeeId);
		String actualContactNo = eep.getEmployeeContactNumber();
		Assert.assertEquals(actualContactNo, expectedContactNo, "FAIL : Contact number of Employee is not updated and is verified.");
		// Close the Edit Employee Page
		eep.getCloseBtn().click();
	}
}