package com.practice.sillySillyMam;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MicrosoftLearnMore {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.microsoft.com/en-in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for (;;) {
			try {
				WebElement learnMore = driver.findElement(By.xpath("//a[contains(text(),'Learn more')]"));
				learnMore.click();
				System.out.println(driver.getTitle());
				break;
			} catch (NoSuchElementException e) {
				// driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}