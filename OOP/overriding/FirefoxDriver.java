package overriding;

public class FirefoxDriver extends WebDriver {
	
	public void click() {
		
		System.out.println("Click in Firefox");
		
	}
	
	public void sendKeys() {
		
		System.out.println("Send keys in Firefox");
		
	}

}
