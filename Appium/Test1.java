package com.auto.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test1 {

	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;

	// Elements
	String secondNewJob = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/"
			+ "android.widget.RelativeLayout/android.widget.ImageView";

	@BeforeMethod
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "LENOVO Lenovo S860");
		caps.setCapability("udid", "4TQCTCBQJFTGU4U4"); // DeviceId from "adb devices" command
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "4.4");
		caps.setCapability("skipUnlock", "true");
		//caps.setCapability("appPackage", "com.android.chrome");//does't work with '...MobileCapabilityType.BROWSER_NAME...'
		//caps.setCapability("appActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");
		/*caps.setCapability("appPackage", "org.mozilla.firefox");
		caps.setCapability("appActivity", "org.mozilla.gecko.BrowserApp");*/
		caps.setCapability("noReset", "false");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME,MobileBrowserType.CHROME);//to hide 'welcome' screen
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}
	//AUGUST 14,2019 - DOESN'T WORK AFTER GOOGLE CHROME UPDATE TO VERSION 76
	//CHROME MUST BE VERSION 71-75

	@Test
	public void basicTest() throws InterruptedException {
		// Click and pass Splash
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.isinolsun.app:id/animation_view"))).click();

		// Click I am searching a job
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.isinolsun.app:id/bluecollar_type_button"))).click();

		/*// Notification Allow
		if (driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).size() > 0) {
			driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).get(0).click();
		}*/

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondNewJob)));
		
		/*driver.get("https://google.com");
		driver.wait(3000);
		driver.findElement(By.xpath("//*[@id='tsf']//div/div[1]/input")).sendKeys("test");*/
		
		String s = driver.getDeviceTime().toString();
		System.out.println(s);
		
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
