package com.auto.GRID;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSample {

	//add selenium server jar to Project
	
	//before executing this code:
	//1. prepare hub in CMD
	//2. start at least 1 node
	//3. run as 'TestNG test' OR create and run XML
	//(used test.xml with parallel execution)
	
	public WebDriver driver;
	public DesiredCapabilities cap = new DesiredCapabilities();
	
	@Test
	public void testLogin() throws MalformedURLException, InterruptedException {
		
		//cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);
		
		//hide red logs
		LogManager.getLogManager().reset();
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriverManager.chromedriver().setup();
		
		options.merge(cap);
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("http://gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("test@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}
	
}
