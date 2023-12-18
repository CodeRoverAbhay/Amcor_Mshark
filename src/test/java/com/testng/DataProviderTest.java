package com.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[4][2];

		obj[0][0] = "01-01-2001";
		obj[0][1] = "12-31-2013";

		obj[1][0] = "01-01-2005";
		obj[1][1] = "12-31-2018";

		obj[2][0] = "01-01-2010";
		obj[2][1] = "12-31-2023";

		obj[3][0] = "01-01-1995";
		obj[3][1] = "12-31-2007";

		return obj;
	}

	@Test(dataProvider = "data")
	public void getData(String fromDate, String recentDate) {
		System.out.println("Joining Date is : " + fromDate + " Recent Date is : " + recentDate);
	}

	@Test(dataProviderClass = com.testng.DataProviderExcelTest.class, dataProvider = "excelData")
	public void getDataFromExcel(String key, String value) {
		System.out.println("Key is : " + key + ", Value is : " + value);
	}
}