package utilities;


public class TestConfig{

	public static String server="smtp.gmail.com";
	public static String from = "***@gmail.com";
	public static String password = "xyz123!@#";
	public static String[] to ={"***@gmail.com"};//use ", test@mail.com..." to add more
	public static String subject = "Test Report";	
	public static String messageBody ="TestMessage";
	
	//attPath to zip files for report
	public static String attPath="s:/Reports";
	
	//mail program wants full path to file included name
	//My report file name is always different so I define it in TestListener
	
	//public static String attachmentPath="s:/Reports/Report.zip";
	//public static String attachmentName="Report.zip";	
	
	
	
	
	
	
	
	
	
}
