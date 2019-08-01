package testCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopupsWindows {

	public static void main(String[] args) throws InterruptedException {
		
		//hide all logs
		LogManager.getLogManager().reset();
		//hide warnings from CromeDriver
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		WebDriverManager.chromedriver().setup();
		//create driver without warnings
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

		//page with popups and tabs
		driver.get("https://www.hdfcbank.com");
		
		//login is blocked by ad => must click on empty space
		Actions act = new Actions(driver);
		act.moveByOffset(0, 0).click().perform();
		
		//click on login
		driver.findElement(By.xpath("//*[@id='loginsubmit'][@class='homeloginbtn']")).click();
		//new popup window is open
				
		//click on 'Know more' in the bottom of 2nd window
		//so 1st you must switch to 2nd window
	//1. get all open windows handles-Set<String>-only unique values
		Set<String> winIds = driver.getWindowHandles();
		System.out.println(winIds);
		
		//get window handles:
		Iterator<String> iter = winIds.iterator();		
		iter.next();//window 1
		String win2 = iter.next();//window 2

		//switch to 2nd window:
		driver.switchTo().window(win2);
	
		//wait window and click on Know more
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div/div/div[1]/div/a"))).click();

		//in the same window wait and click on NetBanking
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong/a/span"))).click();
		
		//in 3rd window copy text and print
		winIds = driver.getWindowHandles();//now there are 3 windows
		iter = winIds.iterator();		
		iter.next();//window 1
		iter.next();//window 2
		driver.switchTo().window(iter.next());//window 3
		
		//switch to frame with text
		driver.switchTo().frame("login_page");
		System.out.println(driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[3]/table/tbody/tr[1]/td/table[1]/tbody/tr[2]/td")).getText());
		
	
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("***********Test is completed!***********");
		driver.quit();
	}

}
