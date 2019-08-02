package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
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
	
	//you don't need 'main' method here
	//instead it use:
	
	@Test // !!! import from TestNG !!!
	
	public void doLogin() { // it's 1 test for TestNG
		System.out.println("Executing login test");
	} //to execute - right click - 'run as' -> 'TestNG test'
	//in the bottom you can see tab 'Results of running class Test...'
	
	@Test//no priority means priority = 1 
	public void doUserReg() { // 2nd test due to abc order
		System.out.println("Executing 2nd test");
	}
	
	//if you want to change abc order use priority
	@Test(priority=0)//highest priority
	public void doHighTest() { // 2nd test due to abc order
		System.out.println("Executing Highest priority test");
	}

	@Test(priority=1)//2nd priority = others without priority
	public void doA2ndTest() { // 2nd test due to abc order
		System.out.println("Executing A2nd priority test");
	}
	

}
