package testCases;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSliders {

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
		
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		
		//click Search button when it become clickable
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/center/input[1]"))).click();

		//find main slider width
		WebElement mainSlider = driver.findElement(By.cssSelector("#slider"));
		int width = mainSlider.getSize().width/2;
		
		//move slider to center
		WebElement slider = driver.findElement(By.cssSelector(".ui-slider-handle"));
		new Actions(driver).dragAndDropBy(slider, width, 0).perform();

		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();
	}

}
