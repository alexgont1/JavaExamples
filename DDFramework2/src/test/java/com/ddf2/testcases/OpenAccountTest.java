package com.ddf2.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ddf2.base.TestBase;
import com.ddf2.utilities.testUtil;

public class OpenAccountTest extends TestBase {

	@Test(dataProviderClass = testUtil.class, dataProvider = "dp")
	// method name below MUST be = sheet name with data in Excel file
	public void openAccountTest(String customer, String currency) throws InterruptedException {
		logger = rep.createTest("Open Account");

		click("openAccBtn");
		select("custName", customer);
		select("currency", currency);
		click("processBtn");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(3000);
		alert.accept();
	}
}
