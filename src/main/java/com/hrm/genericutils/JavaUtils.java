package com.hrm.genericutils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Code_Rover_Abhay
 */
public class JavaUtils {
	/**
	 * This method is for generating random rumber
	 * 
	 * @return random mumber
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(99);
		return randomNumber;
	}

	/**
	 * This method is to get the real time system date
	 * 
	 * @return system date
	 */
	public String getSystemDate() {
		Date date = new Date();
		String systemDate = date.toString();
		return systemDate;
	}

	/**
	 * This method is to get the System date and time in specified format
	 * 
	 * @return system date and time
	 */
	public String getSystemDateFormat() {
		// Refer to code Line no 2225 - 2235 for detail description of format (class SimpleDateFormat)
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH-mm-SS");
		Date date = new Date();
		String systemDateAndTimeInFormat = dateFormat.format(date);
		return systemDateAndTimeInFormat;
	}

	/**
	 * This method is to Simulate a key press using the Robot class.
	 * 
	 * @param keyCode the keycode of the key to be pressed
	 * @param delayMicroSecond to sleeps the execution for the specified time after key press
	 */
	public static void simulateRobotKeyPress(int keyCode, int delayMilliSecond) {
		try {
			Robot robot = new Robot();
			// Simulate key press
			robot.keyPress(keyCode);
			robot.delay(delayMilliSecond);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is to Simulate a key press using the Robot class.
	 * 
	 * @param keyCode the keycode of the key to be released
	 * @param delayMicroSecond to sleeps the execution for the specified time after key release
	 */
	public static void simulateRobotKeyRelease(int keyCode, int delayMilliSecond) {
		try {
			Robot robot = new Robot();
			// Simulate key release
			robot.keyRelease(keyCode);
			robot.delay(delayMilliSecond);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to press Keyboard Enter key using Robot class
	 * 
	 * @param delayMicroSecond to sleeps the execution for the specified time after pressing Enter key
	 * @throws AWTException
	 */
	public void simulateRobotkeyEnterKeyPress(int delayMilliSecond) throws AWTException {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(delayMilliSecond);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to release Keyboard pressed Enter key using Robot class
	 * 
	 * @param delayMicroSecond to sleeps the execution for the specified time after releasing Enter key
	 * @throws AWTException
	 */
	public void simulateRobotkeyEnterKeyRelease(int delayMilliSecond) throws AWTException {
		try {
			Robot robot = new Robot();
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(delayMilliSecond);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to pass the path in Window system using Robot class
	 * 
	 * @param path
	 * @throws AWTException
	 */
	public void enterPathUsingRobot(String filePath) throws AWTException {
		try {
			Robot robot = new Robot();
			for (char c : filePath.toCharArray()) {
				if (c == ':') {
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_SEMICOLON);
					robot.keyRelease(KeyEvent.VK_SHIFT);
				} else {
					int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
					if (Character.isUpperCase(c)) {
						robot.keyPress(KeyEvent.VK_SHIFT);
					}
					robot.keyPress(keyCode);
					robot.keyRelease(keyCode);
					if (Character.isUpperCase(c)) {
						robot.keyRelease(KeyEvent.VK_SHIFT);
					}
				}
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}