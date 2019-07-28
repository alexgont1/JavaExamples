package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {	
	
	public static String browser = "ie";//choose here
	public static WebDriver driver;

	public static void main(String[] args) {
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
						
		driver.get("https://www.google.com");
		
		String title = driver.getTitle();
		System.out.println(title+"; length="+title.length());
		
		System.out.println("Test is completed!");
		
		//driver.close();//close browser
		driver.quit();//close browser+related in current session
		
		
	
	}

}
