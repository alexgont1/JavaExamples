package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		
		Properties Config = new Properties();
		FileInputStream fig = new FileInputStream("S:\\Selenium\\SeleniumTests\\src\\test\\java\\Config.properties");
		Config.load(fig);
		
		Properties OR = new Properties();
		FileInputStream fi = new FileInputStream("S:\\Selenium\\SeleniumTests\\src\\test\\java\\OR.properties");
		OR.load(fi);
		
		System.out.println(OR.getProperty("username_XPATH"));
		//OR IN TEST:
		//driver.findElement(By.id(OR.getProperty("email_ID"))).sendKeys(OR.getProperty("keys_for_email_ID"));
		
		fig.close();
		fi.close();
	}

}
