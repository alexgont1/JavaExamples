import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingFiles {

	public static void main(String[] args) throws IOException {
		
		//path to file
		File f = new File("S:\\eclipse\\workspace\\Files\\MyText.txt");
		//import java.io.File in error context menu
		
		//with such approach file will be overwritten always:
		//FileWriter fw = new FileWriter(f);
		//use 'f' to chain to line 11 
		//add FileWriter + add Except. from context menu
		
		//to add new info in file use such approach:
		FileWriter fw = new FileWriter(f,true);
		
		BufferedWriter writer = new BufferedWriter(fw);
		//use 'fw' to chain to line 15 
		
		//write inside the file		
		writer.write("1st line");
		writer.newLine();
		writer.write("2nd line");
		writer.newLine();
		writer.write("3rd line");
		writer.newLine();
		
		//close stream
		writer.close();
		System.out.println("File created");
		
	}

}
