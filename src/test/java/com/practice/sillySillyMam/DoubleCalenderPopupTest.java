package com.practice.sillySillyMam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoubleCalenderPopupTest {
	public static void main(String[] args) throws InterruptedException {
		// Instantiate the browser specific class
		EdgeDriver driver = new EdgeDriver();
		// Add Pageload timeout wait to find the element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		// Add Explicit wait to let the driver wait till the expected condition gets true
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Maximie the browser screen
		driver.manage().window().maximize();
		// Trigger the URL
		driver.get("https://www.goibibo.in");
		// Wait for Hidden popup to get visible and close the popup by performing click action once it get visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='logSprite icClose']"))).click();
		// Identify the Departure Date Text field and click on it
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		// Identift the next month arrow from calender and perform click action until the month gets visible
		WebElement nextArrowButton = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
				for (;;) {
			try {
				// Identify the departure date and click on it
				driver.findElement(By.xpath("//div[@class='DayPicker-Months']/descendant::div[text()='April 2024']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='22']")).click();
				break;
			} catch (NoSuchElementException e) {
				// TODO: handle exception
				nextArrowButton.click();
			}
		}
		// Upon date selection clock on date button
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		// Adding Thread.sleep just to encounter the execution process
		Thread.sleep(5000);
		// Minimize the browser screen
		driver.manage().window().minimize();
		// Quit the session
		driver.quit();
	}
}