package com.practice.sillySillyMam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

// Fetch the live score of ongoing match.
public class CricbuzzLiveScore {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cricbuzz.com/cricket-match/live-scores");
		List<WebElement> names=driver.findElements(By.xpath("//h1[text()='Live Cricket Score']/ancestor::div[contains(@ng-init,'domestic')]//a[@class='text-hvr-underline text-bold']"));
		List<WebElement> scoreInfo=driver.findElements(By.xpath("//h1[text()='Live Cricket Score']/ancestor::div[contains(@ng-init,'domestic')]//div[@class='cb-scr-wll-chvrn cb-lv-scrs-col ']"));
		for(int i=0;i<names.size();i++) {
			System.out.println(names.get(i).getText());
			System.out.println(scoreInfo.get(i).getText());
			System.out.println();
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}