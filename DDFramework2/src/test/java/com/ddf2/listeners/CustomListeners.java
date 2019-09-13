package com.ddf2.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.ddf2.base.TestBase;
import com.ddf2.utilities.testUtil;

public class CustomListeners extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// runModes (using Excel file sheet - TestSuite), Y=run
		try {
			if (!testUtil.isTestRun(result.getName())) {
				throw new SkipException("Skipping test " + result.getName().toUpperCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
	}

	@Override
	public void onTestFailure(ITestResult arg0) {

		String methodName = arg0.getName().toString().trim();
		String screenshotPath = "";
		try {
			screenshotPath = testUtil.captureScreenshot(methodName, ("s:" + fs + "screenshot"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String screenshotPathHTML = "file:///" + screenshotPath;
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Capture screenshot for failed test: " + arg0.getName());
		Reporter.log("***TEST MESSAGE***");
		Reporter.log("<a href='" + screenshotPathHTML + "' target='_blank'>Screenshot link");
		Reporter.log("<a href='" + screenshotPathHTML + "' target='_blank'><img height=100 src='" + screenshotPathHTML
				+ "'>");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.skip(result.getName()+" skipped because RunMode is NO");
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
