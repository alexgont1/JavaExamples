package testCases;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDragDrop {

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

		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		//find dragDrop WebElement
		WebElement dragDrop = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(dragDrop, droppable).perform();
		//OR:
		Thread.sleep(3000);
		action.dragAndDropBy(dragDrop, 400, 400).perform();
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();
	}

}
