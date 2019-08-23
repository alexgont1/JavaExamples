package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.BaseTest;

public class TestListener extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {

		String methodName = result.getName().toString().trim();
		Date d = new Date();
		String formDate = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(d);
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = userDir+"//test-output//html//screenshots//" + formDate + "_" + methodName + ".jpg";
		Reporter.log("<a href='file:///" + fileName + "' target='_blank'><img height=100 src='file:///"+fileName+"'><br>");
		Reporter.log("<a href='file:///" + fileName + "' target='_blank'>Screenshot link");

		try {
			// save screenshot with method name which is source of ERROR
			FileUtils.copyFile(screenshot, new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		//clean directory for screenshots:
		try {
			FileUtils.cleanDirectory(new File(userDir+"//test-output//html//screenshots"));
		} catch (IOException e1) {
			//e1.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {

		/*
		 * MonitoringMail mail = new MonitoringMail(); System.out.println(
		 * MailConfig.server+"||"+ MailConfig.from+"||"+ MailConfig.to+"||"+
		 * MailConfig.subject+"||"+ MailConfig.messageBody+"||"+
		 * MailConfig.attachmentPath+"||"+ MailConfig.attachmentName); try {
		 * mail.sendMail( MailConfig.server, MailConfig.from, MailConfig.to,
		 * MailConfig.subject, MailConfig.messageBody, MailConfig.attachmentPath,
		 * MailConfig.attachmentName); } catch (MessagingException e) {
		 * e.printStackTrace(); }
		 */

	}

}
