package com.hrm.genericutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Code_Rover_Abhay
 */
public class PropertyFileUtils {
	/**
	 * This method is used to retrieve data from Properties file
	 * 
	 * @param key
	 * @return value of specifified key
	 * @throws IOException
	 */
	public String readDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.propertiesFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String propertyData = pobj.getProperty(key);
		return propertyData;
	}
}