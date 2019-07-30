package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"load_form\"]/fieldset[4]/select")));
		
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		
/*		//click on checkbox:
		//check short version of xpath-in Crome Elements - CTRL+F
		driver.findElement(By.xpath("//div[4]/input[1]")).click();
		driver.findElement(By.xpath("//div[4]/input[2]")).click();
		driver.findElement(By.xpath("//div[4]/input[3]")).click();
		driver.findElement(By.xpath("//div[4]/input[4]")).click();
		//OR in loop:
		for(int i=1; i<5;i++) {
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
		}
*/		
		//find all checkboxes in web page block using name:
		WebElement block = driver.findElement(By.xpath("//tbody/tr/td/div[4]"));
		List<WebElement> checkboxes = block.findElements(By.name("sports"));
		System.out.println("Total checkboxes are: "+checkboxes.size());
		for(WebElement checkbox: checkboxes) {
			checkbox.click();
		}
		
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();
		

	}

}
