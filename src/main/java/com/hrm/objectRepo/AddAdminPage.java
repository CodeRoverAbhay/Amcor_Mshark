package com.hrm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericutils.WebDriverUtils;

/**
 * @author Code_Rover_Abhay
 */
public class AddAdminPage extends WebDriverUtils{
	public AddAdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//form//input[@name='hr_companyid']")
	private WebElement companyIdTextfield;

	public WebElement getCompanyIdTextfield() {
		return companyIdTextfield;
	}

	@FindBy(xpath = "//form//input[@name='hr_firstname']")
	private WebElement firstNameTextfield;

	public WebElement getFirstNameTextfield() {
		return firstNameTextfield;
	}

	@FindBy(xpath = "//form//input[@name='hr_lastname']")
	private WebElement lastNameTextfield;

	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}

	@FindBy(xpath = "//form//input[@name='hr_middlename']")
	private WebElement middleNameTextfield;

	public WebElement getMiddleNameTextfield() {
		return middleNameTextfield;
	}

	@FindBy(xpath = "//form//input[@name='hr_contactno']")
	private WebElement contactNoTextfield;

	public WebElement getContactNoTextfield() {
		return contactNoTextfield;
	}

	@FindBy(xpath = "//form//input[@name='hr_email']")
	private WebElement emailAddressTextfield;

	public WebElement getEmailAddressTextfield() {
		return emailAddressTextfield;
	}

	@FindBy(xpath = "//form//input[@name='hr_password']")
	private WebElement passwordTextfield;

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	@FindBy(xpath = "//form//select[@name='hr_type']")
	private WebElement positionDropdown;

	public WebElement getPositionDropdown() {
		return positionDropdown;
	}

	@FindBy(xpath = "//form//button[text()='Save']")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	@FindBy(xpath = "//form//button[text()='Close']")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}

	/**
	 * This Business Logic is to select the HR Position type using the option's value
	 * 
	 * @param driver
	 * @param optionsValue
	 */
	public void selectHrPositionByValue(WebDriver driver, String optionsValue) {
		selectDropdownByValue(positionDropdown, optionsValue);
	}
}