package com.ddf2.listeners;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.ddf2.base.TestBase;
import com.ddf2.utilities.testUtil;

public class CustomListeners extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		//test=exRep.createTest(result.getName().toUpperCase());
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		//test.log(Status.PASS, arg0.getName().toUpperCase()+" PASS");
		//exRep.removeTest(test);
		//exRep.flush();
		//test = exRep.createTest("TEST!!!");
		Assert.assertEquals(1,1);
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		
		String methodName = arg0.getName().toString().trim();
		String screenshotPath="";		
		try {
			screenshotPath =testUtil.captureScreenshot(methodName,("s:"+fs+"screenshot"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		String screenshotPathHTML = "file:///"+screenshotPath;
		
		/*test.log(Status.FAIL, arg0.getName().toUpperCase()+" FAIL: "+arg0.getThrowable());
		try {
			test.log(Status.FAIL, "FAIL!!!" );
			test.addScreenCaptureFromPath(screenshotPathHTML);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//exRep.removeTest(test);
		//exRep.flush();*/		
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Capture screenshot for failed test: " + arg0.getName());
		Reporter.log("***TEST MESSAGE***");
		Reporter.log("<a href='"+screenshotPathHTML+"' target='_blank'>Screenshot link");
		Reporter.log(
				"<a href='"+screenshotPathHTML+"' target='_blank'><img height=100 src='"+screenshotPathHTML+"'>");
		
		//ExtentReport code:
		//test = exRep.createTest("TEST!!!");
		//Assert..assertEquals(driver.getTitle(),"Google");
		
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
