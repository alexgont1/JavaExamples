package testCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	@BeforeSuite//before start any test suite
	//and you must 'extends' all child classes, example - TestCase1
	public void setup() {
		System.out.println("*****Initializing Everything****");
	}
	
	@AfterSuite//in the end of all test suites
	public void tearDown() {
		System.out.println("-----Quitting Everything-----");
	}

}
