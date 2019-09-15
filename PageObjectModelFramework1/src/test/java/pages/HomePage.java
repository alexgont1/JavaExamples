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

	public void goToLogin() {
		click("goToLogin");
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
