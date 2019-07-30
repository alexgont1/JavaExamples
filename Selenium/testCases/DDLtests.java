package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDLtests {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		
/*		//WORK WITH USUAL DDL:		
		driver.get("http://way2automation.com/way2auto_jquery/index.php");		
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"load_form\"]/fieldset[4]/select")));
		driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[4]/select")).sendKeys("French Guiana");
*/		
		//WORK WITH unUSUAL DDL:		
		driver.get("https://www.wikipedia.org");		
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"jsLangLabel\"]")));
		//driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]")).sendKeys("Italiano");
		//works but not best solution. Better to use:
		WebElement dropdown = driver.findElement((By.xpath("//*[@id=\"searchLanguage\"]")));
		Select select = new Select(dropdown);
		//select.selectByVisibleText("Norsk (Nynorsk)");
		//OR SELECT USING VALUE or INDEX:
		select.selectByValue("ja");
		
/*		//find all element options to print in report
		List<WebElement> values = driver.findElements(By.tagName("option"));
		System.out.println("Total values are: "+values.size());
		//print 10th element of list
		System.out.println(values.get(11).getText());
		
		//print all options text
		for(int i=0; i<values.size(); i++) {
			//use 'lang' due to problem with different lang fonts
			System.out.println(i+": "+values.get(i).getAttribute("lang"));
		}
*/				
/*		//print all links from web page
		//1. find all 'a' tags
		List<WebElement> vals = driver.findElements(By.tagName("a"));
		System.out.println("Total values are: "+vals.size());
		//2.print all 'a' tags text
		for(int i=0; i<vals.size(); i++) {
			System.out.println(i+": "+vals.get(i).getText()+"\t"+vals.get(i).getAttribute("href"));
		}
*/		
		//print links from 1 section of web page
		//select section:
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[6]/div[3]"));
		List<WebElement> links = block.findElements(By.tagName("a"));
		System.out.println("Total values are: "+links.size());
		//2.print all 'a' tags text
		for(int i=0; i<links.size(); i++) {
			System.out.println(i+": "+links.get(i).getText()+"\t"+links.get(i).getAttribute("href"));
		}

		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();
	}
	


}
