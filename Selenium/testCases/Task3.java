package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
		//1. go to https://timesofindia.indiatimes.com/poll.cms
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		
		//2. calculate math question 
		//and paste result in result box
		
		//get text of Math calculation (delete ' ' and '=')
		String s = driver.findElement(By.id("mathq2")).getText().replace(" ", "").replace("=", "");

		//get 1st digit
		int m1 = Character.getNumericValue(s.charAt(0));
		
		//get 2st digit
		int m2 = Character.getNumericValue(s.charAt(2));
		
		//get what to do
		char calc = s.charAt(1);
		

		//calculate
		int result = 999;
		if (calc == '+') {
			result = m1 + m2;
		}else if (calc == '-') {
			result = m1 - m2;
		}else if (calc == '/') {
			result = m1 / m2;
		}else {
			result = m1 * m2;
		}
		
		s = Integer.toString(result);
		
		//paste result in result box
		driver.findElement(By.xpath("//*[@id=\"mathuserans2\"]")).sendKeys(s);
		
		//System.out.println(s+"\tm1="+m1+"\tm2="+m2+"\tcalc="+calc+"\tresult="+result);
		
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();

	}

}
