package com.practice.sillySillyMam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TableData {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		String countryName = "India";
		List<WebElement> ele = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]/span[2]"));
		boolean flag = false;
		for (WebElement webEle : ele) {
			String countryNames = webEle.getText();
			if (countryNames.equals(countryName)) {
				System.out.println(countryName + " is present");
				WebElement matchPlayed = driver.findElement(By.xpath("//span[.='" + countryName + "']/../..//td[3]"));
				System.out.println("Total match played is " + matchPlayed.getText());
				WebElement currentPoint = driver.findElement(By.xpath("//span[.='" + countryName + "']/../..//td[4]"));
				System.out.println("Current point of the team is " + currentPoint.getText());
				WebElement currentRating = driver.findElement(By.xpath("//span[.='" + countryName + "']/../..//td[5]"));
				System.out.println("Current rating of the team is " + currentRating.getText());
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println(countryName + " is not present");
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}