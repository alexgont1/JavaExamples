package pages;

import org.openqa.selenium.By;

import base.Page;

public class LoginPage extends Page {

	// Logs
	// keywords
	// excel
	// properties
	//

	public void doLogin(String userName, String password) {

		driver.findElement(By.className("zh-login")).click();
		driver.findElement(By.id("lid")).sendKeys(userName);
		driver.findElement(By.id("pwd")).sendKeys(password);
		driver.findElement(By.id("signin_submit")).click();
	}

	public void createAccoutn() {

	}

}
