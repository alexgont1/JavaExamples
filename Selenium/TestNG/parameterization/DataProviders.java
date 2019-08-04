package parameterization;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
		
	@DataProvider(name="dp1")
	public static Object[][] getData(Method m){
		Object[][] data = null;
		//choose which data provide to test
		if(m.getName().equals("testLogin")) {
		data = new Object[2][2];
		
		data[0][0]="alex";
		data[0][1]="abc";
		
		data[1][0]="beta";
		data[1][1]="xyz";
		}else {
			data = new Object[2][3];
			
			data[0][0]="anjela";
			data[0][1]="abc";
			data[0][2]="111@mail.com";
			
			data[1][0]="boris";
			data[1][1]="xyz";
			data[1][2]="222@mail.com";
		}		
		return data;
	}
}
