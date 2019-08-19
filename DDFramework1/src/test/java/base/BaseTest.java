package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	/*	Initializing:
	 * WebDriver 
	 * Excel
	 * Logs
	 * Properties
	 * TestNG
	 * JavaMail
	 * ReportNG
	 * Database
	 * Explicit and Implicit wait
	 * Keywords
	 * Screenshots
	 * Maven - Build tool
	 * Jenkins
	 */

	@BeforeSuite //execute before run suite with TCs
	public void setup() {

	}

	public WebDriver driver;

	public WebDriver getDriver(String browser) {

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;
	}

	@AfterSuite//run after suite with TCs is finished 
	public void tearDown() {

	}
}
