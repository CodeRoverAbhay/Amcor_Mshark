package com.hrm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericutils.WebDriverUtils;

/**
 * @author Code_Rover_Abhay
 */
public class EditAdminPage extends WebDriverUtils {
	public EditAdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_companyid']")
	private WebElement companyIdTextfield;

	public WebElement getCompanyIdTextfield() {
		return companyIdTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_firstname']")
	private WebElement firstNameTextfield;

	public WebElement getFirstNameTextfield() {
		return firstNameTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_lastname']")
	private WebElement lastNameTextfield;

	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_middlename']")
	private WebElement middleNameTextfield;

	public WebElement getMiddleNameTextfield() {
		return middleNameTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_contactno']")
	private WebElement contactNoTextfield;

	public WebElement getContactNoTextfield() {
		return contactNoTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_email']")
	private WebElement emailAddressTextfield;

	public WebElement getEmailAddressTextfield() {
		return emailAddressTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_password']")
	private WebElement passwordTextfield;

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//select[@name='hr_type']")
	private WebElement positionDropdown;

	public WebElement getPositionDropdown() {
		return positionDropdown;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//button[text()='Save']")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//button[text()='Close']")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}

	/**
	 * This Business Logic is to select the HR Position option by specifying the option's value
	 * 
	 * @param optionValue
	 */
	public void selectHrPositionByValue(String optionValue) {
		selectDropdownByValue(positionDropdown, optionValue);
	}
}