package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
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

	//Project directory path:
	public static String userDir = Paths.get(".").normalize().toAbsolutePath().toString();
	
	static {// logger log4j2.xml file location:
		File log4j2File = new File(userDir + "\\resources\\logs\\log4j2.xml");
		System.setProperty("log4j2.configurationFile", log4j2File.toURI().toString());
	}
	public static Logger log = LogManager.getLogger(BaseTest.class);

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static MonitoringMail mail = new MonitoringMail();
	public static WebDriverWait wait;
	
	// throws IOException - you can use it later:
	// ExcelRW xl = new
	// ExcelRW(System.getProperty("user_dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");

	@BeforeSuite // execute before run suite with all TCs
	public void setup() throws IOException {
		
		log.info("*****Tests execution started*****");

		if (driver == null) {

			fis = new FileInputStream(userDir + "\\resources\\properties\\Config.properties");
			Config.load(fis);
			log.info("Config.properties file loaded.");

			fis = new FileInputStream(userDir + "\\resources\\properties\\OR.properties");
			OR.load(fis);
			log.info("OR.properties file loaded.");
		}

		//hide RED messages from WebDriver
		java.util.logging.LogManager.getLogManager().reset();
		
		if (Config.getProperty("browser").equals("chrome")) {
			// hide RED info messages from chromeDriver:
			System.setProperty("webdriver.chrome.silentOutput", "true");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome started");
		} else if (Config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox started");
		}

		// DB connection
		// DBManager.setMysqlDBConnection();
		// log.info("Connected to DB");

		//set window position and size
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().setSize(new Dimension(1100,1055));
		//driver.manage().window().maximize();
		
		// open Web site
		driver.get(Config.getProperty("testSiteURL"));
		log.info("Navigated to [" + Config.getProperty("testSiteURL") + "]");

		//set waiting time
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicit.wait")));

	}

	// add short keywords for TCs:
	public static void clickEl(String key) {
		// any error will stop test execution with Exception:
		driver.findElement(By.xpath(OR.getProperty(key))).click();
		log.info("Click on [" + key + "]");
	}

	public static void type(String key1, String key2) {
		// using try/catch to send msg to log and keep working:
		try {
			driver.findElement(By.xpath(OR.getProperty(key1))).sendKeys(key2);
			log.info("Type to [" + key1 + "]");
		} catch (Exception e) {
			log.error("ERROR trying type to element [" + key1 + "]");
			log.error("ERROR message: " + e.getMessage());
			// OR IF YOU WANT TO STOP TEST EXECUTION:
			// Assert.fail("ERROR trying type to element ["+key+"]");
		}
	}
	
	public static void check(String key1, String key2, String d1, String d2, String expect) {
		String actual;
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(key1))));
		actual = driver.findElement(By.xpath(OR.getProperty(key1))).getText();
		}catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(key2))));
			actual = driver.findElement(By.xpath(OR.getProperty(key2))).getText();
		}
		
		if (expect.equals(actual)) {
			log.info("["+d1+"/"+d2+"] - Expected: [" + expect + "], "+"Actual: [" + actual + "], Pass");
		}else {
			log.info("["+d1+"/"+d2+"] - Expected: [" + expect + "], "+"Actual: [" + actual + "], Fail!");
		}			
	}
	
	public static void waitEx(String key) {
		log.info("Waiting for [" + key + "]");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(key))));
	}

	public static void start(String key) {
		log.info("++++++++++++++++++++++++++++++");
		log.info("***Run test: "+key+"***");
	}
	
	/*public static void confirmation(String key1, String key2) {		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty(key1))));
		log.info("***Confirmation for "+key2+"***");
		log.info("++++++++++++++++++++++++++++++");
	}*/
	
	public static void refresh() {
		driver.navigate().refresh();
	}
	
	public static void page (String url) {
		driver.get(OR.getProperty(url));
		log.info("Navigated to ["+OR.getProperty(url)+"]");
	}

	@AfterSuite // run after suite when all TCs are finished
	public void tearDown() {

		driver.quit();
		log.info("*****Tests execution completed*****");
	}
}
