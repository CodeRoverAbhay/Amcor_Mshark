package com.practice.sillySillyMam;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrokenImagesPractice {
	@Test
	public void brokenImageTest() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		WebDriver driver = new ChromeDriver(co);
		String mainUrl = "https://www.irctc.com/";
		driver.get(mainUrl);
		ArrayList<String> allBrokenImages = new ArrayList<String>();
		List<WebElement> allImageLinks = driver.findElements(By.tagName("img"));
		System.out.println("Total Images present in Web site is : " + allImageLinks.size());
		for (WebElement imageLink : allImageLinks) {
			String srcLink = imageLink.getAttribute("src");
			if (srcLink.isEmpty() || srcLink == null) {
				System.out.println("Link is not configured");
			}
			if (!srcLink.startsWith(mainUrl)) {
				System.out.println(srcLink + " : Link belongs to another domain");
			}
			try {
				HttpURLConnection httpUrlConnection = (HttpURLConnection) (new URL(srcLink).openConnection());
				httpUrlConnection.setConnectTimeout(5000);
				int responseCode = httpUrlConnection.getResponseCode();
				if (responseCode >= 400) {
					System.out.println(srcLink + " : " + responseCode + " : " + httpUrlConnection.getResponseMessage());
					allBrokenImages.add(srcLink);
				}
			} catch (Exception e) {
				System.out.println(srcLink + e.getMessage());
				allBrokenImages.add(srcLink);
			}
		}
		System.out.println("Broken Images");
		for (String brokenIng : allBrokenImages) {
			System.out.println(brokenIng);
		}
		driver.quit();
	}
}