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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiBrsWDataProv {

	//add selenium server jar to Project	
	//before executing this code:
	//1. prepare hub in CMD
	//2. start at least 1 node
	//3. 
	
	public WebDriver driver;
	public DesiredCapabilities cap = new DesiredCapabilities();
	
	@Test(dataProvider="getData")
	public void testLogin(String username, String browser) throws MalformedURLException, InterruptedException {
		System.out.println(browser);
		//turn off red logs
		LogManager.getLogManager().reset();
		
		//add this for parallel with DataProvider:
		DesiredCapabilities cap = null;
		
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
		driver.findElement(By.id("login-username")).sendKeys(username);
		driver.findElement(By.id("login-signin")).click();
		
		//Thread.sleep(3000);
		//driver.quit();
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData(){
		
		Object data[][] = new Object[2][2];
		//OR YOU CAN READ DATA FROM SOME FILE
		data[0][0]="alex@mail.com";
		data[0][1]="firefox";
		
		data[1][0]="boris@mail.com";
		data[1][1]="chrome";
		
		return data;
	}
	
}
