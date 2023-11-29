package com.practice.sillySillyMam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripCalenderPopup {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(10000);
		actions.doubleClick().perform();
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		for (;;) {
			try {
				driver.findElement(By.xpath("//div[text()='February 2024']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='14']")).click();
				break;
			} catch (NoSuchElementException e) {
				// TODO: handle exception
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		Thread.sleep(3000);
		driver.manage().window().minimize();
		driver.quit();
	}
}
