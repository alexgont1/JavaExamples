package testCases;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {	

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.findElementByLinkText("Store");
		
		System.out.println("Test is completed!");
		
		driver.close();
		
		
	
	}

}
