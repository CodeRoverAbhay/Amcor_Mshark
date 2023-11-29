package com.practice.sillySillyMam;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mvnrepository.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ArrayList<String> allBrokenLinks = new ArrayList<String>();
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (WebElement link : allLinks) {
			String href = link.getAttribute("href");
			if (href.isEmpty() || href == null) {
				System.out.println("URL is not configured.");
			}
			try {
				HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(href).openConnection());
				httpURLConnection.setConnectTimeout(5000);
				int responseCode = httpURLConnection.getResponseCode();
				if (responseCode >= 400) {
					allBrokenLinks.add(href);
					System.err.println(href + responseCode + httpURLConnection.getResponseMessage());
				}
			} catch (Exception e) {
				allBrokenLinks.add(href);
				System.err.println(e.getMessage());
			}
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}