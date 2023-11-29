package com.practice.sillySillyMam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasket {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//header[@style='opacity: 1;']//span[text()='Shop by']")).click();
		List<WebElement> allCategory = driver.findElements(By.xpath("//div[@class='CategoryMenu___StyledMenuItems-sc-d3svbp-4 cAslOa']//a[@class='CategoryTree___StyledLink-sc-8wbym9-0 gTvqBK']"));
		System.out.println("Category : ");
		for (WebElement category : allCategory) {
			//wait.until(ExpectedConditions.stalenessOf(category));
			wait.until(ExpectedConditions.visibilityOf(category));
			actions.moveToElement(category).build().perform();
			System.out.println(category.getText());
			List<WebElement> allSubCat1 = driver.findElements(By.xpath("//div[@class='CategoryMenu___StyledMenuItems-sc-d3svbp-4 cAslOa']//a[@class='CategoryTree___StyledLink-sc-8wbym9-0 gTvqBK']/../../..//a[@class='CategoryTree___StyledLink2-sc-8wbym9-1 mLodv']"));
			System.out.println("Sub-Category 1 : ");
			for(WebElement subCat1 : allSubCat1) {
				//wait.until(ExpectedConditions.stalenessOf(subCat1));
				wait.until(ExpectedConditions.visibilityOf(subCat1));
				actions.moveToElement(subCat1).build().perform();
				System.out.println(subCat1.getText());
				List<WebElement> allSubCat2 = driver.findElements(By.xpath("//div[@class='CategoryMenu___StyledMenuItems-sc-d3svbp-4 cAslOa']//a[@class='CategoryTree___StyledLink-sc-8wbym9-0 gTvqBK']/../../..//a[@class='CategoryTree___StyledLink3-sc-8wbym9-2 kTPRNM']"));
				System.out.println("Sub-Category 2 : ");
				for (WebElement subCat2 : allSubCat2) {
					//wait.until(ExpectedConditions.stalenessOf(subCat2));
					wait.until(ExpectedConditions.visibilityOf(subCat2));
					System.out.println(subCat2.getText());
				}
			}
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
