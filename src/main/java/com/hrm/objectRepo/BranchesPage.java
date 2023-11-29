package com.hrm.objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Code_Rover_Abhay
 */
public class BranchesPage {
	public BranchesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space(text())='Add Branches']")
	private WebElement addBranchesButton;

	public WebElement getAddBranchesButton() {
		return addBranchesButton;
	}

	@FindBy(xpath = "//select[@name='example1_length']")
	private WebElement showEntriesDropown;

	public WebElement getShowEntriesDropown() {
		return showEntriesDropown;
	}

	@FindBy(xpath = "//option[@value='10']")
	private WebElement show10Enteries;

	public WebElement getShow10Enteries() {
		return show10Enteries;
	}

	@FindBy(xpath = "//option[@value='25']")
	private WebElement show25Enteries;

	public WebElement getShow25Enteries() {
		return show25Enteries;
	}

	@FindBy(xpath = "//option[@value='50']")
	private WebElement show50Enteries;

	public WebElement getShow50Enteries() {
		return show50Enteries;
	}

	@FindBy(xpath = "//option[@value='100']")
	private WebElement show100Enteries;

	public WebElement getShow100Enteries() {
		return show100Enteries;
	}

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTextfield;

	public WebElement getSearchTextfield() {
		return searchTextfield;
	}

	@FindBy(id = "example1_previous")
	private WebElement previousLink;

	public WebElement getPreviousLink() {
		return previousLink;
	}

	@FindBy(xpath = "//a[.='Next']")
	private WebElement nextLink;

	public WebElement getNextLink() {
		return nextLink;
	}

	/**
	 * This Business Logic is to click on Delete Branch button of the specified Branch name
	 * 
	 * @param driver
	 * @param branchName
	 */
	public void clickOnDelete(WebDriver driver, String branchName) {
		driver.findElement(By.xpath("//td[text()='" + branchName + "']/..//button[text()='Delete']")).click();
	}

	/**
	 * This Business Logic is to click on Edit Branch button of the specified Branch name
	 * 
	 * @param driver
	 * @param branchName
	 */
	public void clickOnEdit(WebDriver driver, String branchName) {
		driver.findElement(By.xpath("//td[text()='" + branchName + "']/..//button[text()='Edit']")).click();
	}
}