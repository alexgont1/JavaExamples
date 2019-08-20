package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.zeroturnaround.zip.ZipUtil;

import base.BaseTest;

//source: TestNGListenerOnFailure
public class testUtil extends BaseTest{

	public static void captureScreenshot(String methodName, String screenshotPath) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(screenshotPath + "/" + dateForm() + "_" + methodName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// make zip of reports
	public static String[] zip(String filepath) {
		
		String attName = "Report_" + dateForm() + ".zip";		
		
		//mail program wants full path to file (included name)
		String attPath = TestConfig.attPath+"/"+attName;
		
		try {
			ZipUtil.pack(new File(filepath), new File(attPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String[] {attPath, attName};
	}

	// method to get current Date/time in short format (24h)
	public static String dateForm() {

		Date d = new Date();
		String formDate = new SimpleDateFormat("yyyy-MM-dd_k-mm-ss").format(d);
		return formDate;
	}
}
