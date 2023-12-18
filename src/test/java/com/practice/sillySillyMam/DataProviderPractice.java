package com.practice.sillySillyMam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@DataProvider(name = "ExcelData")
	public String[][] provideExcelData() throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream("C:\\Users\\DELL\\Downloads\\ExcelDataProvider.xlsx"));
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data = new String[rowCount - 1][cellCount];
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}

	@Test(dataProvider = "ExcelData")
	public void getExcelDataFromProvider(String empName, String loginTime, String logoutTime, String totalLoginHour) throws InterruptedException {
		String data = empName + " : " + loginTime + " : " + logoutTime + " : " + totalLoginHour;
		System.out.println(data);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bing.com");
		driver.switchTo().activeElement().sendKeys(data);
		Thread.sleep(3000);
		driver.manage().window().minimize();
		driver.quit();
	}
}