package com.hrm.genericutils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author Code_Rover_Abhay
 */
public class WebDriverUtils {
	/**
	 * This method is used to Maximize the browser screen
	 * 
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to Minimize the browser screen
	 * 
	 * @param driver
	 */
	public void minimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used to wait for the element till it get loaded in the Webpage for specified time
	 * 
	 * @param driver
	 */
	public void waitForAllElementsToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstants.implicitWaitSecond));
	}

	/**
	 * This method is used to wait for the element till it get visible in the Webpage for specified time
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitUntilElementGetsVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitSecond));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is to verify the URL by passing the fraction of URL
	 * 
	 * @param driver
	 * @param fractionURL
	 * 
	 * @return boolean true if url matches
	 */
	public boolean urlVerification (WebDriver driver, String fractionURL) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitSecond));
		wait.until(ExpectedConditions.urlContains(fractionURL));
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, fractionURL, "URL is not matching.");
		return true;
	}
	
	/**
	 * This method is to verify the current Title of the WebPage using Assertion
	 * 
	 * @param driver
	 * @param expectedPageTitle
	 */
	public void verifyTitle (WebDriver driver, String expectedPageTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitSecond));
		wait.until(ExpectedConditions.titleIs(expectedPageTitle));
		String currentPageTitle = driver.getTitle();
		Assert.assertEquals(currentPageTitle, expectedPageTitle, "Webpage title is not matching.");
	}
	
	/**
	 * This method is used to wait for the element till it get clickable in the Webpage for specified time
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitUntilElementGetsClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitSecond));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to select the option from Dropdown using Index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropdownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method is used to select the option from Dropdown using Value
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropdownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method is used to select the option from Dropdown using Visible Text
	 * 
	 * @param element
	 * @param visibleText
	 */
	public void selectDropdownByText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	/**
	 * This method is used to mouse hover to the targeted element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * This method is used to Drag the element from source and Drop it to the location
	 * 
	 * @param driver
	 * @param element
	 * @param visibleText
	 */
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	/**
	 * This method is used to perform double click on current position of the mouse pointer
	 * 
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick().perform();
	}

	/**
	 * This method is used to perform double click on center of the targeted WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	/**
	 * This method is used to perform Right click on current position of the mouse pointer
	 * 
	 * @param driver
	 */
	public void rightClickOnWebpage(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick().perform();
	}

	/**
	 * This method is used to perform Right click on the centre of the targeted WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickOnWebElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	/**
	 * This method is used to perform Keyboard Enter operation at current position of mouse pointer
	 * 
	 * @param driver
	 */
	public void keyPressActionsEnter(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method is used to perform Keyboard Enter action at the centre of specified WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void keyPressOnElementActionsEnter(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element, Keys.ENTER).perform();
	}

	/**
	 * This method is used to switch to another frame using Index of the Frame
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrameUsingIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch to another frame using Name Or Id of the Frame
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrameUsingNameOrId(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method is used to switch to another frame using Frame Element
	 * 
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrameUsingWebElement(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * This method is used to switch to another window / tab using WindowID
	 * 
	 * @param driver
	 * @param windowId
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		// STEP 1: Use getWindowHandles to capture all the Window ID
		Set<String> windows = driver.getWindowHandles();
		// STEP 2: Iterate through the windows
		Iterator<String> itr = windows.iterator();
		// STEP 3: Check whether there is next window or not
		while (itr.hasNext()) {
			// STEP4: Capture the current Window ID
			String windowId = itr.next();
			// STEP5: Switch to current window and capture the title
			String currentWindowTitle = driver.switchTo().window(windowId).getTitle();
			// STEP 6: Check whether the current window title is matching with expected window title
			if (currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * This method is used to switch to alert and accept the alert popup
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitSecond));
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	/**
	 * This method is used to get the alert popup message
	 * 
	 * @param driver
	 * @return alert message
	 */
	public String getAlertMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitSecond));
		String popupMsg = wait.until(ExpectedConditions.alertIsPresent()).getText();
		return popupMsg;
	}

	/**
	 * This method is used to switch to alert and dismiss the alert popup
	 * 
	 * @param driver
	 */
	public void abortAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitSecond));
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}
	/**
	 * This method is used to switch to alert, print the alert message and accept the alert popup
	 * 
	 * @param driver
	 */
	public void printAlertMessageAndAcceptAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitSecond));
		String alertMessage = wait.until(ExpectedConditions.alertIsPresent()).getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to verify the alert message, if message matches it will accept the alert else not
	 * 
	 * @param driver
	 * @param expectedAlertMessage
	 */
	public void acceptAlertWithAssert(WebDriver driver, String expectedAlertMessage) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitSecond));
		String actualAlertMessage = wait.until(ExpectedConditions.alertIsPresent()).getText();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to scroll the window bar by specific scroll amount
	 * 
	 * @param driver
	 * @param scrollAmountX
	 * @param scrollAmountY
	 */
	public void scrollBarAction(WebDriver driver, int scrollAmountX, int scrollAmountY) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(" + scrollAmountX + "," + scrollAmountY + ");");
	}

	/**
	 * This method is used to scroll the window bar to the targeted web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method is used to take the screenshot and store it in the folder called as screenshot
	 * 
	 * @param driver
	 * @param Screenshot Name
	 * @return Absolute path of the location where the screenshod is saved
	 * @throws IOException
	 */
	public static String getScreenShot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceLocation = ts.getScreenshotAs(OutputType.FILE);
		//screenShotName = LocalDateTime.now().toString().replace(':', '-');
		String path = "./screenshot/errorshot/" + screenShotName + ".png";
		File destinationLocation = new File(path);
		FileUtils.copyFile(sourceLocation, destinationLocation);
		return destinationLocation.getAbsolutePath();
	}
	
	/**
	 * This method is used to take in general screenshot and store it in the folder called as screenshot
	 * 
	 * @param driver
	 * @return Absolute path of the location where the screenshod is saved
	 * @throws IOException
	 */
	public static String getScreenShotInGeneral (WebDriver driver ) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceLocation = ts.getScreenshotAs(OutputType.FILE);
		String screenShotName = LocalDateTime.now().toString().replace(':', '-');
		String path = "./screenshot/errorshot/" + screenShotName + ".png";
		File destinationLocation = new File(path);
		FileUtils.copyFile(sourceLocation, destinationLocation);
		return destinationLocation.getAbsolutePath();
	}
}