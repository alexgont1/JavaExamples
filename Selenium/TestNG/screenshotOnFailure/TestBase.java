package listenersOnFailure;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;

	@BeforeSuite
	public void setUp() {

		if (driver == null) {
			driver = new ChromeDriver();
		driver.get("http://gmail.com");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	}
	
	@AfterSuite
	public void tearDown() {

		driver.quit();
	}
}
