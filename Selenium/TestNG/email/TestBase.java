import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
		
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp(){
		
/*		//hide all logs for FIREFOX + waiting
		LogManager.getLogManager().reset();
		//send all logs from Firefox to file
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"s:\\logs.txt");
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
*/	
		
		//hide all logs for CHROME
		LogManager.getLogManager().reset();
		//hide warnings from CromeDriver
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		WebDriverManager.chromedriver().setup();
		//create driver without warnings
		//driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));		
		
		
		if(driver==null){
		driver = new ChromeDriver(options);
		driver.get("http://gmail.com");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);		
		}
	}
	
	@AfterSuite
	public void tearDown(){		
		driver.quit();		
	}
}
