package com.ddf2.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ddf2.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException {

		driver.findElement(By.xpath(or.getProperty("managerLoginBtn"))).click();
		Assert.assertTrue(isElementPresent(or.getProperty("addCustomerBtn")));

		log.debug("Login successfully executed");

		Reporter.log("Login successfully executed");

		// you can see link and screenshot in emailable-report.html
		Reporter.log("<a href='file:///S:/screenshot/A1.jpg' target='_blank'>Screenshot link");
		Reporter.log(
				"<a href='file:///S:/screenshot/A1.jpg' target='_blank'><img height=100 src='file:///S:/screenshot/A1.jpg'>");

		// if you want to see the same in html/index.html you must add:
		System.setProperty("org.uncommons.reportng.escape-output", "false");


		// Thread.sleep(3000);
	}

}
