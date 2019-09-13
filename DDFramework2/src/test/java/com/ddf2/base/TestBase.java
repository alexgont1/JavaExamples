package com.ddf2.base;

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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ddf2.utilities.ExtentManager;
import com.ddf2.utilities.testUtil;

public class TestBase {

	// Initialize:
	// WebDriver
	// Properties
	// Logs - log4j
	// ExtentReports, ReportNG
	// DB
	// Excel
	// Mail
	// Jenkins

	public static WebDriver driver;

	// Project directory path:
	public static String userDir = Paths.get(".").normalize().toAbsolutePath().toString();
	public static String fs = File.separator;
	// public static ExtentReports exRep = ExtentManager.getInstance();
	// public static ExtentTest test;

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

	public static String configPath = filePath("src/test/resources/properties/Config.properties");
	public static String orPath = filePath("src/test/resources/properties/OR.properties");
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	// extentReport:
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest logger;
	public static String xlDataProvider;
	static WebElement dropdown;

	static {// logger log4j2.xml file location:
		File log4j2File = new File(filePath("src/test/resources/logs/log4j2.xml"));
		System.setProperty("log4j2.configurationFile", log4j2File.toURI().toString());
	}
	public static Logger log = LogManager.getLogger(TestBase.class);

	@BeforeSuite
	public void setUP() throws IOException {

		// hide useless RED messages from WebDriver
		java.util.logging.LogManager.getLogManager().reset();
		log.info("***Test suite is started***");

		if (driver == null) {
			fis = new FileInputStream(configPath);
			config.load(fis);
			fis = new FileInputStream(orPath);
			or.load(fis);
			xlDataProvider = filePath(or.getProperty("xlDataProvider"));
		}

		if (config.getProperty("browser").equals("chrome")) {
			// hide useless RED info messages from chromeDriver:
			System.setProperty("webdriver.chrome.silentOutput", "true");
			// chrome options(disable automated test software message):
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			// chromedriver file is in executables folder:
			System.setProperty("webdriver.chrome.driver",
					(filePath("src/test/resources/executables/chromedriver.exe")));
			driver = new ChromeDriver(options);
		} else if (config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "gecko.exe");
		}

		driver.get(config.getProperty("homeUrl"));
		log.info("Home page is open");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implWait")), TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("explWait")));

	}

	public static void softAssert(String expected, String actual) throws IOException {
		try {
			Assert.assertEquals(expected, actual);
		} catch (Throwable t) {
			// add screenshot
			logger.fail("Verificaton failed. Error: "+t);
			testUtil.snapshot();
		}
	}

	public void click(String locator) {
		driver.findElement(By.xpath(or.getProperty(locator))).click();
		log.info("Clicking on: " + locator);
		logger.info("Clicking on: " + locator);
	}

	public void type(String locator, String keys) {
		driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(keys);
		log.info("Typing " + keys + " in: " + locator);
		logger.info("Typing " + keys + " in: " + locator);
	}
	
	public void select(String locator, String value) {
		dropdown = driver.findElement(By.xpath(or.getProperty(locator)));
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		log.info("Selecting " + value + " in dropdown: " + locator);
		logger.info("Selecting " + value + " in dropdown: " + locator);
	}

	public static boolean isElementPresent(String key) {
		try {
			driver.findElement(By.xpath(key));
			log.info("Element is found: " + key);
			return true;
		} catch (Exception e) {
			log.info("Error while finding element: " + key);
			log.info("Error message: " + e.getMessage());
			return false;
		}
	}

	@AfterMethod // for Extent Reports
	public void getResult(ITestResult result) throws Exception {
		int ir = result.getStatus();
		if (ir == ITestResult.FAILURE || ir == ITestResult.SKIP || ir == ITestResult.SUCCESS) {
			if (result.getStatus() == ITestResult.FAILURE) {
				// MarkupHelper is used to display the output in different colors
				logger.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				logger.log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				// add screenshot
				String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
				MediaEntityModelProvider mediaModel = MediaEntityBuilder
						.createScreenCaptureFromBase64String(base64Screenshot).build();
				logger.fail("Test Case Failed Snapshot: ", mediaModel);
			} else if (result.getStatus() == ITestResult.SKIP) {
				logger.log(Status.SKIP,
						MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				logger.log(Status.PASS,
						MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			}
		}
	}

	@AfterTest // for Extent Reports
	public void endReport() {
		// extent.flush();
	}

	@AfterSuite
	public void tearDown() {
		rep.flush();
		driver.quit();
		log.info("***Test suite is finished***");
	}

}
