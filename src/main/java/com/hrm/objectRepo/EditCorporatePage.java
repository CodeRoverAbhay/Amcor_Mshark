package com.hrm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Code_Rover_Abhay
 */
public class EditCorporatePage {
	public EditCorporatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='corporate_name']")
	private WebElement corporateNameTextfield;

	public WebElement getCorporateNameTextfield() {
		return corporateNameTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='corporate_name']/../../descendant::button[text()='Update']")
	private WebElement updateButton;

	public WebElement getUpdateButton() {
		return updateButton;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='corporate_name']/../../descendant::button[text()='Close']")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}
/**
 * This Business Logic is to update the previously selected Corporate by specifying the updated Corporate name
 * @param corporateNameToUpdate
 */
	public void editCorporate(String corporateNameToUpdate) {
		corporateNameTextfield.clear();
		corporateNameTextfield.sendKeys(corporateNameToUpdate);
		updateButton.click();
	}
}