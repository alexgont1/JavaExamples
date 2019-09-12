package com.ddf2.testcases;

import org.testng.annotations.Test;

import com.ddf2.base.TestBase;
import com.ddf2.utilities.testUtil;

public class OpenAccountTest extends TestBase {

	@Test(dataProviderClass = testUtil.class, dataProvider = "dp")
	//method name below MUST be = sheet name with data in Excel file
	public void openAccountTest(String customer, String currency) {
		logger = rep.createTest("Open Account");
		
		System.out.println("Customer="+customer);
		System.out.println("Currency="+currency);
	}
}
