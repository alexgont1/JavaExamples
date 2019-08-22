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
		try {
			// save screenshot with method name which is source of ERROR
			FileUtils.copyFile(screenshot, new File("s://screenshot//" + formDate + "_" + methodName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
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
