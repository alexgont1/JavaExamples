package overriding;

public class ChromeDriver extends WebDriver {

	public void click() {
		
		System.out.println("Click in Chrome");
		
	}
	
	public void sendKeys() {
		
		System.out.println("Send keys in Chrome");
		
	}
	
}
