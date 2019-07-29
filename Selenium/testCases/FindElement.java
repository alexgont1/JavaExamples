package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElement {
	
	public static void main(String[] args) throws InterruptedException {
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://gmail.com");
		
		//HOW TO MAXIMIZE WEB BROWSER WINDOW?
		//OPEN JAVA DOCS AT https://seleniumhq.github.io/selenium/docs/api/java/index.html
		//AND CLICK ON WebDriver in left section -> right side find ->
		//all methods. But there is not anything for windows. Try ->
		//click on WebDriver.Options - there you have 'window()' method
		driver.manage().window().maximize();
		
		//DON'T USE THREAD.SLEEP TO WAIT PAGE LOADING
//implicitly wait (max time wait till element become visible)->
		//works all time that script works
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		//BUT IT'S NOT ENOUGH
		//SOMETIMES ELEMENT IS VISIBLE BUT NOT ACCESSIBLE
		//FOR SUCH SITUATION YOU MUST WAIT ACCESSIBILITY:
		WebDriverWait wait = new WebDriverWait(driver, 10);		
		
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

		//WAIT ACCESSIBILITY OF ELEMENT - explicitly wait
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		//without line above this line won't work in Firefox
		driver.findElement(By.name("password")).sendKeys("12345");

		//Thread.sleep(2000); //- works,BUT NOT GOOD SOLUTION
		
		//WAIT TILL ELEMENT BECOME CLICKABLE
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passwordNext\"]/span/span")));
		
		//NOW IT WORKS:
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
