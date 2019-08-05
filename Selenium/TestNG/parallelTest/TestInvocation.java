package parallelTest;

import org.testng.annotations.Test;

public class TestInvocation extends BaseTest{
	
	@Test(invocationCount=5,threadPoolSize=5)//times,parallel
	public void executeTest() throws InterruptedException {
		
		driver = getDriver("chrome");
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}

}
