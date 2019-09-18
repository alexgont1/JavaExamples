package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Page;
import pages.HomePage;
import pages.LoginPage;
import pages.ZohoAppPage;
import pages.crm.accounts.AccountsPage;
import pages.crm.accounts.CreateAccountPage;

public class LoginTest extends Page {

	@Test
	public void goToCustomersPage() throws InterruptedException, IOException {

		//to see messages in Extent Report-below line is mandatory
		logger = rep.createTest("LoginTest");
		
		HomePage home = new HomePage();
		LoginPage lp = home.goToLogin();

		Thread.sleep(10000);

		ZohoAppPage zp = lp.doLogin("user", "password");
		zp.goToCRM();
		AccountsPage ap = topCRM.goToAccounts();
		CreateAccountPage ca = ap.goToCreateAccount();
		ca.createAccount();

	}
}
