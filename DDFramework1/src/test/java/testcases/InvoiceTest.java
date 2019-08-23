package testcases;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;

public class InvoiceTest extends BaseTest {

	@BeforeTest
	public void starting() {
		start();
		login();
	}
	
	@Test
	public void Invoice() {
		
		Assert.assertTrue("Can't find Invoice button",isElementPresent("invoiceBtn"));		
		click("invoiceBtn");
		
		Assert.assertTrue("Can't find Invoice window",isWindowPresent("InvoicePageTitle"));
		getWindow("InvoicePageTitle");
		
		//find invoce title in document
		Assert.assertTrue("Can't find INVOICE title",isElementPresent("InvoiceDocTitle"));
		
		//find 'customer details'
		Assert.assertTrue("Can't find CUSTOMER DETAILS",isElementPresent("InvoiceCstmrDtls"));
		
		//find company address, phone and email
		Assert.assertTrue("Can't find company Address",isElementPresent("coAddress"));
		Assert.assertTrue("Can't find company Email",isElementPresent("coEmail"));
		Assert.assertTrue("Can't find company Phone",isElementPresent("coPhone"));
		
		//find print button
		Assert.assertTrue("Can't find PRINT button",isElementPresent("invoicePrntBtn"));
		
		//find 'download invoice' button
		Assert.assertTrue("Can't find Download Invoice button",isElementPresent("invoiceDownInvBtn"));
		
		//find 'download pdf' button
		Assert.assertTrue("Can't find Download PDF button",isElementPresent("invoiceDownPdfBtn"));
		
		//close invoice tab
		driver.close();
		
		Assert.assertTrue("Can't find My Account window",isWindowPresent("myAccPageTitle"));
		getWindow("myAccPageTitle");
				
	}
	
	@AfterTest
	public void LogOut() {
		logout();
		finish();
	}

}
