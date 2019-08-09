package com.auto.GRID;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiThreadBrsWDataProv {
	//add selenium server jar to Project	
	//before executing this code:
	//1. run hub and nodes using bat files
	//2. If you want parallel execution
	//you must add 1 thread for each data set
	//and for each execution you MUST select 
	//driver that you need and DesiredCapabilities
	public ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	public WebDriver driver;
	public ThreadLocal<DesiredCapabilities> dc = new ThreadLocal<DesiredCapabilities>();
	public DesiredCapabilities cap;
	public WebDriver getDriver() {
		return dr.get();
	}
	public void setWebDriver(WebDriver driver) {
		dr.set(driver);
	}
	public DesiredCapabilities getDesiredCapabilities() {
		return dc.get();
	}
	public void setDesiredCapabilities(DesiredCapabilities cap) {
		dc.set(cap);
	}

	@Test(dataProvider = "getData")
	public void launchBrowser(String browser, String username) throws MalformedURLException {
		LogManager.getLogManager().reset();
		
		Date d = new Date();
		System.out.println(browser + " " + d.toString());

		if (browser.equals("chrome")) {
			cap = new DesiredCapabilities();
			setDesiredCapabilities(cap);
			getDesiredCapabilities().setPlatform(Platform.ANY);
			getDesiredCapabilities().setBrowserName("chrome");
			ChromeOptions options = new ChromeOptions();
			options.merge(getDesiredCapabilities());

		} else if (browser.equals("firefox")) {
			cap = new DesiredCapabilities();
			setDesiredCapabilities(cap);
			getDesiredCapabilities().setBrowserName("firefox");
			getDesiredCapabilities().setPlatform(Platform.ANY);
			FirefoxOptions options = new FirefoxOptions();
			options.merge(getDesiredCapabilities());
		}

		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getDesiredCapabilities());
		//for parallel - select driver:
		setWebDriver(driver);
		//set driver
		getDriver().get("https://login.yahoo.com/?.src=ym&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().findElement(By.id("login-username")).sendKeys(username);
		getDriver().findElement(By.id("login-signin")).click();

		getDriver().quit();
	}

	@DataProvider(parallel = true)
	public Object[][] getData() {

		Object[][] data = new Object[2][2];

		data[0][0] = "chrome";
		data[0][1] = "trainer@way2automation.com";

		data[1][0] = "firefox";
		data[1][1] = "seleniumcoaching@gmail.com";

		return data;
	}

}
