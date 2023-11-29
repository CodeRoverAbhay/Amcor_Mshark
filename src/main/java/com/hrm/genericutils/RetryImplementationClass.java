package com.hrm.genericutils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer {
	int count = 0;
	int retryLimit = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (count < retryLimit) {
			count++;
			return true;
		}
		return false;
	}
}