package rough;

import base.Page;
import pages.HomePage;

public class TestCustomers {

	public static void main(String[] args) {

		
	/*	HomePage home = new HomePage();
		home.goToCustomers();
		CustomersPage customers = new CustomersPage();
		customers.goToAboutUs();*/
		
		//.goToCustomers() returns CustomersPage
		//so you can call methods of CustomerPage and so on
		//So all 4 lines above can replace 1 line:
		new HomePage().goToCustomers().goToAboutUs();
		
		//	Or:
		//HomePage h = new HomePage();
		//CustomersPage c = h.goToCustomers();
		//c.goToAboutUs();
		
		//search:
		Page.topNav.doSearch("test");
		
	}
}
