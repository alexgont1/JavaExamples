import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		
		//choose folder with screenshots on failure for zip
		//zipName = zip file name with current Date/time
		String zipName[] = testUtil.zip("s:/screenshot");
		
		monitoringMail mail = new monitoringMail();
		try {
			//mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, zipName[0], zipName[1]);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}		
	}

	public void onStart(ITestContext arg0) {	
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}
	
	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getName().toString().trim();
		try {
			testUtil.captureScreenshot(methodName,"s:/screenshot");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public void onTestSkipped(ITestResult arg0) {
	}
	public void onTestStart(ITestResult arg0) {
	}
	public void onTestSuccess(ITestResult arg0) {
	}
}
