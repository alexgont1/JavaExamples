package listenersOnFailure;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

	@Test
	public void doLogin() {
		driver.findElement(By.id("identifierId")).sendKeys("123@mail.com");
		
		//click Next
		driver.findElement(By.xpath("//*[@id='identifierNext']//span")).click();
		
		//ERROR - wrong xpath
		driver.findElement(By.xpath("//*[@id='password1']//input")).sendKeys("123");
	}
}
