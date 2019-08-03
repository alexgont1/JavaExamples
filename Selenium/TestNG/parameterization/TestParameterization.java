package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {
	
	@Test(dataProvider="getData")
	public void doLogin (String username, String password) {
		
		System.out.println(username+"---"+password);
		
	}
	
	@DataProvider
	public Object[][] getData() {
	//use Object[][](2 columns) for array with data of any type
		
		Object[][] data = new Object[3][2];//3rows*2cols
		
		data[0][0] = "alex";
		data[0][1] = "123";	
		
		data[1][0] = "boris";
		data[1][1] = "zuzuzu";	
		
		data[2][0] = "citrue";
		data[2][1] = "TRUE";	
		
		return data;		
		
	}

}
