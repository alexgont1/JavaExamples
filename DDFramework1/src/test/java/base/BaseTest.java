package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DBManager;
import utilities.MonitoringMail;

public class BaseTest {

	/*
	 *       Initializing: 
	 * WebDriver +
	 * Excel 
	 * Logs +
	 * Properties + 
	 * TestNG +
	 * JavaMail 
	 * ReportNG
	 * Database + 
	 * Explicit and Implicit wait + 
	 * Keywords +
	 * Screenshots 
	 * Maven - Build tool
	 * Jenkins
	 */

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = LogManager.getLogger(BaseTest.class);
	public static MonitoringMail mail = new MonitoringMail();
	public static WebDriverWait wait;
	// throws IOException - you can use it later:
	// ExcelRW xl = new
	// ExcelRW(System.getProperty("user_dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");

	@BeforeSuite // execute before run suite with all TCs
	public void setup() throws IOException {

		if (driver == null) {

			fis = new FileInputStream(
					System.getProperty("user_dir") + "\\src\\test\\resources\\properties\\Config.properties");
			Config.load(fis);
			log.info("Config file loaded.");

			fis = new FileInputStream(
					System.getProperty("user_dir") + "\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			log.info("OR file loaded.");
		}

		if (Config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome started");
		} else if (Config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox started");
		}

		DBManager.setMysqlDBConnection();
		log.info("Connected to DB");

		// open Web site
		driver.get(Config.getProperty("testSiteURL"));
		log.info("Navigated to" + Config.getProperty("testSiteURL"));
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicit.wait")));

	}

	// add short keywords for TCs:
	public static void click(String key) {
		//any error will stop test execution with Exception:
		driver.findElement(By.xpath(OR.getProperty(key))).click();
		log.info("Click on [" + key + "]");
	}

	public static void type(String key, String value) {
		// using try/catch to send msg to log and keep working:
		try {
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
			log.info("Type to [" + key + "]");
		} catch (Exception e) {
			log.error("ERROR trying type to element [" + key + "]");
			log.error("ERROR message: " + e.getMessage());
			// OR IF YOU WANT TO STOP TEST EXECUTION:
			// Assert.fail("ERROR trying type to element ["+key+"]");
		}
	}

	@AfterSuite // run after suite when all TCs are finished
	public void tearDown() {

		driver.quit();
		log.info("*****Tests execution completed*****");
	}
}
