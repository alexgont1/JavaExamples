package com.ddf2.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ddf2.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws IOException {		
		
		logger = rep.createTest("login");
		logger.createNode("Login successfully executed");
		//HARD assertion - if Fail then all Test fail
		Assert.assertEquals(driver.getTitle(), "Protractor practice website - Banking App");
		
		click("managerLoginBtn");
		Assert.assertTrue(isElementPresent(or.getProperty("addCustomerBtn")));
		log.debug("Login successfully executed");
		Reporter.log("Login successfully executed");
		
		//soft assertion from TestBase - test will go to next step
		softAssert(driver.getTitle(), "test");

		// Thread.sleep(3000);
	}
}
