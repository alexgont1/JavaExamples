package testCases;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBrowsers {	

	public static void main(String[] args) {
		
		//To work with Firefox you must put in project 
		//geckodriver (copy-paste exe file in project)
		//OR BETTER TO SET SYSTEM PROPERTY:
		
		//System.setProperty("webdriver.chrome.driver", "S:\\Selenium\\chromedriver.exe");
		//System.setProperty("os.name","windows");
		System.setProperty("webdriver.opera.driver", "S:\\Selenium\\operadriver.exe");
		
		//System.setProperty("webdriver.ie.driver", "S:\\Selenium\\IEDriverServerV3-6-32x.exe");
		
		//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        // this line of code is to resolve protected mode issue 
		//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        //capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//FirefoxDriver driver = new FirefoxDriver();
		//ChromeDriver driver = new ChromeDriver();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		OperaOptions options = new OperaOptions();
		options.setBinary("C:\\Program Files\\Opera\\launcher.exe");
		capabilities.setCapability(OperaOptions.CAPABILITY, options);
		OperaDriver driver = new OperaDriver();
		
		//Auto import libraries: CTRL+SHIFT+o		
		//driver.wait(3000);				
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				
		driver.get("https://www.google.com");
		driver.findElementByLinkText("Store");
		
		System.out.println("Test is completed!");
		
		driver.close();
		
		
	
	}

}
