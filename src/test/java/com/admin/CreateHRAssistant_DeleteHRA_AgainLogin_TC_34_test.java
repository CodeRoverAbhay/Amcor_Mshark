package com.admin;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericutils.BaseClass;
import com.hrm.objectRepo.AddAdminPage;
import com.hrm.objectRepo.AdminPage;
import com.hrm.objectRepo.DeleteAdminPage;
import com.hrm.objectRepo.HomePage;
import com.hrm.objectRepo.LoginPage;

@Listeners(com.hrm.genericutils.ListenerImplementationClass.class)

//E2E [ Create HR Assistant and check for login and log out of new HR Assistant, then delete that New HR Assistant and try to login it ]

public class CreateHRAssistant_DeleteHRA_AgainLogin_TC_34_test extends BaseClass{
	
	//@Parameters("browser")
	@Test(groups = "system", retryAnalyzer = com.hrm.genericutils.RetryImplementationClass.class)
	public void tc_34_test() throws IOException {
		// For cross browser
		//public void tc_34_test(String browser) throws IOException {
		
		// Retrieve common data from Properties file or Excel for Login
		String url = puObj.readDataFromPropertiesFile("url");
		String userEmail = puObj.readDataFromPropertiesFile("userEmail");
		String password = puObj.readDataFromPropertiesFile("password");
		// Trigger the URL
		driver.get(url);
		// Login to Application as HR Head
		LoginPage lp = new LoginPage(driver);
		lp.hrHeadLogin(userEmail, password);
		// Verify the Alert message using Assert and Accept the Alert
		String expectedPopupMessage;
		expectedPopupMessage = euObj.readExcelData("TC_34", 2, 7);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// From Home page Go to Admin page
		HomePage hp = new HomePage(driver);
		// Verify the user
		hp.verifyUser(userEmail);
		// From Home page navigate to Admin page
		hp.navigateToAddAdmin();
		// Add New Admin to the Application with position as HR Assistant
		AdminPage ap = new AdminPage(driver);
		ap.getAddAdminButton().click();
		AddAdminPage aap = new AddAdminPage(driver);
		String companyId = euObj.readExcelData("TC_34", 2, 1);
		aap.getCompanyIdTextfield().sendKeys(companyId);
		String adminFirstName = euObj.readExcelData("TC_34", 3, 1);
		aap.getFirstNameTextfield().sendKeys(adminFirstName);
		String adminLastName = euObj.readExcelData("TC_34", 4, 1);
		aap.getLastNameTextfield().sendKeys(adminLastName);
		String adminMiddleName = euObj.readExcelData("TC_34", 5, 1);
		aap.getMiddleNameTextfield().sendKeys(adminMiddleName);
		String adminContactNo = euObj.readExcelData("TC_34", 6, 1);
		aap.getContactNoTextfield().sendKeys(adminContactNo);
		String hrPositionType = euObj.readExcelData("TC_34", 2, 4);
		aap.selectHrPositionByValue(driver, hrPositionType);
		String adminEmailAddress = euObj.readExcelData("TC_34", 7, 1);
		aap.getEmailAddressTextfield().sendKeys(adminEmailAddress);
		String adminPassword = euObj.readExcelData("TC_34", 8, 1);
		aap.getPasswordTextfield().sendKeys(adminPassword);
		aap.getSaveButton().click();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_34", 11, 7);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Logout from the Application
		hp.logOutFormApplication();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_34", 3, 7);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Login to the Application as HR Assistant (using Previously added Admin credentials)
		lp.hrAssistantLogin(adminEmailAddress, adminPassword);
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_34", 2, 7);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Verify the Login process using current User Email Id displayed in User's Home Page
		hp.verifyUser(adminEmailAddress);
		// Logout from the Application
		hp.logOutFormApplication();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_34", 3, 7);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Login to the Application as HR Head
		lp.hrHeadLogin(userEmail, password);
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_34", 2, 7);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Verify the user
		hp.verifyUser(userEmail);
		// Go to Admin page
		hp.navigateToAddAdmin();
		// Delete the previously created Admin (HR Assistant)
		String assistantAdminFirstName = euObj.readExcelData("TC_34", 3, 1);
		ap.getSearchTextfield().sendKeys(assistantAdminFirstName);
		String assistantAdminCompanyId = euObj.readExcelData("TC_34", 2, 1);
		ap.clickOnDeleteAdminIcon(driver, assistantAdminFirstName, assistantAdminCompanyId);
		DeleteAdminPage dap = new DeleteAdminPage(driver);
		dap.getDeleteButton().click();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_34", 12, 7);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Logout from the Application
		hp.logOutFormApplication();
		// Verify the Alert message using Assert and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_34", 3, 7);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Login to Application as HR Assistant using Deleted HR Assistant credentials
		lp.hrAssistantLogin(adminEmailAddress, adminPassword);
		// Verify the Alert message and Accept the Alert
		expectedPopupMessage = euObj.readExcelData("TC_34", 4, 7);
		wuObj.acceptAlertWithAssert(driver, expectedPopupMessage);
		// Read common data from Properties file
		userEmail = puObj.readDataFromPropertiesFile("userEmail");
		password = puObj.readDataFromPropertiesFile("password");
		// Login to the Application
		lp.hrHeadLogin(userEmail, password);
		// Print the Alert pop message and Accept the Alert
		wuObj.printAlertMessageAndAcceptAlert(driver);
	}
}