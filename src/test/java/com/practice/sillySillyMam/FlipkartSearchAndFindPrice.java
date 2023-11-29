package com.practice.sillySillyMam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

// Search a product in flipkart app and find the price of that product.
public class FlipkartSearchAndFindPrice {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//span[text()='✕']")).click();
		String productToSearch = "Mac book air";
		// String productToSearch = "Borosil Prime grill sandwich maker";
		String productName = productToSearch.toUpperCase();
		driver.findElement(By.name("q")).sendKeys(productName, Keys.ENTER);
		String productPrice = driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]/../descendant::div[@class='_30jeq3']")).getText();
		System.out.println("Product Name is : " + productName + ", Product Price is : " + productPrice);
		driver.manage().window().minimize();
		driver.quit();
	}
}
