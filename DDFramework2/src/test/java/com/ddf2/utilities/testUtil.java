package com.ddf2.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ddf2.base.TestBase;

//source: TestNGListenerOnFailure
public class testUtil extends TestBase {

	public static void captureScreenshot(String methodName, String screenshotPath) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(screenshotPath + "/" + dateForm() + "_" + methodName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public static String[][] getData(String file, String sheet) throws IOException {
		// String fileName = userDir + Config.getProperty(file);
		// String sheetName = Config.getProperty(sheet);

		// open file for reading
		ExcelRW xl = new ExcelRW(file);
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
}
