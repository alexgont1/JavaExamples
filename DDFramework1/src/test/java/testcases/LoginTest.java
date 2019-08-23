package testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.testUtil;

public class LoginTest extends BaseTest {

	@BeforeTest
	public void starting() {
		start();
	}
	
	@Test(dataProvider = "getData")
	public void LoginAsUser(String email, String pass, String msg) {

		page("loginPage");
		Assert.assertTrue("Can't find Login Form", isElementPresent("loginPageForm"));

		type("emailField", email);

		type("passField", pass);

		click("loginBtn");

		check("errorMsg", "confirm", email, pass, msg);

	}

	@AfterTest
	public void LogOut() {
		logout();
		finish();
	}

	@DataProvider
	public String[][] getData() throws IOException {
		return testUtil.getData("data.login", "data.login.sheet");
	}
}
