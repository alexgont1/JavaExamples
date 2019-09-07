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

		Assert.fail("Fail!!!");

		// Thread.sleep(3000);
	}

}
