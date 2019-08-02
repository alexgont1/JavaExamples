package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	
	public static WebDriver driver;
	
	public static void captScreenshot() throws IOException {
		Date d = new Date();
		String formDate = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(d);  
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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

		//page with iFrames (2+ pages/frames on 1 page)
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		
		//element bellow is not available due to it's in another frame
		//so we must switch to this frame using id and then click:
		driver.switchTo().frame("iframeResult");
		//click on button that calls JS script 'myFunction()'
		//driver.findElement(By.xpath("//button")).click();

		//OR YOU CAN USE JS SCRIPT UNDER BUTTON:
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("myFunction()");
		Thread.sleep(3000);
		
		//Accept Alert
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		
		//OR YOU CAN INJECT OWN JS CODE:
		js.executeScript("arguments[0].style.color='red'", driver.findElement(By.xpath("//button")));
		
		//SCREENSHOT:
		captScreenshot();
		
		//switch to default content:
		driver.switchTo().defaultContent();
		
		//find all iFrames and print their names:
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("How many frames are here? "+frames.size());
		int i=0;
		for(WebElement frame: frames) {
			i++;
			System.out.println(i+". "+frame.getAttribute("id")+"\t"+frame.getAttribute("name"));
		}
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("***********Test is completed!***********");
		driver.quit();
	}

}
