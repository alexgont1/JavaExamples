package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Page {

	public static WebDriver driver;

	// if you have the same navigation pane on each page
	// you can declare it here (+create class) and call in any TC:
	public static CRMTopMenu topCRM;
	// file separator for path independent from OS
	public static String fs = File.separator;

	// Project directory path:
	public static String userDir = Paths.get(".").normalize().toAbsolutePath().toString();

	// get absolute file path for current Project/OS
	public static String filePath(String filePathNonFormat) {
		String path = userDir;
		Pattern pattern = Pattern.compile("[a-zA-Z0-9.]+");
		Matcher matcher = pattern.matcher(filePathNonFormat);
		while (matcher.find()) {
			path = path + fs + matcher.group(0);
		}
		return path;
	}

	public static String configPath = filePath("resources/properties/Config.properties");
	public static String orPath = filePath("resources/properties/OR.properties");
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	static WebElement dropdown;
	// extentReport:
	// public ExtentReports rep = ExtentManager.getInstance();
	// public static ExtentHtmlReporter htmlReporter;
	// public static ExtentTest logger;

	// data provider
	public static String xlDataProvider;

	static {// logger log4j2.xml file location:
		File log4j2File = new File(filePath("resources/logs/log4j2.xml"));
		System.setProperty("log4j2.configurationFile", log4j2File.toURI().toString());
	}
	public static Logger log = LogManager.getLogger(Page.class);

	@BeforeSuite
	public void setUp() throws IOException {

		// hide useless RED messages from WebDriver
		java.util.logging.LogManager.getLogManager().reset();
		log.info("***Test suite is started***");

		if (driver == null) {

			fis = new FileInputStream(configPath);
			config.load(fis);
			fis = new FileInputStream(orPath);
			or.load(fis);
			xlDataProvider = filePath(or.getProperty("xlDataProvider"));

			// hide useless RED info messages from chromeDriver:
			System.setProperty("webdriver.chrome.silentOutput", "true");

			// chrome options:
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

			System.setProperty("webdriver.chrome.driver",
					(Paths.get(".").normalize().toAbsolutePath().toString() + File.separator + "chromedriver.exe"));
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.zoho.com/");
			// using navigation pane:
			//topCRM = new CRMTopMenu(driver);
			topCRM = new CRMTopMenu();
		}
	}

	public static void softAssert(Object expected, Object actual) throws IOException {
		try {
			Assert.assertEquals(expected.toString(), actual.toString());
		} catch (Throwable t) {
			// add screenshot
			// logger.fail("Verificaton failed. Error: "+t);
			// testUtil.snapshot();
		}
	}

	public void click(String locator) {
		driver.findElement(By.xpath(or.getProperty(locator))).click();
		log.info("Clicking on: " + locator);
		// logger.info("Clicking on: " + locator);
	}

	public void type(String locator, String keys) {
		driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(keys);
		log.info("Typing " + keys + " in: " + locator);
		// logger.info("Typing " + keys + " in: " + locator);
	}

	public void select(String locator, String value) {
		dropdown = driver.findElement(By.xpath(or.getProperty(locator)));
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		log.info("Selecting " + value + " in dropdown: " + locator);
		// logger.info("Selecting " + value + " in dropdown: " + locator);
	}

	public static boolean isElementPresent(String key) {
		try {
			driver.findElement(By.xpath(or.getProperty(key)));
			log.info("Element is found: " + key);
			return true;
		} catch (Exception e) {
			log.info("Error while finding element: " + key);
			log.info("Error message: " + e.getMessage());
			return false;
		}
	}

	@AfterSuite
	public void tearDown() {
		// close Extent Report
		// rep.flush();
		//driver.quit();
		log.info("***Test suite is finished***");
	}
}
