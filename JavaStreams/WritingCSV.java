import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingCSV {

	public static void main(String[] args) throws IOException {
			
		//path to file
		File f = new File("S:\\eclipse\\workspace\\Files\\MyCSV.csv");
		FileWriter fw = new FileWriter(f,false);		
		BufferedWriter writer = new BufferedWriter(fw);
		
		//write inside the file	
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				
				int num = (int) (Math.random()*100);
				writer.write(num+",");
			}
			writer.newLine();
		}

			
		//close stream
		writer.close();
		System.out.println("File created");
			
	}

}
