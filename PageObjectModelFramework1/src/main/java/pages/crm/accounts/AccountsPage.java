package pages.crm.accounts;

import java.io.IOException;

import base.Page;

public class AccountsPage extends Page{	
	
	public CreateAccountPage goToCreateAccount() throws IOException {	
		click("newAccountBtn");
		softAssert(isElementPresent("CRMnewAccountPageAssertion"),true);
		return new CreateAccountPage();
	}
	
	public void goToImportAccounts() {		
	}

}
