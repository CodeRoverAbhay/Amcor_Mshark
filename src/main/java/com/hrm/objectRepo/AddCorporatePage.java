package com.hrm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Code_Rover_Abhay
 */
public class AddCorporatePage {
	public AddCorporatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//form//input[@name='corporate_name']")
	private WebElement corporateNameTextfield;

	public WebElement getCorporateNameTextfield() {
		return corporateNameTextfield;
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
	 * This Business Logic is to Add Corporate to the application
	 * 
	 * @param branchName
	 */
	public void addCorporate(String corporateName) {
		corporateNameTextfield.clear();
		corporateNameTextfield.sendKeys(corporateName);
		saveButton.click();
	}
}