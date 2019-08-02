package testCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotElement {
	
	public static WebDriver driver;
	
	public static void captScreenshot() throws IOException {
		Date d = new Date();
		String formDate = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(d);  
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("s://screenshot//"+formDate+".jpg"));
			
	}
	
	public static void captScreenshotElmnt(WebElement elmnt) throws IOException{
		
		//1. full screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot);
		//2. find position and size of element
		Point point = elmnt.getLocation();
		int elmntWidth = elmnt.getSize().getWidth();
		int elmntHeight = elmnt.getSize().getHeight();
		//3. get subimage from full image
		BufferedImage elmntScreenshot = fullImg.getSubimage(point.x, point.y, elmntWidth, elmntHeight);
		//4. save subimage with current Date-time
		ImageIO.write(elmntScreenshot, "jpg", screenshot);		
		Date d = new Date();
		String formDate = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(d);  
		FileUtils.copyFile(screenshot, new File("s://screenshot//"+formDate+".jpg"));

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//hide all logs
		LogManager.getLogManager().reset();
		//hide warnings from CromeDriver
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		WebDriverManager.chromedriver().setup();
		//create driver without warnings
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

		//open web page
		driver.get("https://unsplash.com/explore");
		
		//find element for screenshot
		WebElement elmnt = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[5]/div[2]/div[1]/a/img"));		

		//SCREENSHOT OF ELEMENT:
		captScreenshotElmnt(elmnt);
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("***********Test is completed!***********");
		driver.quit();
	}

}
