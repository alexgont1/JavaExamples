package auto.Junit;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Junit1 {

	public static boolean dbConnection() {
		//return false;//no connection
		return true;
	}
	
	public static boolean validateLink() {
		return false;
	}
	
	@BeforeClass//before ALL tests
	public static void seleniumSetup() {
		System.out.println("*****Selenium setup*****");
		Assume.assumeTrue(dbConnection());//no connection-no tests
	}

	@Before//before each test
	public void testOpenBrowser() {
		
		System.out.println("+++Open Firefox browser+++");
	}
	
	@Test//Add JUnit to build path
	//To start it - right click - Run as JUnit test
	public void testNavigation() {
		
		Date d = new Date();
		System.out.println("Open website ["+d+"]");
	}
	
	@Ignore//skip this test
	@Test
	public void testLogin() {
		
		Date d = new Date();
		System.out.println("Login test ["+d+"]");
	}
	
	@Test
	public void testLink() {
		
		System.out.println("Validating the presence of the link");
		Assume.assumeTrue(validateLink());
	}

	@After//after each test
	public void testCloseBrowser() {
		System.out.println("+++Close Firefox browser+++");
	}
	
	@AfterClass//after ALL tests
	public static void seleniumShutdown() {
		System.out.println("*****Close Selenium*****");
	}
}
