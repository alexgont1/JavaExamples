package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PresenseOfElement {
	
	public static WebDriver driver;
	
	//define own function to check presence
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}catch (Throwable t) {
			return false;
		}
	}
	

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"load_form\"]/fieldset[4]/select")));
		
		
		
		driver.get("https://www.wikipedia.org");
		
		//displayed element or not
		System.out.println("Displayed?");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]/strong")).isDisplayed());
		
		//using own function to check presence:
		System.out.println("Present?");
		System.out.println(isElementPresent(By.xpath("//*[@id=\"js-link-box-en\"]/strong")));
		
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();

	}

}
