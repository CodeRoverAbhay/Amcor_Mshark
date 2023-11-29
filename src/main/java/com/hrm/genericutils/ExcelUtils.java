package com.hrm.genericutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

/**
 * @author Code_Rover_Abhay
 */
public class ExcelUtils {
	/**
	 * This method is used to read the data of specified cell from the Excel file
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return cell value of specified cell
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readExcelData(String sheetName, int rowNum, int cellNum)throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String excelData = cell.getStringCellValue();
		return excelData;
	}

	/**
	 * This method is used to get the total row count present in the specified Excel sheet
	 * 
	 * @param sheetName
	 * @return the total count of Row present in specific Excel sheet
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNum(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int totalRowCount = sheet.getLastRowNum();
		return totalRowCount;
	}

	/**
	 * This method is used to Write the data intothe specified Excel's sheet cell
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param valueToSet
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setExcelCellData(String sheetName, int rowNumber, int cellNumber, String valueToSet)throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		sheet.createRow(rowNumber).createCell(cellNumber).setCellValue(valueToSet);
		FileOutputStream fos = new FileOutputStream(IPathConstants.excelFilePath);
		workbook.write(fos);
		workbook.close();
	}

	/**
	 * This method is to read multiple data from Excel sheet using HashMap concept (key-value pair)
	 * 
	 * @param sheetName
	 * @param driver
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @return Map (key, value)
	 */
	public Map<String, String> readMultipleDataFromExcel(String sheetName, WebDriver driver, int rowCount, int keyCellIndex ) throws EncryptedDocumentException, IOException {
		@SuppressWarnings("unused")
		JavaUtils javaLib = new JavaUtils();
		FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for (int i = 2; i <= rowCount; i++) {
			String key = sheet.getRow(i).getCell(keyCellIndex).getStringCellValue();
			String value = sheet.getRow(i).getCell(keyCellIndex+1).getStringCellValue();
			hashMap.put(key, value);
		}
		return hashMap;
//		for (Entry<String, String> set : hashMap.entrySet()) {
//			// To generate unique input by concatenating it with random number
//			/* if (set.getKey().contains("abc")) {
//				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue() + javaLib.getRandomNumber());
//			} else {
//				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
//			} */
//			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
//		}
	}
	
	/**
	 * This method will read multiple data from specified sheet of excel
	 * 
	 * @param sheetName
	 * @return 2 dimensional object[][]
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] getMultipleSetOfExcelData (String sheetName) throws EncryptedDocumentException, IOException {
		InputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getPhysicalNumberOfRows();
		int lastCell = sheet.getRow(0).getLastCellNum();
		Object [][] data = new Object[lastRow] [lastCell];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}