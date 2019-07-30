package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTables {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"load_form\"]/fieldset[4]/select")));
		
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		
		
		//Find all rows in table
		List<WebElement> rowsNum = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("Total rows are: "+rowsNum.size());
		//find all data from 1st row, xpath=//*[@id="leftcontainer"]/table/tbody/tr[1]/td
		List<WebElement> colsNum = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[1]/td"));
		System.out.println("Total rows are: "+colsNum.size());
		
		//show all data from table
		for(int rows=1;rows<=rowsNum.size();rows++) {
			System.out.print(rows+": ");
			for(int cols=1;cols<=colsNum.size();cols++) {
				System.out.print(driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+rows+"]/td["+cols+"]")).getText()+"\t\t");
			}
			System.out.println();
		}
		
		//wait 3 sec and close browser
		Thread.sleep(3000);
		System.out.println("Test is completed!");
		driver.quit();

	}

}
