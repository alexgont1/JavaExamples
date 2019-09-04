package base;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Page {

	public static WebDriver driver;
	
	//if you have the same navigation pane on each page
	//you can declare it here (+create class) and call in any TC:
	public static TopNavigation topNav;

	public Page() {
		if (driver == null) {
			// chrome options:
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

			System.setProperty("webdriver.chrome.driver",
					(Paths.get(".").normalize().toAbsolutePath().toString() + File.separator + "chromedriver.exe"));
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.zoho.com/");
			//using navigation pane:
			topNav = new TopNavigation();
		}
	}

}
