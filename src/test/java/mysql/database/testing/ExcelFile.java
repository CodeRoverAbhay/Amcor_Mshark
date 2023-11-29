package mysql.database.testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Read data from Excel sheet
		
		// Setp 1 : Create an object of File input stream and create workbook
		Workbook workbook = WorkbookFactory.create(new FileInputStream(".//src/test/resources/Testdata.xlsx"));
		
		// Step 2 : Retrieve the cell data from the work sheet and store it in a variable
		String cellValue = workbook.getSheet("TC_DATA").getRow(1).getCell(1).getStringCellValue();
		
		// Step 3 : Use the retrieved data in your script
		System.out.println("Name is : " + cellValue);
		
		// To get multiple data 
		Sheet sheet = workbook.getSheet("TC_DATA");
		int rowCount = sheet.getLastRowNum();
		
		for (int i = 0; i<=rowCount; i++) {
			int cellCount = sheet.getRow(i).getLastCellNum();
			for (int j = 0; j<cellCount; j++) {
				String data = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data + ", ");
			}
		}
		
		// step 4 : Close the workbook (Optional)
		workbook.close();
		
		// To write the data in Excel sheet
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.findElement(By.name("hr_email")).sendKeys("hrhead@gmail.com");
		driver.findElement(By.name("hr_password")).sendKeys("hrhead@123");
		Select select = new Select(driver.findElement(By.id("hr_type")));
		select.selectByValue("HR Head");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		String popupMsg = wait.until(ExpectedConditions.alertIsPresent()).getText();
		System.out.println(popupMsg);
		driver.switchTo().alert().accept();
		driver.manage().window().minimize();
		driver.quit();
		
		// Create an workbook
		Workbook wb = WorkbookFactory.create(new FileInputStream(".//src/test/resources/Testdata.xlsx"));
		
		// Step 2 : Set the value in Excel sheet cell
		wb.getSheet("TC_RESULT").getRow(0).getCell(0).setCellValue(popupMsg);
		
		// Step 3 : Save the changes made in Excel sheet
		wb.write(new FileOutputStream(".//src/test/resources/Testdata.xlsx"));
		
		// Step 4 : Close the Workbook (Optional)
		wb.close();
	}
}
