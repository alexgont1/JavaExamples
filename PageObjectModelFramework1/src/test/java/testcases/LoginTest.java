package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.HomePage;
import pages.ZohoAppPage;

public class LoginTest extends Page {

	@Test
	public void goToCustomersPage() throws InterruptedException {

		HomePage home = new HomePage();
		home.goToLogin();
		
		Thread.sleep(10000);

		ZohoAppPage zp = new ZohoAppPage();
		zp.goToCRM();
		
		//Page.topNav.doSearch("test");
	}
}
