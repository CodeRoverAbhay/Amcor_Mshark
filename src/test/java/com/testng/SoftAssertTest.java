package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(com.hrm.genericutils.ListenerImplementationClass.class)
public class SoftAssertTest {

	@Test
	public void softAssertTest_1() {
		SoftAssert sa = new SoftAssert();
		String expected = "B";
		System.out.println("TS_1");
		System.out.println("TS_2");
		System.out.println("TS_3");
		sa.assertEquals("A", expected, "Varification");
		System.out.println("TS_4");
		System.out.println("TS_5");
		// sa.assertAll();
	}

	@Test
	public void softAssertTest_2() {
		String expectedTitle = "Admin Log";
		SoftAssert sa = new SoftAssert();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/HRM_System/index.html");
		String actualTitle = driver.getTitle();
		sa.assertEquals(actualTitle, expectedTitle, "Title is verified");
		System.out.println("PASS And Verified");
		driver.manage().window().minimize();
		driver.quit();
		sa.assertAll();
	}
}
