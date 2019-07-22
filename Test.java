
public class Test {

	public static void main(String[] args) {

		try {//begin of catching block for errors
		System.out.println("Beginning");		

		int divide = 10/0;
		System.out.println(divide);
		}//end of catching block
		//(Throwable is SUPER class to catch any Error):
		//catch(Throwable t) {//what to do with errors in 'try' block
		//OR: 
		catch(Exception e){
			
			//for Selenium example:
			//didn't find element on web page, do:
			//1.screenshot
			//2.create e-mail with screenshot
			//3.error message put in e-mail subject
			
			System.out.println("Error!");
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		//if you have something that you must do mandatory
		//no matter do you have error or not
		//for example - close file or DB connection
		//you must add block that will work always:
		finally {
			System.out.println("Everything is closed!");
		}
		
		System.out.println("Ending");

	}

}
