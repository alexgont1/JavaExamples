package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"load_form\"]/fieldset[4]/select")));
		
		//1. go to Google
		driver.get("https://www.google.com/");
		
		//2. in search - print 	way2automation
		driver.findElement(By.xpath("//*/div/div[1]/input")).sendKeys("way2automation");
		
		//3. click on button 'Google Search'
		driver.findElement(By.xpath("//*/div[2]/center/input[1]")).click();

		//4. click on 1st web site link found
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a")).click();
		
		//5. on page - find all links and count 
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links: "+links.size());
		
		int i=1;
		//6. print all links text
		for(WebElement link: links) {
			System.out.println(i+": "+link.getText());
			i++;
		}

		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();

	}

}
