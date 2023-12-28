package com.practice.sillySillyMam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SvgPractice {
	@Test
	public void covidGraphTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/coronavirus/country/india/#google_vignette");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Got it!")).click();
	}
	
	@Test
	public void worldOMetersDynamicData () {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String totalBirthCount = driver.findElement(By.xpath("//span[@rel='births_this_year']")).getText();
		System.out.println("Total birth count in string : " + totalBirthCount);
		String countWithoutComma = totalBirthCount.replace(",", "");
		int totalBirthCountInInt = Integer.parseInt(countWithoutComma);
		System.out.println("Total birth count in integer : " + totalBirthCountInInt);
		driver.manage().window().minimize();
		driver.quit();
	}
}