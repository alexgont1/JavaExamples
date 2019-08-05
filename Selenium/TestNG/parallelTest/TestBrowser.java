package parallelTest;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBrowser {
	
	@Parameters({"browser"})
	@Test
	public void doLogin(String b) throws InterruptedException {
		Date d = new Date();
		System.out.println("Browser:"+b+"\t"+d);
		Thread.sleep(2000);
	}
		
}
