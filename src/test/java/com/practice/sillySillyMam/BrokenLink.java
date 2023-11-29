package com.practice.sillySillyMam;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BrokenLink {

	public static void main(String[] args) {
		// Creates an instance of browser specific class
		WebDriver driver = new EdgeDriver();
		// Maximize the browser window
		driver.manage().window().maximize();
		// Setting an implicit wait of 10 seconds to find the elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Create an ArrayList to group and store all the broken links.
		ArrayList<String> allBrokenLinks = new ArrayList<String>();
		// Trigger and navigate to the main URL
		// driver.get("https://mvnrepository.com/");
		driver.get("https://www.ksrtc.in/");
		// Locates all the anchor elements (<a>) on the web page using the findElements method
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		// Count and Print the total number of WebElement developed using anchor tag
		System.out.println("Total number of Links is : " + allLinks.size());
		// Iterate all the Links one by one using for loop
		for (int i = 0; i < allLinks.size(); i++) {
			// Extract the href attribute value of the link which is under iteration
			String href = allLinks.get(i).getAttribute("href");
			try {
				// Create an HttpURLConnection object & use it to send a HEAD request to the URL (href) obtained in previous step
				HttpURLConnection httpURLconnection = (HttpURLConnection) new URL(href).openConnection();
				// Refresh the page
				driver.navigate().refresh();
				// Check the response code of the HTTP request
				int responseCode = httpURLconnection.getResponseCode();
				// If the response code is greater than or equal to 400, it means the link is broken
				if (responseCode >= 400) {
					// Store the broken link in the allBrokenLinks list
					allBrokenLinks.add(href);
					// Print the message indicating that the link is broken, along with the HTTP response code
					System.out.println( (i+1) + ". Broken link : " + href + " ( HTTP response code " + responseCode + " )");
					// Handle the broken link as needed in catch block
				}
			} catch (Exception e) {
				// Catch the exception and store the link in the allBrokenLinks list
				allBrokenLinks.add(href);
				// Print the broken link along with the error message
				System.out.println( (i+1) + ". Exception for link : " + href + " - " + e.getMessage());
			}
		}
		// Maximize the browser window
		driver.manage().window().minimize();
		// Terminate the session
		driver.quit();
		// Print the size of allBrokenLinks ArrayList
		System.out.println(allBrokenLinks.size());
		// Print the elements of allBrokenLinks one by one using enhanced for loop
		for (String link : allBrokenLinks) {
			System.out.println(link);
		}
	}
}