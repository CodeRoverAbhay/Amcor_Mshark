package com.practice.sillySillyMam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

// Get all the Olympics medals tally of the passed country name.
public class OlympicMedalTallyReport {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		String countryName = "Indi";
		List<WebElement> allCountryName = driver.findElements(By.xpath("//span[text()='"+countryName+"']"));
		boolean flag = false;
		for (WebElement ele : allCountryName) {
			if (ele.getText().equals(countryName)) {
				String goldMedal = driver.findElement(By.xpath("//span[text()='"+countryName+"']/../following-sibling::div[@title='Gold'][1]")).getText();
				String silverMedal = driver.findElement(By.xpath("//span[text()='"+countryName+"']/../following-sibling::div[@title='Silver'][1]")).getText();
				String bronzeMedal = driver.findElement(By.xpath("//span[text()='"+countryName+"']/../following-sibling::div[@title='Bronze'][1]")).getText();
				String totalMedal = driver.findElement(By.xpath("//span[text()='"+countryName+"']/../following-sibling::div[@title=''][1]")).getText();
				System.out.println("Country Name is : " + countryName);
				System.out.println(countryName + " had won a total of " + goldMedal + " GOLD medals.");
				System.out.println(countryName + " had won a total of " + silverMedal + " SILVER medals.");
				System.out.println(countryName + " had won a total of " + bronzeMedal + " BRONZE medals.");
				System.out.println(countryName + " had won a total of " + totalMedal + " medals in the Tokyo 2020 Olympic.");
			}
		}
		if (!flag) {
			System.out.println(countryName + " is not present in ranking list");
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
