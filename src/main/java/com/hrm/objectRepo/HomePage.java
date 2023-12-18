package com.hrm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author Code_Rover_Abhay
 */
public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashBoardTab;

	public WebElement getDashBoardTab() {
		return dashBoardTab;
	}

	@FindBy(xpath = "//p[normalize-space(text())='CORPORATE']")
	private WebElement corporateTab;

	public WebElement getCorporateTab() {
		return corporateTab;
	}

	@FindBy(xpath = "//p[normalize-space(text())='Add Corporate']")
	private WebElement addCorporateOption;

	public WebElement getAddCorporateOption() {
		return addCorporateOption;
	}

	@FindBy(xpath = "//p[normalize-space(text())='BRANCHES']")
	private WebElement branchTab;

	public WebElement getBranchTab() {
		return branchTab;
	}

	@FindBy(xpath = "//p[normalize-space(text())='Add Braches']")
	private WebElement addBranchesOption;

	public WebElement getAddBranchesOption() {
		return addBranchesOption;
	}

	@FindBy(xpath = "//p[normalize-space(text())='EMPLOYEE']")
	private WebElement employeeTab;

	public WebElement getEmployeeTab() {
		return employeeTab;
	}

	@FindBy(xpath = "//p[normalize-space(text())='Add Employee']")
	private WebElement addEmployeeOption;

	public WebElement getAddEmployeeOption() {
		return addEmployeeOption;
	}

	@FindBy(xpath = "//p[normalize-space(text())='ADMIN']")
	private WebElement adminTab;

	public WebElement getAdminTab() {
		return adminTab;
	}

	@FindBy(xpath = "//p[normalize-space(text())='Add Admin']")
	private WebElement addAdminOption;

	public WebElement getAddAdminOption() {
		return addAdminOption;
	}

	@FindBy(xpath = "//span[.='Employee']/following-sibling::span")
	private WebElement dashBoardEmployeeCount;

	/**
	 * This Business Logic is to retriev the current count of Employee registered in the application
	 * 
	 * @return Total number of Employees
	 */
	public int getDashBoardEmployeeCount() {
		String employeeCount = dashBoardEmployeeCount.getText();
		int currentEmployeeCount = Integer.parseInt(employeeCount);
		return currentEmployeeCount;
	}
	
	/**
	 * This Business Logic is to verify the Employee count in KPI after registered one Employee into the application
	 * 
	 * @param initialEmployeeCount
	 */
	public void verifyUpdatedDashboardEmployeeCountAfterDelete (int initialEmployeeCount) {
		String employeeCount = dashBoardEmployeeCount.getText();
		int actualEmployeeCount = Integer.parseInt(employeeCount);
		int expectedEmployeeCount = initialEmployeeCount - 1;
		Assert.assertEquals(actualEmployeeCount, expectedEmployeeCount, "Mismatch in Employee count after deleting one Employee from the Application.");
	}


	@FindBy(xpath = "//span[.='Corporate']/following-sibling::span")
	private WebElement dashboardCorporateCount;

	/**
	 * This Business Logic is to retriev the current count of Corporate registered in the application
	 * 
	 * @return Total number of Corporates
	 */
	public int getDashboardCorporateCount() {
		String corporateCount = dashboardCorporateCount.getText();
		int currentCorporateCount = Integer.parseInt(corporateCount);
		return currentCorporateCount;
	}

	@FindBy(xpath = "//span[.='Braches']/following-sibling::span")
	private WebElement dashboardBranchesCount;

	/**
	 * This Business Logic is to retriev the current count of Branches registered in the application
	 * 
	 * @return Total number of Branches
	 */
	public int getDashboardBranchesCount() {
		String dashboardBranchesCount = dashboardCorporateCount.getText();
		int currentBranchesCount = Integer.parseInt(dashboardBranchesCount);
		return currentBranchesCount;
	}

	@FindBy(xpath = "//span[.='Admin Account']/following-sibling::span")
	private WebElement dashboardAdminAccountCount;

	/**
	 * This Business Logic is to retriev the current count of Admin registered in the application
	 * 
	 * @return Total number of Admin
	 */
	public int getDashboardAdminAccountCount() {
		String dashboardAdminAccountCount = dashboardCorporateCount.getText();
		int currentAdminAccountCount = Integer.parseInt(dashboardAdminAccountCount);
		return currentAdminAccountCount;
	}
	
	@FindBy(className = "d-block")
	private WebElement currentUserEmailId;

	/**
	 * This Business Logic is to retriev the email address of the user who has sign-in to the application
	 * 
	 * @return Current user email address
	 */
	public String getCurrentUserEMailId() {
		String currentUserNameEmailId = currentUserEmailId.getText();
		return currentUserNameEmailId;
	}
	
	/**
	 * This business logic is to verify the user email Id who have logged in to the Applicaion using Assert
	 * 
	 * @param expectedUserEmailId
	 */
	public void verifyUser (String expectedUserEmailId) {
		String actualUserNameEmailId = currentUserEmailId.getText();
		Assert.assertEquals(actualUserNameEmailId, expectedUserEmailId, "User Email Id is not matching.");
	}

	@FindBy(xpath = "//i[@class='fa fa-user']/..")
	private WebElement userProfileIcon;

	public WebElement getUserProfileIcon() {
		return userProfileIcon;
	}

	@FindBy(xpath = "//i[@class='fa fa-power-off']")
	private WebElement logOutLink;

	public WebElement getLogOutLink() {
		return logOutLink;
	}

	/**
	 * This Business Logic is to navigate to the Corporate page
	 */
	public void navigateToAddCorporate() {
		corporateTab.click();
		addCorporateOption.click();
	}

	/**
	 * This Business Logic is to navigate to the Branches page
	 */
	public void navigateToAddBranches() {
		branchTab.click();
		addBranchesOption.click();
	}

	/**
	 * This Business Logic is to navigate to the Employee page
	 */
	public void navigateToAddEmployee() {
		employeeTab.click();
		addEmployeeOption.click();
	}

	/**
	 * This Business Logic is to navigate to the Admin page
	 */
	public void navigateToAddAdmin() {
		adminTab.click();
		addAdminOption.click();
	}

	/**
	 * This Business Logic is to navigate to the Dashboard page
	 */
	public void naviagateToDashboardKpiTracker() {
		dashBoardTab.click();
	}

	/**
	 * This Business Logic is to Logout from the application
	 */
	public void logOutFormApplication() {
		userProfileIcon.click();
		logOutLink.click();
	}
}