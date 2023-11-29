package com.practice.sillySillyMam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

// Search for a round flight ticket in spicejet app.
public class SpiceJetSearchTicket {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']/descendant::*[name()='svg' and @data-testid='svg-img']")).click();
		//driver.findElement(By.xpath("//div[text()='From']/..")).sendKeys("IXC");
		driver.findElement(By.xpath("//input[@value='Select Destination']")).click();
		driver.findElement(By.xpath("//div[text()='AMD']")).click();
		driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']/descendant::div[text()='December ']/../following::div[@data-testid='undefined-calendar-day-22']")).click();
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-January-2024']/../following::div[@data-testid='undefined-calendar-day-12']")).click();
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement doneButton = driver.findElement(By.xpath("//div[text()='Done']/.."));
		jse.executeScript("arguments[0].scrollIntoView(false);", doneButton);
		//jse.executeScript("arguments[0].click();", doneButton);
		doneButton.click();
		driver.findElement(By.xpath("//div[text()='Currency']")).click();
		driver.findElement(By.xpath("//div[text()='USD']")).click();
		driver.findElement(By.xpath("//div[text()='Students']")).click();
		driver.findElement(By.xpath("//div[text()='Search Flight']/..")).click();
		driver.findElement(By.xpath("//div[text()='I have read and agreed to the ']/../../descendant::*[name()='svg' and @data-testid='svg-img']")).click();
		driver.findElement(By.xpath("//div[text()='Continue']/..")).click();
		Thread.sleep(5000);
		driver.manage().window().minimize();
		driver.quit();
	}
}