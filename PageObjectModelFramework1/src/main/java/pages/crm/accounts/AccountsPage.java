package pages.crm.accounts;

import java.io.IOException;

import base.Page;

public class AccountsPage extends Page{	
	
	public void goToCreateAccount() throws IOException {	
		click("newAccountBtn");
		softAssert(isElementPresent("CRMnewAccountPageAssertion"),true);
	}
	
	public void goToImportAccounts() {		
	}

}
