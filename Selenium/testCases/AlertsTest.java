package testCases;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsTest {

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

		//page with JS alert
		driver.get("https://sweetalert2.github.io");

		//wait and click on button with Alert
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input"))).click();
		driver.findElement(By.xpath("//body/div[1]/button")).click();
		
		//simple close
		//driver.switchTo().alert().accept();
		
		//Alert with text
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		
		//if you need to wait Alert:
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//Alert alr = wait.until(ExpectedConditions.alertIsPresent());

		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();
	}

}
