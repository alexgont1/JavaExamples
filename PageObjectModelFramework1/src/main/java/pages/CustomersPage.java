package pages;

import org.openqa.selenium.By;

import base.Page;

public class CustomersPage extends Page {

	public void openProducts() {

	}

	public AboutUsPage goToAboutUs() {

		driver.findElement(By.xpath("//*[@class='zgh-nav active']//a[text()='About Us']")).click();
		
		//with line below you don't need to create CustomersPage 
		//instance in testCase 
		return new AboutUsPage();
	}

}
