package com.practice.sillySillyMam;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImpPractice implements IRetryAnalyzer {
	int retryCount = 0;
	int retryLimit = 4;
	
	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < retryLimit) {
			retryCount++;
			return true;
		}
		return false;
	}

}