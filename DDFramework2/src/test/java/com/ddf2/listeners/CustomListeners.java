package com.ddf2.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.ddf2.base.TestBase;
import com.ddf2.utilities.testUtil;

public class CustomListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getName().toString().trim();
		String screenshotPath="";
		String fs = TestBase.fs;
		try {
			screenshotPath ="file:///"+testUtil.captureScreenshot(methodName,("s:"+fs+"screenshot"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Capture screenshot for failed test: " + result.getName());
		Reporter.log("***TEST MESSAGE***");
		Reporter.log("<a href='"+screenshotPath+"' target='_blank'>Screenshot link");
		Reporter.log(
				"<a href='"+screenshotPath+"' target='_blank'><img height=100 src='"+screenshotPath+"'>");
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
