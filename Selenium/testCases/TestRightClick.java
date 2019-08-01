package testCases;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRightClick {

	public static void main(String[] args) throws InterruptedException {
		
		//hide all logs
		LogManager.getLogManager().reset();
		//send all logs from Firefox to file
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"s:\\logs.txt");
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		
		//find WebElement for right click
		WebElement img = driver.findElement(By.xpath("//p[2]/img"));
		
		//right click on image
		Actions action = new Actions(driver);
		action.contextClick(img).perform();
		
		//click on 'Product Info' in menu
		action.click(driver.findElement(By.xpath("//*[@id='dm2m1i1tdT']"))).perform();

		//click on 'Installation' in menu
		action.click(driver.findElement(By.xpath("//*[@id='dm2m2i1tdT']"))).perform();

		//click on 'How to setup' in menu
		action.click(driver.findElement(By.xpath("//*[@id='dm2m3i1tdT']"))).perform();

		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();
	}

}
