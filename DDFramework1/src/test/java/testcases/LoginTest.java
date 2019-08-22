package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ExcelRW;

public class LoginTest extends BaseTest {

	public static ExcelRW xl = null;

	@Test(dataProvider = "getData")
	public void LoginAsUser(String email, String pass, String msg) {

		page("loginPage");

		type("emailField", email);

		type("passField", pass);

		clickEl("loginBtn");

		check("errorMsg", "confirm", email, pass, msg);

	}

	@DataProvider
	public String[][] getData() throws IOException {
		String fileName = userDir + Config.getProperty("data.login");
		String sheetName = Config.getProperty("data.login.sheet");

		// open file for reading
		ExcelRW xl = new ExcelRW(fileName);
		// Array without 1st row with column names:
		int rows = xl.getRowCount(sheetName) - 1;
		int cols = xl.getColsCount(sheetName);
		String[][] data = new String[rows][cols];

		// fill data from excel file
		// count from 1 to rows and from 0 to cols-1
		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {
				data[i - 1][j] = xl.getCellData(sheetName, i, j);
			}
		}
		return data;
	}
}
