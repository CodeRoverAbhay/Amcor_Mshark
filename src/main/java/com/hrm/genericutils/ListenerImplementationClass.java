package com.hrm.genericutils;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		// Configures the ExtentReports instance
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./Extent-report/report.html");
		htmlReport.config().setDocumentTitle("HRM");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Mshark Test Result");
		htmlReport.config().setReportName("Code Rover Abhay");
		// Initializes the ExtentReports instance
		report = new ExtentReports();
		// Attach thr report else it will not at all add any thing to the report
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("url", "http://rmgtestingserver/domain/HRM_System/");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log("[ Test script execution starts from here. ]");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName + " PASSED");
		Reporter.log(methodName + " [ Test script executed successfully. ]");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		String methodName = result.getMethod().getMethodName();
		String failedTestName = methodName + "_" + timeStamp;
		try {
			String screenshotPath = WebDriverUtils.getScreenShot(BaseClass.ssDriver, failedTestName);
			test.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, methodName + " FAILED");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(methodName + " [ Test script execution got failed. ]");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName + " SKIPPED");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName + " [ Test script execution got skipped. ]");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onFinish(ITestContext context) {
		// Flushes the ExtentReports instance, finalizing the report
		report.flush();
	}
}