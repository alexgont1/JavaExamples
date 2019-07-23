package Abstract;

public abstract class WebDriver {
	
	//must be overridden in 1st level child class
	//BUT child of 1st level child don't need to be overridden
	public abstract void click();	
	
	public abstract void sendKeys();
	
	public abstract void getTitle ();
	
	//don't need to override in child
	public void captureScreenshot() {
		
	}
	
}
