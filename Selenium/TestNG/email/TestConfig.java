

public class TestConfig{

	public static String server="smtp.gmail.com";
	public static String from = "YOURemail@mail.com";
	public static String password = "YOURpass";
	public static String[] to ={"YOURemail@mail.com"};//use ", test@mail.com..." to add more
	public static String subject = "Test Report";	
	public static String messageBody ="TestMessage";
	
	//attPath to zip files for report
	public static String attPath="s:/Reports";
	
	//mail program wants full path to file included name
	//My report file name is always different so I define it in TestListener
	
	//public static String attachmentPath="s:/Reports/Report.zip";
	//public static String attachmentName="Report.zip";	
	
	
	
	
	
	
	
	
	
}
