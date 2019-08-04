package parameterization;

import org.testng.annotations.DataProvider;

public class DataProviders {
		
	@DataProvider(name="dp1")
	public static Object[][] getData(){
		
		Object[][] data = new Object[2][2];
		
		data[0][0]="alex";
		data[0][1]="abc";
		
		data[1][0]="beta";
		data[1][1]="xyz";
		
		return data;
	}

}
