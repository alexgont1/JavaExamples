package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

import base.Page;

//source: TestNGListenerOnFailure
public class Utils extends Page {

	public static String captureScreenshot(String methodName, String screenshotPath) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotFilePath = screenshotPath + fs + dateForm() + "_" + methodName + ".jpg";
		try {
			FileUtils.copyFile(scrFile, new File(screenshotFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotFilePath;
	}

	// Extent Report snapshot
	public static void snapshot() throws IOException {
		String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot)
				.build();
		logger.fail("Failed Snapshot: ", mediaModel);
	}

	// make zip of reports
	/*
	 * public static String[] zip(String filepath) {
	 * 
	 * String attName = "Report_" + dateForm() + ".zip";
	 * 
	 * // mail program wants full path to file (included name) String attPath =
	 * TestConfig.attPath + "/" + attName;
	 * 
	 * try { ZipUtil.pack(new File(filepath), new File(attPath)); } catch (Exception
	 * e) { e.printStackTrace(); } return new String[] { attPath, attName }; }
	 */

	// method to get current Date/time in short format (24h)
	public static String dateForm() {

		Date d = new Date();
		String formDate = new SimpleDateFormat("yyyy-MM-dd_k-mm-ss").format(d);
		return formDate;
	}

	@DataProvider(name = "dp")
	public static String[][] getData(Method m) throws IOException {

		String sheet = m.getName();
		// open file for reading
		ExcelRW xl = new ExcelRW(xlDataProvider);
		// Array without 1st row with column names:
		int rows = xl.getRowCount(sheet) - 1;
		int cols = xl.getColsCount(sheet);
		String[][] data = new String[rows][cols];

		// fill data from excel file
		// count from 1 to rows and from 0 to cols-1
		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {
				data[i - 1][j] = xl.getCellData(sheet, i, j);
			}
		}
		return data;
	}

	// filtering test execution using TestSuite page from Excel file
	public static boolean isTestRun(String testName) throws IOException {
		ExcelRW xl = new ExcelRW(xlDataProvider);
		int testRow = 1;// 0 row contains titles
		int rows = xl.getRowCount("TestSuite");
		while (!xl.getCellData("TestSuite", testRow, 0).equals(testName)) {
			testRow++;
			if (testRow > rows) {
				System.out.println("Didn't find test: " + testName);
				break;
			}
		}
		if (xl.getCellData("TestSuite", testRow, 1).equalsIgnoreCase("y")) {
			return true;
		} else {
			return false;
		}
	}
}
