package pages;

import base.Page;

public class ZohoAppPage extends Page {
	
	public CRMHomePage goToCRM() {		
		click("CRM");
		return new CRMHomePage();
	}
	
	public void goToProjects() {
		click("Projects");
	}

	//...
	
	public void goToDesk() {		
	}
	
	//...
	
	public void goToAnalytics() {		
	}
}
