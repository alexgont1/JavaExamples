package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
		
		String expectedTitle = "Yahoo.com";
		String actualTitle = "Gmail.com";
		
		@Test(priority=0) 
		public void doUserReg() {
			System.out.println("Executing Registration test");
			Assert.fail("User was not registered");
		}
		
		//@Test(priority=1)//this test depends on 1st test
//and should not work if 1st test fail, to fix use HARD dependency
		//and test will be skipped if 1st test fail
		@Test(priority=1, dependsOnMethods="doUserReg")
		public void doLogin() {
			System.out.println("Executing Login test");
		} 

		//this test also depends on 1st, but I want to run it anyway
		//it's SOFT dependency
		@Test(priority=2, dependsOnMethods="doUserReg",alwaysRun=true)
		public void do2ndLogin() {
			System.out.println("Executing 2nd Login test");
		} 

	
}
