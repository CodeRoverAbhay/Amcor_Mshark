package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExecutionOrder {
	@Test
	public void testScript_1() {
		System.out.println("Execute TC_01");
	}
	
	@Test
	public void testScript_2() {
		System.out.println("Execute TC_02");
	}

	@BeforeSuite
	public void config_BS() {
		System.out.println("Database connection");
	}

	@AfterSuite
	public void config_AS() {
		System.out.println("Disconnect from Database");
	}

	@BeforeClass
	public void config_BC() {
		System.out.println("Launch the Browser");
	}

	@AfterClass
	public void config_AC() {
		System.out.println("Close the Browser");
	}

	@BeforeMethod
	public void config_BM() {
		System.out.println("Login to Application");
	}

	@AfterMethod
	public void config_AM() {
		System.out.println("Logout from Application");
	}
}
