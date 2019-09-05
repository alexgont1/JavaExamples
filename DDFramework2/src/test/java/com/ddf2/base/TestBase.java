package com.ddf2.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	// Initialize:
	// WebDriver
	// Properties
	// Logs
	// ExtentReports, ReportNG
	// DB
	// Excel
	// Mail
	// Jenkins

	public static WebDriver driver;

	// Project directory path:
	public static String userDir = Paths.get(".").normalize().toAbsolutePath().toString();
	public static String fs = File.separator;
	public static String configPath = userDir + fs + "src" + fs + "test" + fs + "resources" + fs + "properties" + fs
			+ "Config.properties";
	public static String orPath = userDir + fs + "src" + fs + "test" + fs + "resources" + fs + "properties" + fs
			+ "OR.properties";
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;

	@BeforeSuite
	public void setUP() throws IOException {

		if (driver == null) {
			fis = new FileInputStream(configPath);
			config.load(fis);
			fis = new FileInputStream(orPath);
			or.load(fis);
		}

		if (config.getProperty("browser").equals("chrome")) {
			// chromedriver file is in executables folder:
			System.setProperty("webdriver.chrome.driver", (userDir + fs + "src" + fs + "test" + fs + "resources" + fs
					+ "executables" + fs + "chromedriver.exe"));
			driver = new ChromeDriver();
		} else if (config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "gecko.exe");
		}

		driver.get(config.getProperty("homeUrl"));
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implWait")), TimeUnit.SECONDS);

	}

	@AfterSuite
	public void tearDown() {

		driver.quit();
	}

}
