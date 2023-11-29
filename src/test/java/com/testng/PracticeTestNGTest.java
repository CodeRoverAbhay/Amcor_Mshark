package com.testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTestNGTest {
	@Test
	public void createTest() {
		System.out.println("--CREATE--");
		Reporter.log("CREATE");
	}

	@Test(priority = 0)
	public void editTest() {
		System.out.println("--EDIT--");
		Reporter.log("EDIT");
	}

	@Test(dependsOnMethods = "createTest")
	public void deleteTest() {
		System.out.println("--DELETE--");
		Reporter.log("DELETE");
	}
	@Test(dependsOnMethods = "editTest")
	public void modifyTest() {
		System.out.println("--MODIFY--");
		Reporter.log("MODIFY");
	}
}
