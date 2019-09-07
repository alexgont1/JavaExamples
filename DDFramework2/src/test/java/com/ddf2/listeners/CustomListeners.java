package com.ddf2.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Capture screenshot for failed test: " + result.getName());
		Reporter.log("***TEST MESSAGE***");
		Reporter.log("<a href='file:///S:/screenshot/A1.jpg' target='_blank'>Screenshot link");
		Reporter.log(
				"<a href='file:///S:/screenshot/A1.jpg' target='_blank'><img height=100 src='file:///S:/screenshot/A1.jpg'>");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
