package auto.Junit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//1. to use data from some file: 
@RunWith(Parameterized.class)

public class ParametersTC {

	//2. define parameters
	String firstName;
	String lastName;
	String password;
	int age;
	
	//3. create method to use all parameters
	public ParametersTC(String firstName, String lastName, String password, int age) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.age = age;		
	}
	
	//4. create array of parameters
	@Parameters
	public static Collection<Object[]> getData(){
		
		//execute test 2 times (2 rows) and 4 columns of data:
		Object[][] data = new Object[2][4];
		
		//1st row:
		data[0][0] = "Alex";
		data[0][1] = "Smith";
		data[0][2] = "123";
		data[0][3] = 25;
		
		//2nd row
		data[1][0] = "Boris";
		data[1][1] = "Johnson";
		data[1][2] = "456";
		data[1][3] = 35;
		
		return Arrays.asList(data);		
	}
	
	//5. create test case
	@Test
	public void doLogin() {
		
		System.out.println(firstName+" "+lastName+" password: "+password+" age: "+age);
	}
	
}
