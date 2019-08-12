package auto.Junit;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class Assertions {
	
	//to see errors in log when you have 'catch' block
	@Rule
	public ErrorCollector ec = new ErrorCollector();
	
	@Test
	public void testTitle() {
		
		String expectedTitle = "google.com";//from Excel sheet
		String actualTitle = "google1.com";//from Selenium script
		
		//with code below you won't get error in JUnit log
		/*if(actualTitle==expectedTitle) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}*/
		
		System.out.println("Start comparising");
		
		try {
		//to see error in log use:
		assertEquals(expectedTitle, actualTitle);
		}catch(Throwable t) {
			System.out.println("Error captured");
			ec.addError(t);
		}
		//you won't see message below if test fail without 'catch'
		System.out.println("Comparison done");
		
	}

}
