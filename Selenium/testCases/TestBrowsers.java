package testCases;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBrowsers {

	public static void main(String[] args) {
		
		//To work with Firefox you must put in project 
		//geckodriver (copy-paste exe file in project)
		//OR BETTER TO SET SYSTEM PROPERTY:
		System.setProperty("webdriver.gecko.driver", "S:\\Selenium\\geckodriver.exe");
		
		
		FirefoxDriver driver = new FirefoxDriver();
		//Auto import libraries: CTRL+SHIFT+o
		

		driver.get("http://way2automation.com");
		
		
	
	}

}
