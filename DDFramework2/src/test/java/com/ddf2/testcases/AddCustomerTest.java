package com.ddf2.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ddf2.base.TestBase;
import com.ddf2.utilities.testUtil;

public class AddCustomerTest extends TestBase {

	@Test(dataProvider = "getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alertText)
			throws InterruptedException {

		driver.findElement(By.xpath(or.getProperty("addCustomerBtn"))).click();

		driver.findElement(By.xpath(or.getProperty("firstName"))).sendKeys(firstName);
		driver.findElement(By.xpath(or.getProperty("lastName"))).sendKeys(lastName);
		driver.findElement(By.xpath(or.getProperty("postCode"))).sendKeys(postCode);

		Thread.sleep(3000);

		driver.findElement(By.xpath(or.getProperty("addCustBtn"))).click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		Assert.assertTrue(alert.getText().contains(alertText));
		Thread.sleep(3000);
		alert.accept();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		return testUtil.getData(or.getProperty("addCustTestFile"), or.getProperty("addCustTestSheet"));
	}

}
