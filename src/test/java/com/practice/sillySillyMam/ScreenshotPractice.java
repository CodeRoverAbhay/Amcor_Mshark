package com.practice.sillySillyMam;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotPractice {
	public String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File tempLoc = ts.getScreenshotAs(OutputType.FILE);
		File destLoc = new File("./screenshot.errorshot/" + screenshotName + ".png");
		FileUtils.copyFile(tempLoc, destLoc);
		String screenshotPath = destLoc.getAbsolutePath();
		return screenshotPath;
	}
}