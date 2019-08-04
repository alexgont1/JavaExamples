package parameterization;

import org.testng.annotations.Test;

public class LoginTest {

	//take data from another class with dataProvider
	@Test(priority=1,dataProviderClass=DataProviders.class,dataProvider="dp1")
	public void testLogin(String username, String password) {
		System.out.println("NAME: " + username + "; PASSWORD: " + password);
	}
	
	@Test(priority=2,dataProviderClass=DataProviders.class,dataProvider="dp1")
	public void testUserReg(String username, String password, String email) {
		System.out.println("NAME: " + username + "; PASSWORD: " + password+"; EMAIL: "+email);
	}

}
