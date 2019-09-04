package pages;

import org.openqa.selenium.By;

import base.Page;

public class HomePage extends Page {

	// Logs
	// keywords
	// excel
	// properties
	//

	public CustomersPage goToCustomers() {

		driver.findElement(By.className("zh-customers")).click();
		return new CustomersPage();
	}

	public void createAccoutn() {

	}

}
