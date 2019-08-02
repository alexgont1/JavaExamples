package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSscriptUse {

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
			
		//switch to default content:
		driver.switchTo().defaultContent();
		
		//find all iFrames and print their names:
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("How many frames are here? "+frames.size());
		for(WebElement frame: frames) {
			System.out.println(frame.getAttribute("id")+"\t"+frame.getAttribute("name"));
		}
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("***********Test is completed!***********");
		driver.quit();
	}

}
