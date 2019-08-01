package testCases;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizableTask4 {

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

		//top left corner of browser window
		driver.manage().window().setPosition(new Point(100,100));
		
		//start window size
		driver.manage().window().setSize(new Dimension(300,300));
		
		//slowly and steadily enlarge window to big size
		for(int x=300; x<800; x++) {
			driver.manage().window().setSize(new Dimension(x,x));
		}
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();
	}

}
