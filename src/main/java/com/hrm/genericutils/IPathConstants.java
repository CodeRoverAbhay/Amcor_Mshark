package com.hrm.genericutils;

/**
 * @author Code_Rover_Abhay
 */
public interface IPathConstants {
	/**
	 * This interface is to keep all the static and final path
	 */
	String databaseUrl = "Jdbc:mysql://localhost:3306/amcor";
	String databaseUsername = "root";
	String databasePassword = "root";
	String excelFilePath = "./src/test/resources/Testdata.xlsx";
	String propertiesFilePath = "./src/test/resources/CommonData.properties";
	String jsonFilePath = "./src/test/resources/jsondata.json";
	int implicitWaitSecond = 5;
	int explicitWaitSecond = 5;
}