package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Page;
import pages.HomePage;
import pages.ZohoAppPage;
import pages.crm.accounts.AccountsPage;
import pages.crm.accounts.CreateAccountPage;

public class LoginTest extends Page {

	@Test
	public void goToCustomersPage() throws InterruptedException, IOException {

		HomePage home = new HomePage();
		home.goToLogin();
		
		Thread.sleep(10000);

		ZohoAppPage zp = new ZohoAppPage();
		zp.goToCRM();
		
		topCRM.goToAccounts();
		
		AccountsPage ap = new AccountsPage();
		ap.goToCreateAccount();
		
		CreateAccountPage ca = new CreateAccountPage();
		ca.createAccount();

	}
}
