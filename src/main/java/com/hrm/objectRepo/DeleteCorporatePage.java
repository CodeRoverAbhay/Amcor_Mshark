package com.hrm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Code_Rover_Abhay
 */
public class DeleteCorporatePage {
	public DeleteCorporatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='modal fade show']//button[text()='Delete']")
	private WebElement deleteButton;

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//button[text()='Delete']/preceding-sibling::button[text()='Close']")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}
}