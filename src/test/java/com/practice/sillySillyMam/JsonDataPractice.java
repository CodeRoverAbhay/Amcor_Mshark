package com.practice.sillySillyMam;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JsonDataPractice {
	@Test
	public void readJsonDataTest() throws IOException, ParseException {
		FileReader jsonFile = new FileReader("./src/test/resources/jsondata.json");
		JSONParser jParse = new JSONParser();
		Object reader = jParse.parse(jsonFile);
		JSONObject jObj = (JSONObject) reader;
		String url = (String) jObj.get("url");
		System.out.println(url);
	}
}