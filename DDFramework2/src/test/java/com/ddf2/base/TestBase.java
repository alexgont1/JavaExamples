package com.ddf2.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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

	// get absolute file path for current Project/OS
	public static String filePath(String filePathNonFormat) {
		String path = userDir;
		Pattern pattern = Pattern.compile("[a-zA-Z.]+");
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

	static {// logger log4j2.xml file location:
		File log4j2File = new File(
				userDir + fs + "src" + fs + "test" + fs + "resources" + fs + "logs" + fs + "log4j2.xml");
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
		}

		if (config.getProperty("browser").equals("chrome")) {
			// hide useless RED info messages from chromeDriver:
			System.setProperty("webdriver.chrome.silentOutput", "true");
			// chromedriver file is in executables folder:
			System.setProperty("webdriver.chrome.driver", (userDir + fs + "src" + fs + "test" + fs + "resources" + fs
					+ "executables" + fs + "chromedriver.exe"));
			driver = new ChromeDriver();
		} else if (config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "gecko.exe");
		}

		driver.get(config.getProperty("homeUrl"));
		log.info("Home page is open");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implWait")), TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,Integer.parseInt(config.getProperty("explWait")));

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

		driver.quit();
		log.info("***Test suite is finished***");
	}

}
