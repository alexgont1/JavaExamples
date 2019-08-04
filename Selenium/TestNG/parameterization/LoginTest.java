package parameterization;

import org.testng.annotations.Test;

public class LoginTest {

	//take data from another class with dataProvider
	@Test(dataProviderClass=DataProviders.class,dataProvider="dp1")
	public void testData(String username, String password) {
		System.out.println("NAME: " + username + "; PASSWORD: " + password);
	}

}
