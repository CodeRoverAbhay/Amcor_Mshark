package com.practice.sillySillyMam;

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
import com.hrm.genericutils.BaseClass;
import com.hrm.genericutils.WebDriverUtils;

public class ListenerImpPractice implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		test = report.createTest(testMethodName);
		Reporter.log("[Test Script execution starts.]");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, testMethodName + " PASSED");
		Reporter.log("[ Test executed successfully. ]");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		try {
			String screenshotPath = WebDriverUtils.getScreenShot(BaseClass.ssDriver, testMethodName + "_" + timeStamp);
			test.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, testMethodName + " test execution got FAILED");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("[ Test execution got failed ]");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, testMethodName + " SKIPPED");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("[ Test execution got skipped ]");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("/.Extent-report/report.html");
		htmlReport.config().setDocumentTitle("Script-Report");
		htmlReport.config().setReportName("HRM Test Report");
		htmlReport.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URL", "https://localhost:8080/");
		report.setSystemInfo("Reporter Name", "Abhay Gope");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}