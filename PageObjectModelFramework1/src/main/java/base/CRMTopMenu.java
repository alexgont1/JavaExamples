package base;

//this top CRM menu is encapsulated in all CRM pages
public class CRMTopMenu {//so you can't extend Page
	
	//you can use Page methods like this:
	//Page.driver.findElement(by)
	//	OR add this:
	//WebDriver driver;
	//public CRMTopMenu(WebDriver driver){
	//	this.driver = driver;}
	//	AND in Page use where initializing driver
	//topCRM = new CRMTopMenu(driver);
	//	AND you can use this driver here:
	// driver.findElement...
	
	public void goToHome() {

	}
	
	public void goToLeads() {		
	}

	public void goToContacts() {		
	}
	
	//...
	
	public void signOut() {		
	}
}
