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
public class AddEmployeePage extends WebDriverUtils {
	public AddEmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//form//input[@name='employee_companyid']")
	private WebElement companyIdTextfield;

	public WebElement getCompanyIdTextfield() {
		return companyIdTextfield;
	}

	@FindBy(xpath = "//form//input[@name='employee_firstname']")
	private WebElement firstNameTextfield;

	public WebElement getFirstNameTextfield() {
		return firstNameTextfield;
	}

	@FindBy(xpath = "//form//input[@name='employee_lastname']")
	private WebElement lastNameTextfield;

	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}

	@FindBy(xpath = "//form//input[@name='employee_middlename']")
	private WebElement middleNameTextfield;

	public WebElement getMiddleNameTextfield() {
		return middleNameTextfield;
	}

	@FindBy(xpath = "//form//input[@name='branches_datefrom']")
	private WebElement brnchsDateFromTextfield;

	public WebElement getBrnchsDateFromTextfield() {
		return brnchsDateFromTextfield;
	}

	@FindBy(xpath = "//form//input[@name='branches_recentdate']")
	private WebElement brnchsRecentDateTextfield;

	public WebElement getBrnchsRecentDateTextfield() {
		return brnchsRecentDateTextfield;
	}

	@FindBy(xpath = "//form//select[@name='employee_department']")
	private WebElement deptDropdown;

	public WebElement getDeptDropdown() {
		return deptDropdown;
	}

	@FindBy(xpath = "//form//select[@name='employee_branches']")
	private WebElement branchesDropdown;

	public WebElement getBranchesDropdown() {
		return branchesDropdown;
	}

	@FindBy(xpath = "//form//input[@name='employee_position']")
	private WebElement positionTextfield;

	public WebElement getPositionTextfield() {
		return positionTextfield;
	}

	@FindBy(xpath = "//form//input[@name='employee_contact']")
	private WebElement contactNoTextfield;

	public WebElement getContactNoTextfield() {
		return contactNoTextfield;
	}

	@FindBy(xpath = "//form//input[@name='employee_sss']")
	private WebElement sssTextfield;

	public WebElement getSssTextfield() {
		return sssTextfield;
	}

	@FindBy(xpath = "//form//input[@name='employee_tin']")
	private WebElement tinTextfield;

	public WebElement getTinTextfield() {
		return tinTextfield;
	}

	@FindBy(xpath = "//form//input[@name='employee_hdmf_pagibig']")
	private WebElement hdmfTextfield;

	public WebElement getHdmfTextfield() {
		return hdmfTextfield;
	}

	@FindBy(xpath = "//form//input[@name='employee_gsis']")
	private WebElement gsisTextfield;

	public WebElement getGsisTextfield() {
		return gsisTextfield;
	}

	@FindBy(xpath = "//form//input[@name='employee_file201']")
	private WebElement fileUploadButton;

	public WebElement getFileUploadButton() {
		return fileUploadButton;
	}

	@FindBy(xpath = "//form//input[@name='employee_image']")
	private WebElement employeePictureUploadButton;

	public WebElement getEmployeePictureUploadButton() {
		return employeePictureUploadButton;
	}

	@FindBy(xpath = "//form//button[text()='Save']")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	@FindBy(xpath = "//form//button[text()='Close']")
	private WebElement closeButton;

	public WebElement getCloseBtn() {
		return closeButton;
	}

	/**
	 * This Business Logic is to select the existing Department using the option's visible text
	 * 
	 * @param deptVisibleText
	 */
	public void selectDepartment(String deptVisibleText) {
		selectDropdownByText(deptDropdown, deptVisibleText);
	}

	/**
	 * This Business Logic is to select the existing Branch using the option's visible text
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
}