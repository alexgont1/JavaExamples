import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingHTML {

	public static void main(String[] args) throws IOException {
		
		//path to file
		File f = new File("S:\\eclipse\\workspace\\Files\\MyHTML.html");
		FileWriter fw = new FileWriter(f,false);		
		BufferedWriter writer = new BufferedWriter(fw);
		
		//write inside the file	
	
		writer.write("<html><body><title>Alex-QA</title><h1>Learning Java</h1></body></html>");
	

			
		//close stream
		writer.close();
		System.out.println("File created");
			
	}

}