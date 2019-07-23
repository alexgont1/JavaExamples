package Abstract;

//1st child of abstract - concrete class
//Good approach for Selenium to make sure you didn't miss
//any methods no matter which browser you are using
public class FirefoxDriver extends WebDriver {

	//created automatically when open error text about class
	//because it's 1st concrete class
	//BUT if it's also abstract then - no errors
	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendKeys() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTitle() {
		// TODO Auto-generated method stub
		
	}

}
