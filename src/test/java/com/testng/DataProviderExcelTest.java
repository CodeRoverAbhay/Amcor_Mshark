package com.testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.hrm.genericutils.IPathConstants;

public class DataProviderExcelTest {
	@DataProvider
	public Object[][] excelData() throws EncryptedDocumentException, IOException {
		InputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("TC_DATA_PROVIDER");
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