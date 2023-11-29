package com.practice.sillySillyMam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class SingleCalenderPopupTest {
	public static void main(String[] args) throws InterruptedException {
		// Instantiate the browser specific class
		EdgeDriver driver = new EdgeDriver();
		// Add implicit wait to find the element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Maximie the browser screen
		driver.manage().window().maximize();
		// Trigger the URL
		driver.get("https://www.ksrtc.in");
		// Identify the Journey Date textfield and perform click action
		driver.findElement(By.id("txtJourneyDate")).click();
		// Select the date from Calender and pick date from it
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[text()='10']")).click();
		// Adding thread.sleep just to witness the execution
		Thread.sleep(5000);
		// Minimize the browser screen
		driver.manage().window().maximize();
		// Quit the session
		driver.quit();
	}
}