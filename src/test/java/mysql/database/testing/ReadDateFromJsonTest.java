package mysql.database.testing;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDateFromJsonTest {
	public static void main(String[] args) throws IOException, ParseException {
		// Create a FileReader object by providing the file path of the JSON file
		FileReader filePath = new FileReader("./src/test/resources/jsondata.json");
		// JASONParse is used to read / write the JSON formatted file
		// Create a JSONParser object
		JSONParser jsonP = new JSONParser();
		// Parse the contents of the file using the JSONParser
		Object obj = jsonP.parse(filePath);
		// Cast the parsed data to a JSONObject
		// Read data from JSON File
		JSONObject map = (JSONObject) obj;
		// Print values from the JSON object
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("emailId"));
		System.out.println(map.get("password"));
	}
}
