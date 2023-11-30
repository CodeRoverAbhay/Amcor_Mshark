package com.admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericutils.BaseClass;
import com.hrm.objectRepo.AddAdminPage;
import com.hrm.objectRepo.AddBranchesPage;
import com.hrm.objectRepo.AddCorporatePage;
import com.hrm.objectRepo.AddEmployeePage;
import com.hrm.objectRepo.AdminPage;
import com.hrm.objectRepo.BranchesPage;
import com.hrm.objectRepo.CorporatePage;
import com.hrm.objectRepo.EmployeePage;
import com.hrm.objectRepo.HomePage;
import com.hrm.objectRepo.LoginPage;

@Listeners(com.hrm.genericutils.ListenerImplementationClass.class)

// E2E [ Add Corporate, Branch, HR Officer and then Add Employee from HR Officer ]

public class AddEmployee_TC_01_test extends BaseClass {
	@Test(groups = "system", retryAnalyzer = com.hrm.genericutils.RetryImplementationClass.class)
	public void tc_01_test() throws IOException {
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
		// From Hope page, go to Corporate Page
		hp.navigateToAddCorporate();
		CorporatePage cp = new CorporatePage(driver);
		// Add Corporate to the application
		cp.getAddCorporateButton().click();
		AddCorporatePage acp = new AddCorporatePage(driver);
		String corporateName = euObj.readExcelData("TC_01", 2, 4);
		acp.addCorporate(corporateName);
		// Verify the Alert message using Assert and Accept the Alert
		String expectedPopupMessage;
		expectedPopupMessage = euObj.readExcelData("TC_01", 5, 19);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Go to Branch Page
		hp.navigateToAddBranches();
		BranchesPage bp = new BranchesPage(driver);
		// Add Branch to the application
		bp.getAddBranchesButton().click();
		AddBranchesPage abp = new AddBranchesPage(driver);
		String branchName = euObj.readExcelData("TC_01", 2, 7);
		abp.addBranche(branchName);
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_01", 8, 19);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Go to Admin Page
		hp.navigateToAddAdmin();
		// Add New Admin to the application with position HR Officer
		AdminPage ap = new AdminPage(driver);
		ap.getAddAdminButton().click();
		AddAdminPage aap = new AddAdminPage(driver);
		String companyId = euObj.readExcelData("TC_01", 2, 10);
		aap.getCompanyIdTextfield().sendKeys(companyId);
		String adminFirstName = euObj.readExcelData("TC_01", 3, 10);
		aap.getFirstNameTextfield().sendKeys(adminFirstName);
		String adminLastName = euObj.readExcelData("TC_01", 4, 10);
		aap.getLastNameTextfield().sendKeys(adminLastName);
		String adminMiddleName = euObj.readExcelData("TC_01", 5, 10);
		aap.getMiddleNameTextfield().sendKeys(adminMiddleName);
		String adminContactNo = euObj.readExcelData("TC_01", 6, 10);
		aap.getContactNoTextfield().sendKeys(adminContactNo);
		String hrPositionType = euObj.readExcelData("TC_01", 2, 13);
		aap.selectHrPositionByValue(driver, hrPositionType);
		String adminEmailAddress = euObj.readExcelData("TC_01", 7, 10);
		aap.getEmailAddressTextfield().sendKeys(adminEmailAddress);
		String adminPassword = euObj.readExcelData("TC_01", 8, 10);
		aap.getPasswordTextfield().sendKeys(adminPassword);
		aap.getSaveButton().click();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_01", 11, 19);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Logout from the Application
		hp.logOutFormApplication();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_01", 3, 19);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Login to Application as HR Officer (Newly created HR Officer Admin)
		String hrOfficerUserEmail = euObj.readExcelData("TC_01", 7, 10);
		String hrOfficerPasswors = euObj.readExcelData("TC_01", 8, 10);
		lp.hrOfficerLogin(hrOfficerUserEmail, hrOfficerPasswors);
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_01", 2, 19);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// verify the user and Go to Employee page
		hp.verifyUser(hrOfficerUserEmail);
		hp.navigateToAddEmployee();
		// Add New Employee to the Application
		EmployeePage ep = new EmployeePage(driver);
		ep.getAddEmployeeButton().click();
		AddEmployeePage aep = new AddEmployeePage(driver);
		String empCompanyId = euObj.readExcelData("TC_01", 2, 16);
		aep.getCompanyIdTextfield().sendKeys(empCompanyId);
		String empFirstName = euObj.readExcelData("TC_01", 3, 16);
		aep.getFirstNameTextfield().sendKeys(empFirstName);
		String empLastName = euObj.readExcelData("TC_01", 4, 16);
		aep.getLastNameTextfield().sendKeys(empLastName);
		String empMiddleName = euObj.readExcelData("TC_01", 5, 16);
		aep.getMiddleNameTextfield().sendKeys(empMiddleName);
		String empFromDate = euObj.readExcelData("TC_01", 6, 16);
		aep.getBrnchsDateFromTextfield().sendKeys(empFromDate);
		String empRecentDate = euObj.readExcelData("TC_01", 7, 16);
		aep.getBrnchsRecentDateTextfield().sendKeys(empRecentDate);
		String empDepartment = euObj.readExcelData("TC_01", 2, 4);
		aep.selectDepartment(empDepartment);
		String empBranch = euObj.readExcelData("TC_01", 2, 7);
		aep.selectBranch(empBranch);
		String empPosition = euObj.readExcelData("TC_01", 8, 16);
		aep.getPositionTextfield().sendKeys(empPosition);
		String empContactNo = euObj.readExcelData("TC_01", 9, 16);
		aep.getContactNoTextfield().sendKeys(empContactNo);
		String empSss = euObj.readExcelData("TC_01", 10, 16);
		aep.getSssTextfield().sendKeys(empSss);
		String empTin = euObj.readExcelData("TC_01", 11, 16);
		aep.getTinTextfield().sendKeys(empTin);
		String empHdmf = euObj.readExcelData("TC_01", 12, 16);
		aep.getHdmfTextfield().sendKeys(empHdmf);
		String empGsis = euObj.readExcelData("TC_01", 13, 16);
		aep.getGsisTextfield().sendKeys(empGsis);
		aep.uploadEmployeeFile("./src/test/resources/Test.docx");
		aep.uploadEmployeeProfilePicture("./src/test/resources/Test.jpeg");
		aep.getSaveButton().click();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_01", 14, 19);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Search for Newly created Employee and Verify if Employee is Added to the Application or Not
		String expEmployeeId = euObj.readExcelData("TC_01", 2, 16);
		ep.getSearchTextfield().sendKeys(expEmployeeId);
		String actEmployeeId = ep.getEmployeeIdValue();
		Assert.assertEquals(actEmployeeId, expEmployeeId, "FAILED : HR Officer couldn't add the Employee.");
	}
}