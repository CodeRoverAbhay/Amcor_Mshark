package com.practice.sillySillyMam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleExcelDataPractice {
	public static HashMap<String, String> readMultipleExcelDataTest() throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream("C:\\Users\\DELL\\Downloads\\ExcelDataProvider.xlsx"));
		Sheet sheet = workbook.getSheet("Sheet1");
		HashMap<String, String> hm = new HashMap<String, String>();
		int rowCount = sheet.getPhysicalNumberOfRows();
		for (int i = 1; i < rowCount; i++) {
			String key = sheet.getRow(i).getCell(0).toString();
			String value = sheet.getRow(i).getCell(1).toString();
			hm.put(key, value);
		}
		return hm;
	}

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		System.out.println(readMultipleExcelDataTest());
	}
}