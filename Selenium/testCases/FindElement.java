package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElement {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
		
		//WebElement userName =  driver.findElement(By.id("identifierId"));
		
		//inspect element, right click on code - Copy - xpath
		//WebElement userName =  driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
		//userName.sendKeys("firma3001@gmail.com");
		
		//OR INSTEAD OF 2 LINES YOU CAN USE 1, because ->
		//'findElement' returns WebElement and you can ->
		//use all methods of WebElement
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("firma3001@gmail.com");
					
		//WebElement buttonNext =  driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span"));
		//buttonNext.click();
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		
	}	

}
