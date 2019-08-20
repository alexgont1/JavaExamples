package utilities;

public class MailConfig {
	
	public static String server="smtp.gmail.com";
	public static String from = "***@gmail.com";
	public static String password = "xyz123!@#";
	public static String[] to ={"***@gmail.com"};//use ", test@mail.com..." to add more
	public static String subject = "Test Report";
	
	public static String messageBody ="TestMessage";
	//public static String attachmentPath=(System.getProperty("S:\\Selenium\\TestNGcourse\\test-output\\emailable-report.html"));
	public static String attachmentPath="S:\\Selenium\\TestNGcourse\\test-output\\emailable-report.html";	
	public static String attachmentName="emailable-report.html";

}