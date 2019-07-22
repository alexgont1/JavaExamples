package overriding;

public class Base {
	
//we need universal method which returns new instance of
//browser depending on name
	public WebDriver getBrowserInstance (String browserName) {
		
		if(browserName.equals("firefox")) {
			return new FirefoxDriver();
		}else if(browserName.equals("chrome")) {
			return new ChromeDriver();
		}else if(browserName.equals("ie")) {
			return new IEDriver();
		}else {
			return new FirefoxDriver();
		}
		
	}

}
