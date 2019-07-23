package Abstract;

public class Test {

	public static void main(String[] args) {
		
		
		//impossible due to FirefoxDriver is 1st child		
		//FirefoxDriver wd = new Firefoxdriver();
		
		ChildOf1stChild w0d = new ChildOf1stChild();
		w0d.captureScreenshot();//method from parent SUPER class

	}

}
