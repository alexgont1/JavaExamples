package com.ddf2.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ddf2.base.TestBase;
import com.ddf2.utilities.testUtil;

public class AddCustomerTest extends TestBase {

	@Test(priority = 2)
	public void verifyTitle() {
		logger = rep.createTest("Alert 111");
		Assert.assertEquals(driver.getTitle(), "Protractor practice website - Banking App");
	}

	@Test(priority = 3, dataProvider = "getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alertText)
			throws InterruptedException {
		logger = rep.createTest("Alert 222");

		click("addCustomerBtn");

		type("firstName", firstName);
		type("lastName", lastName);
		type("postCode", postCode);

		Thread.sleep(3000);

		click("addCustBtn");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		boolean alrt = alert.getText().contains(alertText);
		Assert.assertTrue(alrt);
		Thread.sleep(3000);
		alert.accept();
	}

	@Test(priority = 4)
	public void xtentExample() {
		// extentReport
		// logger = extent.createTest("To verify Google Title");
		// Assert.assertEquals(driver.getTitle(), "Google");
		// OR:
		logger = rep.createTest("Alert 333");
		// Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		boolean alrt = true;
		logger.createNode("Alert is Present");
		Assert.assertTrue(alrt);
		logger.createNode("Alert is not Present");
		Assert.assertFalse(alrt);
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		return testUtil.getData(or.getProperty("addCustTestFile"), or.getProperty("addCustTestSheet"));
	}

}
