package com.practice.sillySillyMam;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksPractice {
	@Test
	public void brokenLinkTest() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new ChromeDriver();
		ArrayList<String> allBrokenLinks = new ArrayList<>();
		String mainUrl = "https://mvnrepository.com/";
		driver.get(mainUrl);
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (WebElement link : allLinks) {
			String href = link.getAttribute("href");
			if (href.isEmpty() || href == null) {
				System.out.println("Link is not configured.");
			}
			if (!href.startsWith(mainUrl)) {
				System.out.println(href + " : Link belongs to another domain.");
			}
			try {
				HttpURLConnection httpUrlConnection = (HttpURLConnection) (new URL(href).openConnection());
				httpUrlConnection.setConnectTimeout(5000);
				int responseCode = httpUrlConnection.getResponseCode();
				if (responseCode >= 400) {
					System.out.println(href + " : " + responseCode + " : " + httpUrlConnection.getResponseMessage());
					allBrokenLinks.add(href);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(href + " : " + e.getMessage());
				allBrokenLinks.add(href);
			}
		}
		driver.quit();
	}
}