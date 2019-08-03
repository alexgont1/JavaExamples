package customListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Capture screenshot for failed test: "+result.getName());
		Reporter.log("***TEST MESSAGE***");
		Reporter.log("<a href='file:///S:/screenshot/A1.jpg' target='_blank'>Screenshot link");
		Reporter.log("<a href='file:///S:/screenshot/A1.jpg' target='_blank'><img height=100 src='file:///S:/screenshot/A1.jpg'>");
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

}
