package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class testCase1 {
	
	public static void main(String[] args) throws IOException {
		
		//import file in class - click on error and select
		Properties prop = new Properties ();
		//copy location of file from properties
		//FileInputStream fis = new FileInputStream("S:\\eclipse\\workspace\\Java-PropertiesExcel\\src\\config\\object.properties");
		//import file in class - click on error and select
		
		//new version of line 14:
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\object.properties");
		
		prop.load(fis);
		//add throw Excep. from context error
		
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("course"));
		
		//get current user directory and then you use it
		//to simplify line 14 above for any other PC
		//good for migration
		System.out.println(System.getProperty("user.dir"));
		
	}

}
