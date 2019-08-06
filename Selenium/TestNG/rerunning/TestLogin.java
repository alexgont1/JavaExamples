package rerunning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin {

	@Test(priority=1)
	public void doLogin() {
		System.out.println("Executing Login Test");
	}
	
	static int count=0;
	@Test(priority=2)
	public void registerUsers() {
		
		System.out.println(count++);
		Assert.fail("Fail while Registering a user");
	}
}
