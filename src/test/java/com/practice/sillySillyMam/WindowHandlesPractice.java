package com.practice.sillySillyMam;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandlesPractice {
	public void switchToWindowTest(WebDriver driver, String partialTitle) {
		Set<String> allWindowId = driver.getWindowHandles();
		Iterator<String> itr = allWindowId.iterator();
		while (itr.hasNext()) {
			String wid = itr.next();
			String currentTitle = driver.switchTo().window(wid).getTitle();
			if (currentTitle.contains(partialTitle)) {
				break;
			}
		}
	}
}