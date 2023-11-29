package com.hrm.genericutils;

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

public class PracticeImpListner implements ITestListener {
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = reports.createTest(methodName);
		Reporter.log("Execution start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName + " Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		String methodName = result.getName();
		try {
			String path = WebDriverUtils.getScreenShot(BaseClass.ssDriver, methodName + "_" + timeStamp);
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName + " Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./extentReport/report.html");
		htmlReporter.config().setDocumentTitle("HRM");
		htmlReporter.config().setReportName("Mshark Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Abhay");

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("URL", "https://localhost:8080");
		reports.setSystemInfo("Base-Browser", "chrome");

	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
