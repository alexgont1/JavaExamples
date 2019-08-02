package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;


public class ScreenshotAshot {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
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
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

		driver.get("https://google.com");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//find element for screenshot
		WebElement elmnt = driver.findElement(By.xpath("//*[@id='hplogo']"));

		//screenshot of element if you have jQuery on web page
		//Screenshot screenshot = new AShot().takeScreenshot(driver, elmnt);
		
		//screenshot of element without jQuery + RED OVERLAY
		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,elmnt);
		
		//screenshot of full screen with scrolling - 
		//viewportPasting = delays between screenshots
		//Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		
		//save with current Date-time				
		Date d = new Date();
		String formDate = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(d);		
		ImageIO.write(screenshot.getImage(), "jpg", new File("s://screenshot//A"+formDate+".jpg"));
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("***********Test is completed!***********");
		driver.quit();
	}

}
