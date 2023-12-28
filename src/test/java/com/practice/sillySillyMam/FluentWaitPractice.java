package com.practice.sillySillyMam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericutils.BaseClass;
import com.hrm.genericutils.WebDriverUtils;
import com.hrm.objectRepo.AdminPage;
import com.hrm.objectRepo.BranchesPage;
import com.hrm.objectRepo.CorporatePage;
import com.hrm.objectRepo.DeleteAdminPage;
import com.hrm.objectRepo.DeleteBranchPage;
import com.hrm.objectRepo.DeleteCorporatePage;
import com.hrm.objectRepo.DeleteEmployeePage;
import com.hrm.objectRepo.EmployeePage;
import com.hrm.objectRepo.HomePage;
import com.hrm.objectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.hrm.genericutils.ListenerImplementationClass.class)
public class FluentWaitPractice extends BaseClass{
	@Test
	public void fluentWaitTest() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/intl/en_in/earth/");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(org.openqa.selenium.NoSuchElementException.class);
		WebElement launchEarthLink = driver.findElement(By.xpath("//a[normalize-space(text())='Google Earth on mobile']"));
		wait.until(ExpectedConditions.visibilityOf(launchEarthLink)).click();
		driver.quit();
	}
	
	@Test (invocationCount = 103)
	public void deleteCorporate () {
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		LoginPage lp = new LoginPage(driver);
		lp.hrHeadLogin("hrhead@gmail.com", "hrhead@123");
		WebDriverUtils wdu = new WebDriverUtils();
		wdu.acceptAlert(driver);
		HomePage hp = new HomePage(driver);
		hp.navigateToAddCorporate();
		CorporatePage cp = new CorporatePage(driver);
		cp.getSearchTextfield().sendKeys("Quality");
		cp.clickOnDelete(driver, "Quality Assurance");
		DeleteCorporatePage dc = new DeleteCorporatePage(driver);
		dc.getDeleteButton().click();
		wdu.acceptAlert(driver);
	}
	
	@Test (invocationCount = 96)
	public void deleteBranches () {
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		LoginPage lp = new LoginPage(driver);
		lp.hrHeadLogin("hrhead@gmail.com", "hrhead@123");
		WebDriverUtils wdu = new WebDriverUtils();
		wdu.acceptAlert(driver);
		HomePage hp = new HomePage(driver);
		hp.navigateToAddBranches();
		BranchesPage bp = new BranchesPage(driver);
		bp.getSearchTextfield().sendKeys("Vadodara");
		bp.clickOnDelete(driver, "Vadodara, Gujarat");
		DeleteBranchPage db = new DeleteBranchPage(driver);
		db.getDeleteButton().click();
		wdu.acceptAlert(driver);
	}
	
	@Test (invocationCount = 50)
	public void deleteAdmin () {
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		LoginPage lp = new LoginPage(driver);
		lp.hrHeadLogin("hrhead@gmail.com", "hrhead@123");
		WebDriverUtils wdu = new WebDriverUtils();
		wdu.acceptAlert(driver);
		HomePage hp = new HomePage(driver);
		hp.navigateToAddAdmin();
		AdminPage ap = new AdminPage(driver);
		ap.getSearchTextfield().sendKeys("Harish");
		ap.clickOnDeleteAdminIcon(driver, "Harish", "AM15101");
		DeleteAdminPage da = new DeleteAdminPage(driver);
		da.getDeleteButton().click();
		wdu.acceptAlert(driver);
	}
	
	@Test (invocationCount = 37)
	public void deleteEmployee () {
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		LoginPage lp = new LoginPage(driver);
		lp.hrHeadLogin("hrhead@gmail.com", "hrhead@123");
		WebDriverUtils wdu = new WebDriverUtils();
		wdu.acceptAlert(driver);
		HomePage hp = new HomePage(driver);
		hp.navigateToAddEmployee();
		EmployeePage ep = new EmployeePage(driver);
		ep.getSearchTextfield().sendKeys("Hrithik");
		ep.clickOnDeleteEmployeeIcon(driver, "Hrithik", "AM04578");
		DeleteEmployeePage dep = new DeleteEmployeePage(driver);
		dep.getDeleteButton().click();
		wdu.acceptAlert(driver);
	}
}