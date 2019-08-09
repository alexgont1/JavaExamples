package com.auto.GRID;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiBrowsTest {

	//add selenium server jar to Project
	
	//before executing this code:
	//1. prepare hub in CMD
	//2. start at least 1 node
	//3. run multiBrows.xml as TestNG suite
	
	public WebDriver driver;
	public DesiredCapabilities cap = new DesiredCapabilities();
	
	@Parameters("browser")
	@Test
	public void testLogin(String browser) throws MalformedURLException, InterruptedException {
		System.out.println(browser);
		//turn off red logs
		LogManager.getLogManager().reset();
		
		if(browser.equals("firefox")) {
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			FirefoxOptions options = new FirefoxOptions();			
			cap.setPlatform(Platform.ANY);
			options.merge(cap);
			WebDriverManager.firefoxdriver().setup();
		}else if(browser.equals("chrome")) {
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			ChromeOptions options = new ChromeOptions();
			cap.setPlatform(Platform.ANY);
			options.merge(cap);
			WebDriverManager.chromedriver().setup();
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("https://login.yahoo.com/?.src=ym&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");
		driver.findElement(By.id("login-username")).sendKeys("test@mail.com");
		driver.findElement(By.id("login-signin")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}
	
}
