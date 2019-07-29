package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElement {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("http://gmail.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		WebDriverWait wait = new WebDriverWait(driver, 10);		
		//YOU CAN REPLACE 2 LINES ABOVE BY - don't work actually
		/*FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3))
				.withMessage("User defined time out")
				.ignoring(NoSuchElementException.class);*/

		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("firma3001@gmail.com");
					
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();

		//WAIT ACCESSIBILITY OF ELEMENT - explicitly wait		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
		//without line above this line won't work in Firefox		
		driver.findElement(By.name("password")).sendKeys("12345");

		//WAIT TILL ELEMENT BECOME CLICKABLE
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passwordNext\"]/span/span")));
		
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
		
		//find text after enter wrong password		
		String s = driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/span/div[1]/div[2]/div[2]/span")).getText();
		System.out.println(s);
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();
		
	}	

}
