package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.MonitoringMail;

public class BaseTest {

	/*
	 * Initializing: WebDriver + Excel Logs + Properties + TestNG + JavaMail
	 * ReportNG Database + Explicit and Implicit wait + Keywords + Screenshots Maven
	 * - Build tool Jenkins
	 */

	// Project directory path:
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
	public static WebElement dropdown;

	public static void finish() {
		log.info("***Test is finished: " + (Thread.currentThread().getStackTrace()[2].getClassName().split("\\.")[1])+ "***");
		log.info("++++++++++++++++++++++++++++++");
	}
	
	public static void start() {
		log.info("++++++++++++++++++++++++++++++");
		log.info("***Run test: " + (Thread.currentThread().getStackTrace()[2].getClassName().split("\\.")[1])+ "***");
	}

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

		// hide RED messages from WebDriver
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

		// set window position and size
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1100, 1055));
		// driver.manage().window().maximize();

		// open Web site
		driver.get(Config.getProperty("testSiteURL"));
		log.info("Navigated to [" + Config.getProperty("testSiteURL") + "]");

		// set waiting time
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicit.wait")));

	}

	public static boolean isElementPresent(String key) {
		try {
			driver.findElement(By.xpath(OR.getProperty(key)));
			log.info("Element is found: " + key);
			return true;
		} catch (Exception e) {
			log.info("Error while finding element: " + key);
			log.info("Error message: " + e.getMessage());
			return false;
		}
	}

	public static boolean isWindowPresent(String key) {
		Object A[] = driver.getWindowHandles().toArray();
		boolean b = false;
		String t;
		for (int i = 0; i < A.length; i++) {
			driver.switchTo().window((String) A[i]);
			t = driver.getTitle().toString();
			if (t.equals(OR.getProperty(key))) {
				b = true;
				break;
			}
		}
		return b;
	}

	public static void getWindow(String key) {
		Object A[] = null;
		A = driver.getWindowHandles().toArray();
		boolean b = false;
		String t;
		for (int i = 0; i < A.length; i++) {
			driver.switchTo().window((String) A[i]);
			t = driver.getTitle().toString();
			if (t.equals(OR.getProperty(key))) {
				b = true;
				break;
			}
		}
		if (b == false)
			Assert.fail("ERROR trying find Window [" + key + "]");
	}

	// add short keywords for TCs:
	public static void click(String key) {
		try {
			driver.findElement(By.xpath(OR.getProperty(key))).click();
			log.info("Click on [" + key + "]");
		} catch (ElementClickInterceptedException e) {
			cookies("cookies");
			driver.findElement(By.xpath(OR.getProperty(key))).click();
			log.info("2nd click after cookies");
		}
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

	public static void cookies(String key) {
		waitClick(key);
		click(key);
		log.info("Click on cookies message button");
	}

	public static void check(String key1, String key2, String d1, String d2, String expect) {
		String actual;
		try {
			waitEx(key1);
			actual = driver.findElement(By.xpath(OR.getProperty(key1))).getText();
		} catch (Exception e) {
			waitEx(key2);
			actual = driver.findElement(By.xpath(OR.getProperty(key2))).getText();
		}

		if (expect.equals(actual)) {
			log.info("[" + d1 + "/" + d2 + "] - Expected: [" + expect + "], " + "Actual: [" + actual + "], Pass");
		} else {
			log.info("[" + d1 + "/" + d2 + "] - Expected: [" + expect + "], " + "Actual: [" + actual + "], Fail!");
		}
	}

	public static void select(String key1, String key2) {

		dropdown = driver.findElement(By.xpath(OR.getProperty(key1)));
		Select select = new Select(dropdown);
		select.selectByVisibleText(OR.getProperty(key2));
		log.info("Element select: [" + key1 + ":" + OR.getProperty(key2) + "]");
	}

	public static boolean isSelected(String key1, String key2) {

		String selected = new Select(driver.findElement(By.xpath(OR.getProperty(key1)))).getAllSelectedOptions().get(0)
				.getText();
		if (selected.equals(OR.getProperty(key2))) {
			log.info("Element selected: [" + selected + "]");
			return true;
		} else {
			return false;
		}
	}

	public static void scroll(String key) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(OR.getProperty(key)));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(2000);
	}

	public static void waitEx(String key) {
		log.info("Waiting for [" + key + "]");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty(key))));
	}

	public static void waitClick(String key) {
		log.info("Waiting for [" + key + "]");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(key))));
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void login() {
		driver.get(OR.getProperty("loginPage"));
		waitEx("loginPageForm");
		type("emailField", OR.getProperty("email"));
		type("passField", OR.getProperty("pass"));
		click("loginBtn");
		Assert.assertTrue("Can't login", isElementPresent("confirm"));
	}

	public static void logout() {
		waitEx("logoutDDMenu");
		click("logoutDDMenu");
		waitEx("logoutLink");
		click("logoutLink");
		Assert.assertTrue("Can't logout", isElementPresent("loginPageForm"));
	}

	public static void page(String url) {
		driver.get(OR.getProperty(url));
		log.info("Navigated to [" + OR.getProperty(url) + "]");
	}

	@AfterSuite // run after suite when all TCs are finished
	public void tearDown() {

		driver.quit();
		log.info("*****Tests execution completed*****");
	}
}
