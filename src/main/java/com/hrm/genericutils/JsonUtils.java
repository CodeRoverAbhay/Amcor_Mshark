package com.hrm.genericutils;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Code_Rover_Abhay
 */
public class JsonUtils {
	/**
	 * This method is used to retrieve data from Properties file
	 * 
	 * @param key
	 * @return String value of specified key
	 * @throws ParseException
	 * @throws IOException
	 */
	public String readDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader jsonFilePath = new FileReader(IPathConstants.jsonFilePath);
		JSONParser jsonParse = new JSONParser();
		Object reader = jsonParse.parse(jsonFilePath);
		JSONObject jObj = (JSONObject) reader;
		String mapKeyvalue = (String) jObj.get(key);
		return mapKeyvalue;
	}
}