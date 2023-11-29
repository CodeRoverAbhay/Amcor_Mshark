package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetryAnalizerTest {
	// @Test(retryAnalyzer = com.hrm.genericutils.RetryImplementationClass.class)
	@Test
	public void practiceRetry() {
		System.out.println("Retry");
		Assert.fail();
	}
}