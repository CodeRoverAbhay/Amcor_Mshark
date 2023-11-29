package com.hrm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericutils.WebDriverUtils;

/**
 * @author Code_Rover_Abhay
 */
public class LoginPage extends WebDriverUtils {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "hr_email")
	WebElement hrEmailTextfield;

	public WebElement getHrEmailTextfield() {
		return hrEmailTextfield;
	}

	@FindBy(name = "hr_password")
	WebElement hrPasswordTextfield;

	public WebElement getHrPasswordTextfield() {
		return hrPasswordTextfield;
	}

	@FindBy(name = "hr_type")
	WebElement hrTypeDropdown;

	public WebElement getHrTypeDropdown() {
		return hrTypeDropdown;
	}

	@FindBy(xpath = "//option[@value='HR Head']")
	WebElement hrHeadDropdownOption;

	/**
	 * This Business Logic is to retrieve the value of HR Head option
	 * 
	 * @return HR Head option value
	 */
	public String getHrHeadDropdownOptionValue() {
		String hrHeadOptionValue = hrHeadDropdownOption.getAttribute("value");
		return hrHeadOptionValue;
	}

	@FindBy(xpath = "//option[@value='HR Officer']")
	WebElement hrOfficerDropdownOption;

	/**
	 * This Business Logic is to retrieve the value of HR Officer option
	 * 
	 * @return HR Officer option value
	 */
	public String getHrOfficerDropdownOptionValue() {
		String hrOfficerOptionValue = hrOfficerDropdownOption.getAttribute("value");
		return hrOfficerOptionValue;
	}

	@FindBy(xpath = "//option[@value='HR Assistant']")
	WebElement hrAssistantDropdownOption;

	/**
	 * This Business Logic is to retrieve the value of HR Assistant option
	 * 
	 * @return HR Assistant option value
	 */
	public String getAssistantDropdownOptionValue() {
		String hrAssistantOptionValue = hrAssistantDropdownOption.getAttribute("value");
		return hrAssistantOptionValue;
	}

	@FindBy(name = "login_hr")
	WebElement signInButton;

	public WebElement getSignInButton() {
		return signInButton;
	}

	/**
	 * This Business Logic is to Login to the application as an HR Head using HR Head credentials
	 */
	public void hrHeadLogin(String hrUserEmail, String hrUserPassword) {
		hrEmailTextfield.sendKeys(hrUserEmail);
		hrPasswordTextfield.sendKeys(hrUserPassword);
		selectDropdownByValue(hrTypeDropdown, getHrHeadDropdownOptionValue());
		signInButton.click();
	}

	/**
	 * This Business Logic is to Login to the application as an HR Officer using HR Officer credentials
	 */
	public void hrOfficerLogin(String hrUserEmail, String hrUserPassword) {
		hrEmailTextfield.sendKeys(hrUserEmail);
		hrPasswordTextfield.sendKeys(hrUserPassword);
		selectDropdownByValue(hrTypeDropdown, getHrOfficerDropdownOptionValue());
		signInButton.click();
	}

	/**
	 * This Business Logic is to Login to the application as an HR Assistant using HR Assistant credentials
	 */
	public void hrAssistantLogin(String hrUserEmail, String hrUserPassword) {
		hrEmailTextfield.sendKeys(hrUserEmail);
		hrPasswordTextfield.sendKeys(hrUserPassword);
		selectDropdownByValue(hrTypeDropdown, getAssistantDropdownOptionValue());
		signInButton.click();
	}
}