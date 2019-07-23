import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFiles {

	public static void main(String[] args) throws IOException {
		
		//connecting stream
		File f = new File("S:\\eclipse\\workspace\\Files\\MyText.txt");
		FileReader fr = new FileReader(f);
		BufferedReader reader = new BufferedReader(fr); 
		
		//read text file
		//System.out.println(reader.readLine());
		
		//loop to read all lines
		String line = null;
		while((line = reader.readLine())!=null) {
			System.out.println(line);
		}
		
		
		//close stream
		reader.close();
	}

}
