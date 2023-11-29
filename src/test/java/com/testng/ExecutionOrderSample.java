package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExecutionOrderSample {

	@Test
	public void demo() {
		System.out.println("Demo");
	}

	@Test
	public void simple() {
		System.out.println("Simple");
	}
	
	
	
	@BeforeClass
	public void BC_1() {
		System.out.println("Before Class - 01");
	}

	@BeforeClass
	public void BC_2() {
		System.out.println("Before Class - 02");
	}

	@AfterClass
	public void AC_1() {
		System.out.println("After Class - 01");
	}

	@AfterClass
	public void AC_2() {
		System.out.println("After Class - 02");
	}

	@BeforeMethod
	public void BM_1() {
		System.out.println("Before Method - 01");
	}

	@BeforeMethod
	public void BM_2() {
		System.out.println("Before Method - 02");
	}

	@BeforeMethod
	public void BM_3() {
		System.out.println("Before Method - 03");
	}

	@AfterMethod
	public void AM_1() {
		System.out.println("After Method - 01");
	}

	@AfterMethod
	public void AM_2() {
		System.out.println("After Method - 02");
	}
}
