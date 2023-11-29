package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAssertTest {
	@Test
	public void hardAssertTest_1() {
		char expected = 'B';
		System.out.println("TS_1");
		System.out.println("TS_2");
		System.out.println("TS_3");
		Assert.assertEquals('A', expected, "Not matched");
		System.out.println("TS_4");
		System.out.println("TS_5");
	}

	@Test
	public void hardAssertTest_2() {
		int a = 70;
		System.out.println("TS_6");
		System.out.println("TS_7");
		System.out.println("TS_8");
		Assert.assertNull(a);
		System.out.println("TS_9");
		System.out.println("TS_10");
	}
}