package com.practice.sillySillyMam;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AirIndiaScroll {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.airindia.com/");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement instagramLink = driver.findElement(By.xpath("//img[@alt='Instagram']"));
		jse.executeScript("arguments[0].click();", instagramLink);
	}
}