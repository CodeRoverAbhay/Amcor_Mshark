package com.practice.sillySillyMam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitPractice {
	@Test
	public void fluentWaitTest() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/intl/en_in/earth/");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(org.openqa.selenium.NoSuchElementException.class);
		WebElement launchEarthLink = driver.findElement(By.xpath("//a[normalize-space(text())='Google Earth on mobile']"));
		wait.until(ExpectedConditions.visibilityOf(launchEarthLink)).click();
		driver.quit();
	}
}