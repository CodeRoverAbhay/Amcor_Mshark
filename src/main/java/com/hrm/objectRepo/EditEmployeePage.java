package com.hrm.objectRepo;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericutils.WebDriverUtils;

/**
 * @author Code_Rover_Abhay
 */
public class EditEmployeePage extends WebDriverUtils {
	public EditEmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_companyid']")
	private WebElement companyIdTextfield;

	public WebElement getCompanyIdTextfield() {
		return companyIdTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_firstname']")
	private WebElement firstNameTextfield;

	public WebElement getFirstNameTextfield() {
		return firstNameTextfield;
	}

	@FindBy(xpath = "(//div[@class='modal fade show']//input[@name='employee_lastname']")
	private WebElement lastNameTextfield;

	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}

	@FindBy(xpath = "(//div[@class='modal fade show']//input[@name='employee_middlename']")
	private WebElement middleNameTextfield;

	public WebElement getMiddleNameTextfield() {
		return middleNameTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='branches_datefrom']")
	private WebElement brnchsDateFromTextfield;

	public WebElement getBrnchsDateFromTextfield() {
		return brnchsDateFromTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='branches_recentdate']")
	private WebElement brnchsRecentDateTextfield;

	public WebElement getBrnchsRecentDateTextfield() {
		return brnchsRecentDateTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//select[@name='employee_department']")
	private WebElement deptDropdown;

	public WebElement getDeptDropdown() {
		return deptDropdown;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//select[@name='employee_branches']")
	private WebElement branchesDropdown;

	public WebElement getBranchesDropdown() {
		return branchesDropdown;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_position']")
	private WebElement positionTextfield;

	public WebElement getPositionTextfield() {
		return positionTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_contact']")
	private WebElement contactNoTextfield;

	public WebElement getContactNoTextfield() {
		return contactNoTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_sss']")
	private WebElement sssTextfield;

	public WebElement getSssTextfield() {
		return sssTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_tin']")
	private WebElement tinTextfield;

	public WebElement getTinTextfield() {
		return tinTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_hdmf_pagibig']")
	private WebElement hdmfTextfield;

	public WebElement getHdmfTextfield() {
		return hdmfTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_gsis']")
	private WebElement gsisTextfield;

	public WebElement getGsisTextfield() {
		return gsisTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_file201']")
	private WebElement fileUploadButton;

	public WebElement getFileUploadButton() {
		return fileUploadButton;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_image']")
	private WebElement employeePictureUploadButton;

	public WebElement getEmployeePictureUploadButton() {
		return employeePictureUploadButton;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//button[text()='Update']")
	private WebElement updateButton;

	public WebElement getUpdateButton() {
		return updateButton;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//button[text()='Close']")
	private WebElement closeButton;

	public WebElement getCloseBtn() {
		return closeButton;
	}

	/**
	 * This Business Logic is to select the Department by specifying the Department option's visible text
	 * 
	 * @param deptVisibleText
	 */
	public void selectDepartment(String deptVisibleText) {
		selectDropdownByText(deptDropdown, deptVisibleText);
	}

	/**
	 * This Business Logic is to select the Branch by specifying the Branch option's visible text
	 * 
	 * @param branchVisibleText
	 */
	public void selectBranch(String branchVisibleText) {
		selectDropdownByText(branchesDropdown, branchVisibleText);
	}

	/**
	 * This Business Logic is to upload the Employee File document by specifying relative path of File
	 * 
	 * @param relativeFilePath
	 */
	public void uploadEmployeeFile(String relativeFilePath) {
		File employeeFileRelativePath = new File(relativeFilePath);
		String empFileAbsolutepath = employeeFileRelativePath.getAbsolutePath();
		fileUploadButton.sendKeys(empFileAbsolutepath);
	}

	/**
	 * This Business Logic is to upload the Employee profile picture by specifying relative path of picture
	 * 
	 * @param relativeFilePath
	 */
	public void uploadEmployeeProfilePicture(String relativeFilePath) {
		File employeeProfilePictureRelativePath = new File(relativeFilePath);
		String empProfilePictureAbsolutepath = employeeProfilePictureRelativePath.getAbsolutePath();
		employeePictureUploadButton.sendKeys(empProfilePictureAbsolutepath);
	}
	
	/**
	 * This method is to get the contact number of the employee
	 * 
	 * @return Employee's contact number
	 */
	public String getEmployeeContactNumber ( ) {
		String empContactNo = getContactNoTextfield().getAttribute("value");
		return empContactNo;
	}
}