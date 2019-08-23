package testcases;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;

public class MyProfileTest extends BaseTest{
	
	@BeforeTest
	public void starting() {
		start();
		login();
	}
	
	@Test
	public void MyProfileDDL() throws InterruptedException {

		Assert.assertTrue("Can't find My Profile tab",isElementPresent("myProfileTab"));		
		click("myProfileTab");		
		Assert.assertTrue("Can't find Country select",isElementPresent("selectCountry"));
		scroll("myProfileFooter");
		select("selectCountry", "selectCountrySet");
		click("myProfSubmitBtn");

		scroll("myProfileFooter");
		Assert.assertTrue("Doesn't selected",isSelected("selectCountry","selectCountrySet"));

	}
	
	@AfterTest
	public void LogOut() {
		logout();
		finish();
	}

}
