package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {

	@Test
	public void validateTitles() {
		
		String expectedTitle = "Yahoo.com";
		String actualTitle = "Gmail.com";
		
		//it's not a bug here - don't create such test cases
		if (expectedTitle==actualTitle) {
			System.out.println("Passed");
		}else {
			System.out.println("Fail");
		}
		
		//HARD ASSERTIONS - TEST CASE STOP
		//use assertions to see bugs in test cases and stop execution
		//Assert.assertEquals(actualTitle, expectedTitle);
		
		//fail full test
		//Assert.fail("Failing the test as the condition is not met");
		//OR:
		//Assert.assertTrue(false, "Element not found");
		
		//if you don't want to stop full test case - use->
		//SOFT ASSERTIONS class:
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle, "Bug!!!");
		
		softAssert.assertEquals(true, false, "1 more bug!!!");
		//add line below in the end of test:
		softAssert.assertAll();//test will fail with all messages
		
		
	}
	
}
