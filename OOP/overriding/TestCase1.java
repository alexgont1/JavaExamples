package overriding;

//more good solution:
public class TestCase1 extends Base {
	
	//changing only this one line you'll get different results
	String browserName="chrome";

	public static void main(String[] args) {

		/*FirefoxDriver driver = new FirefoxDriver();
		driver.click();
		driver.sendKeys();
		driver.getTitle();*/
//But, in different browsers all methods work differently
//So, we must use overriding in each class and then
//we don't need to change code inside driver block here
//depending on driver it will call driver's methods
//You must change only 1st line: ...Driver driver = new...
		
//more good solution:
		TestCase1 tc = new TestCase1();
		tc.initBrowser();
		
	}
	
	public void initBrowser() {
		//more good solution:
		WebDriver driver = getBrowserInstance(browserName);
		driver.click();
		driver.sendKeys();
		driver.getTitle();
		
	}

}
