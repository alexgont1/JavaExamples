package com.ddf2.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	// Initialize:
	// WebDriver
	// Properties
	// Logs
	// ExtentReports
	// DB
	// Excel
	// Mail

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

	}

	@AfterSuite
	public void tearDown() {

	}

}
