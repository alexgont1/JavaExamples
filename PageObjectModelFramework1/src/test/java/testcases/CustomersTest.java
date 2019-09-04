package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.HomePage;

public class CustomersTest {

	@Test
	public void goToCustomersPage() {

		HomePage home = new HomePage();
		home.goToCustomers();

		Page.topNav.doSearch("test");
	}
}
