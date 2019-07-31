package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"load_form\"]/fieldset[4]/select")));
		
		//1. go to http://qa.way2automation.com
		driver.get("http://qa.way2automation.com");
		
		//2. enter name in field Name 
		//and click on Submit button
		//BUT DON'T USE ABSOLUTE OR PARTIAL XPATHS
		driver.findElement(By.name("name")).sendKeys("11");
		
		//To submit form you need to fill all field
		driver.findElement(By.name("phone")).sendKeys("1");
		driver.findElement(By.name("email")).sendKeys("2@mail.com");
		driver.findElement(By.name("city")).sendKeys("1\tz\tz\t");
		
		//driver.findElement(By.name("username")).sendKeys("1");
		//driver.findElement(By.name("password")).sendKeys("1");
		
		
		//2 buttons with same name and xpath, click on 2nd
		List<WebElement> a = driver.findElements(By.className("button"));
		a.get(1).click();
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		//driver.quit();

	}

}
