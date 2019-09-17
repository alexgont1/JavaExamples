package pages;

import base.Page;

public class HomePage extends Page {

	// Logs
	// keywords
	// excel
	// properties
	//

	public CustomersPage goToCustomers() {

		click("goToCustomers");
		return new CustomersPage();
	}

	public void goToSupport() {
		click("goToSupport");
	}

	public void goToContactSales() {
	}

	public LoginPage goToLogin() {
		click("goToLogin");
		return new LoginPage();
	}

	public void goToFreeSignUp() {
	}

	public void goToMail() {
	}

	public void goToBooks() {
	}

	public void goToCreator() {
	}

	public void goToAnalytics() {
	}

	// ...

	public void validateFooterLinks() {
	}
}
