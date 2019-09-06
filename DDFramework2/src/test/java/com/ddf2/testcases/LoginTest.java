package com.ddf2.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ddf2.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException {

		driver.findElement(By.xpath(or.getProperty("managerLoginBtn"))).click();
		Assert.assertTrue(isElementPresent("addCustomerBtn"));
		
		String fp = TestBase.filePath(or.getProperty("addCustTestFile"));		
		System.out.println(fp);

		//Thread.sleep(3000);
	}

}
