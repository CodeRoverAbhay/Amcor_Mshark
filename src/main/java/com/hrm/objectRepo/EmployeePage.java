package com.hrm.objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Code_Rover_Abhay
 */
public class EmployeePage {
	public EmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space(.)='Add Employee']")
	private WebElement addEmployeeButon;

	public WebElement getAddEmployeeButton() {
		return addEmployeeButon;
	}

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTextfield;

	public WebElement getSearchTextfield() {
		return searchTextfield;
	}
	
	@FindBy (xpath = "(//td[@class='sorting_1'])[1]")
	private WebElement employeeId;
	
	/**
	 * This method is to get the String value of the Employee ID
	 * 
	 * @return Employee ID value
	 */
	public String getEmployeeIdValue() {
		String employeeIdValue = employeeId.getText();
		return employeeIdValue;
	}
	
	@FindBy(xpath = "//i[@title='Edit Employee']")
	private WebElement editBtn;

	public WebElement getEditBtn() {
		return editBtn;
	}

	@FindBy(xpath = "//i[@title='View Employee']")
	private WebElement viewBtn;

	public WebElement getViewBtn() {
		return viewBtn;
	}

	@FindBy(xpath = "//i[@title='Delete Employee']")
	private WebElement deleteBtn;

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	@FindBy(xpath = "//a[@title='Download File 201']")
	private WebElement dwnldFile201Btn;

	public WebElement getDwnldFile201Btn() {
		return dwnldFile201Btn;
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

	/**
	 * This Business Logic is to click on Edit Employee icon of the specified Employee's First name and Employee's Company Id
	 * 
	 * @param driver
	 * @param employeeFirstName
	 * @param companyId
	 */
	public void clickOnEditEmployeeIcon(WebDriver driver, String employeeFirstName, String companyId) {
		WebElement editEmployeeIcon = driver.findElement(By.xpath("//td[text()='" + employeeFirstName + "']/..//td[@class='sorting_1' and text()='" + companyId + "']/..//td//i[@title='Edit Employee']"));
		editEmployeeIcon.click();
	}

	/**
	 * This Business Logic is to click on Delete Employee icon of the specified Employee's First name and Employee's Company Id
	 * 
	 * @param driver
	 * @param employeeFirstName
	 * @param companyId
	 */
	public void clickOnDeleteEmployeeIcon(WebDriver driver, String employeeFirstName, String companyId) {
		WebElement deleteEmpliyeeIcon = driver.findElement(By.xpath("//td[text()='" + employeeFirstName	+ "']/..//td[@class='sorting_1' and text()='" + companyId + "']/..//td//i[@title='Delete Employee']"));
		deleteEmpliyeeIcon.click();
	}

	/**
	 * This Business Logic is to click on Downliad Employee File icon of the specified Employee's First name and Employee's Company Id
	 * 
	 * @param driver
	 * @param employeeFirstName
	 * @param companyId
	 */
	public void clickOnDownloadFileIcon(WebDriver driver, String employeeFirstName, String companyId) {
		WebElement downloadEmployeeFileIcon = driver.findElement(By.xpath("//td[text()='" + employeeFirstName + "']/..//td[@class='sorting_1' and text()='"+ companyId + "']/..//td//a[@title='Download File 201']"));
		downloadEmployeeFileIcon.click();
	}
	
	/**
	 * This Business Logic is to get the First name of the Employee with specified EmployeeID from Employee list
	 * 
	 * @param driver
	 * @param employeeId
	 * @return First Employee's First Name
	 */
	public String getFirstEmployeeFirstNameFromList(WebDriver driver, String employeeId) {
		WebElement firstEmpFirstNameEle = driver.findElement(By.xpath("(//td[text()='" + employeeId + "']/../td[3])[1]"));
		String firstEmployeeFirstName = firstEmpFirstNameEle.getText();
		return firstEmployeeFirstName;
	}
}