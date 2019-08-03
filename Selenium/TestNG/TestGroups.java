package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestGroups {
	
	//if you want to do smth. BEFORE EVERY test:
	@BeforeMethod // !!! import from TestNG !!!
	public void launchBrowser() {
		System.out.println("Start browser");
	}
	
	//if you want to do smth. AFTER EVERY test:
	@AfterMethod // !!! import from TestNG !!!
	public void closeBrowser() {
		System.out.println("close browser");
	}	
	
	//if you want to do smth. BEFORE ALL tests:
	@BeforeTest
	public void createDBConnection() {
		System.out.println("Connect to DB");
	}
	
	//if you want to do smth. AFTER ALL tests:
	@AfterTest
	public void closeDBConnection() {
		System.out.println("Disconnect from DB");
	}
	
	@Test(priority=1,groups="functional")	
	public void doLogin() {
		System.out.println("Executing login test");
	} 
	
	@Test(priority=2,groups="functional") 
	public void doUserReg() {
		System.out.println("Executing 2nd test");
	}
	
	@Test(priority=0,groups="smoke")
	public void doHighTest() {
		System.out.println("	Groups: smoke");
		System.out.println("Executing Highest priority test");
	}

	@Test(priority=1,groups= {"functional","smoke"})
	public void doA2ndTest() { 
		System.out.println("	Groups: functional+smoke");
		System.out.println("Executing A2nd priority test");
	}
	

}
