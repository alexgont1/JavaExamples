package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBrowsers {
	
	

	public static void main(String[] args) throws InterruptedException {
		
		//To work with Firefox you must put in project 
		//geckodriver (copy-paste exe file in project)
		//OR BETTER TO SET SYSTEM PROPERTY:
		//System.setProperty("webdriver.gecko.driver", "S:\\Selenium\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "S:\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "S:\\Selenium\\IEDriverServerV3-6-32x.exe");
		
		//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        // this line of code is to resolve protected mode issue 
		//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        //capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//FirefoxDriver driver = new FirefoxDriver();
		//ChromeDriver driver = new ChromeDriver();
		
		//Auto import libraries: CTRL+SHIFT+o
		//options.ignoreZoomSettings();
		InternetExplorerDriver driver = new InternetExplorerDriver();
		
		//driver.wait(3000);		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		driver.get("https://www.google.com");
		
		driver.close();
		
		
	
	}

}
