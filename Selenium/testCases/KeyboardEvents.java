package testCases;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEvents {

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

		driver.get("https://outlook.live.com/mail");
		driver.findElement(By.xpath("//section/div/div/div[2]/a[2]")).click();
		
		//type email address
		driver.findElement(By.xpath("//*[@id='i0116']")).sendKeys("123");
		
		//Select keyboard keys
		Actions act =  new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		//combination - select ALL - don't work in FIREFOX
		act.sendKeys(Keys.chord(Keys.CONTROL+"a")).perform();
		//if you want complex key combination - build, then perform:
		act.sendKeys(Keys.chord(Keys.CONTROL+"a")).sendKeys(Keys.chord(Keys.CONTROL+"c")).sendKeys(Keys.RIGHT).sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();
	}

}
