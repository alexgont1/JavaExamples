package testCases;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {	

	public static void main(String[] args) throws InterruptedException {
		
		//hide all logs
		LogManager.getLogManager().reset();
		//send all logs from Firefox to file
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"s:\\logs.txt");
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys("way2automation");
		
		//click Search button when it become clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/center/input[1]"))).click();
		
		//go to website		
		driver.findElement(By.xpath("//a[contains(@href,'on.com/')]/h3")).click();
		
		//move mouse to Resources menu
		WebElement menu = driver.findElement(By.xpath("//li[8]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		
		//click in menu on 'Practice site 1'
		driver.findElement(By.linkText("Practice site 1")).click();
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();
		
	}


}
